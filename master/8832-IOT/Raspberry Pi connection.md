### Part1: Raspberry Pi connection 

1. 现有设备

    1. raspberry Pi （自带WiFi）+ 充电器
    2. micro SD 读卡器+SD卡
    3. sensor tag (传感器)

2. 软件安装

3. 连接（无用户名密码）

    1. 查找自己的raspberry Pi名字（查看电脑WiFi列表comit195)，或找老师查看

    2. 获取自己的raspberry Pi的ip地址：

        1. 下载Net Ananyzer App,
        2. 扫描附近的设备可获得ip地址（127.20.10.4）

    3. 安装MQTT移动端app

        1. 下载MyMQTT

        2. 设置MQTT协议broker的服务器主机和端口

            1. 使用hiveMQ 的public broker

                https://www.hivemq.com/mqtt/public-mqtt-broker/

            2.  broker主机：broker.hivemq.com

            3. TCP Port: 1883

        3. 创建topic: /unitec/iot

        4. 订阅和发布测试

    4. 使用raspberry Pi

        1. 手机连接学校WiFi，打开热点

        2. 电脑连接手机热点

        3. 电脑打开终端，执行linux命令使用raspberry Pi

            1. 连接raspberry Pi

                ```bash
                shh comitup@127.20.10.4  # raspberry Pi ip address
                ```

                ```bash
                password: comitup
                ```

            2. 安装消息代理（服务器）软件mosquito和其命令行工具client

                ```
                sudo apt-get install mosquitto 
                ```

                ```
                sudo apt-get install mosquitto-clients
                ```

            3. 发布消息

                ```bash
                # mosquitto_pub -h 主机 -p 端口 -t topic  -m 消息内容
                mosquitto_pub -h broker.hivemq.com -p 1883 -t "/unitec/iot"  -m "hello world"
                ```

                此时手机的MyMQTT中就能看到发布的消息，说明发布成功

            4. 订阅消息

                ```bash
                # mosquitto_sub -h 主机 -p 端口 -t topic 
                mosquitto_sub -h broker.hivemq.com -p 1883 -t "/unitec/iot" 
                ```

                此时手机的MyMQTT发布一条消息后，终端接口能显示消息，说明订阅成功

            5. 使用终端进行订阅和发布验证： 开启2个终端界面，同时连接自己的raspberry Pi。或者组内的成员各自链接相同的raspberry Pi，一个终端订阅，另一个终端发布消息。

4. 连接（设置用户名密码）

    1. 连接上raspberry Pi（步骤同上）

    2. 打开mosquitto配置文件

        ```bash
        sudo nano /etc/mosquitto/mosquitto.conf
        ```

    3. 添加配置内容

        ```bash
        listener 1883
        allow_anonymous false
        password_file /etc/mosquitto/pwfile
        ```

    4. 保存修改，ctl+X --->Y ---->Enter

    5. 进入用户信息所在的文件夹

        ```bash
        cd /etc/mosquitto
        ```

    6. 写入用户名和密码

        ```bash
        sudo mosquitto_passwd -c pwfile robert #用户名
        ```

        ```bash
        Password: robert #密码
        ```

    7. 查看是否创建

        ```bash
        cat pwfile
        ```

    8. 退出当前文件夹

        ```bash
        cd
        ```

    9. 重启mosquito服务器

        ```bash
        sudo systemctl restart mosquitto.service
        ```

    10.  测试配置是否成功，使用localhost本机为服务器（127.0.0.1）

        ```bash
        mosquitto_pub -h 127.0.0.1 -p 1883 -t "test" -m "test" -u robert -P robert   # 注意密码的这个-P是大写
        ```

    11. 新开一个终端窗口，连接上相同的raspberry Pi，并订阅消息，查看是否能接收到消息

        ```bash
        mosquitto_sub -h 127.0.0.1 -p 1883 -t "test" -u robert -P robert   # 注意密码的这个-P是大写
        ```

    12. 在MyMQTT app中测试：更改上面的host ip地址（broker.hivemq.com)即可

        ```bash
        mosquitto_pub -h broker.hivemq.com -p 1883 -t "test" -m "test" -u robert -P robert   # 发布
        ```

        ```bash
        mosquitto_sub -h broker.hivemq.com -p 1883 -t "test" -u robert -P robert   # 订阅
        ```

5. Node-RED工具基础使用

    1. 打开终端，并连接上raspberry Pi（步骤同上）

    2. 打开Node-RED官网https://nodered.org/docs/getting-started/raspberrypi

    3. 安装Node-RED服务器到raspberry Pi， copy代码到终端安装

        ```bash
        bash <(curl -sL https://raw.githubusercontent.com/node-red/linux-installers/master/deb/update-nodejs-and-nodered)
        ```

    4. 运行Node-RED服务器

        ```
        node-red-start
        ```

    5. 浏览器打开工作界面： 地址栏输入raspberry Pi的ip地址和端口：127.20.10.4:1880

    6. 输入用户名和密码即可使用Node-RED的界面了

    7. dashboard的使用

        1. Menu--->Manage palette ---->install ---->search dashboard 安装
        2. 左侧标签新增的dashboard栏使用即可
        3. dashboard页面地址：127.20.10.4:1880/ui

6. Node-RED工具高级使用

    更新中...............
    
    

### Part 2:  sensorTag + Raspberry PI + Node-red

#### Raspberry Pi SensorTag 数据采集和存储

本文档详细说明了在 Raspberry Pi 上安装必要的软件包，创建虚拟环境，扫描蓝牙设备，初始化 SQLite 数据库，以及编写和运行 Python 脚本以收集和存储 SensorTag 数据的完整步骤。

1. 安装必要的软件包：
    ```sh
    sudo apt-get update
    sudo apt-get install python3-pip python3-venv bluez sqlite3
    ```

2. 创建虚拟环境并安装 bluepy：
    ```sh
    python3 -m venv ~/sensor_env
    source ~/sensor_env/bin/activate
    pip install bluepy
    ```

3. 扫描蓝牙设备以获取 MAC 地址：
    ```sh
    sudo hciconfig hci0 up
    sudo hcitool lescan
    ```
    记录你的 SensorTag 的 MAC 地址（例如：98:07:2D:31:49:83）。

4. 创建并初始化 SQLite 数据库：
    ```sh
    sqlite3 sensordata.db
    ```
    创建 SensorData 表：
    ```sql
    DROP TABLE IF EXISTS SensorData;
    CREATE TABLE SensorData (
        id INTEGER PRIMARY KEY,
        timestamp DATETIME DEFAULT CURRENT_TIMESTAMP,
        temperature REAL,
        humidity REAL,
        accel_x REAL,
        accel_y REAL,
        accel_z REAL,
        gyro_x REAL,
        gyro_y REAL,
        gyro_z REAL,
        mag_x REAL,
        mag_y REAL,
        mag_z REAL,
        light REAL,
        battery REAL
    );
    ```
    退出 SQLite 命令行工具：
    ```sh
    .exit
    ```

5. 编写并运行 Python 脚本：
    创建一个新的 Python 脚本文件，例如 `collect_data.py`，内容如下：
    ```python
    import sys
    import sqlite3
    from bluepy import sensortag
    
    def save_to_db(data):
        # 连接到数据库并保存数据
        conn = sqlite3.connect('sensordata.db')
        c = conn.cursor()
        c.execute("""INSERT INTO SensorData (
                        temperature, humidity, accel_x, accel_y, accel_z, 
                        gyro_x, gyro_y, gyro_z, mag_x, mag_y, mag_z, 
                        light, battery) 
                     VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)""",
                  (data['temperature'], data['humidity'], 
                   data['accel'][0], data['accel'][1], data['accel'][2], 
                   data['gyro'][0], data['gyro'][1], data['gyro'][2], 
                   data['mag'][0], data['mag'][1], data['mag'][2], 
                   data['light'], data['battery']))
        conn.commit()
        conn.close()
    
    def main(mac):
        # 初始化传感器并启用所有可用传感器
        tag = sensortag.SensorTag(mac)
        tag.IRtemperature.enable()
        tag.humidity.enable()
        tag.accelerometer.enable()
        tag.gyroscope.enable()
        tag.magnetometer.enable()
        tag.lightmeter.enable()
        tag.battery.enable()
        
        try:
            while True:
                tag.waitForNotifications(1.0)
                # 读取传感器数据
                data = {
                    'temperature': tag.IRtemperature.read()[0],
                    'humidity': tag.humidity.read()[0],
                    'accel': tag.accelerometer.read(),
                    'gyro': tag.gyroscope.read(),
                    'mag': tag.magnetometer.read(),
                    'light': tag.lightmeter.read(),
                    'battery': tag.battery.read()
                }
                # 打印读取的数据
                print(f"Temperature: {data['temperature']} C")
                print(f"Humidity: {data['humidity']} %")
                print(f"Accelerometer: {data['accel']}")
                print(f"Gyroscope: {data['gyro']}")
                print(f"Magnetometer: {data['mag']}")
                print(f"Light: {data['light']}")
                print(f"Battery: {data['battery']}")
                # 保存数据到数据库
                save_to_db(data)
        except KeyboardInterrupt:
            tag.disconnect()
    
    if __name__ == "__main__":
        if len(sys.argv) != 2:
            print("Usage: python3 collect_data.py <MAC_ADDRESS>")
            sys.exit(1)
    
        mac = sys.argv[1]
        main(mac)
    ```

6. 运行 Python 脚本以收集数据：
    ```sh
    python3 collect_data.py 98:07:2D:31:49:83
    ```

7. 查看数据库中的数据：
    退出虚拟环境：
    ```sh
    deactivate
    ```
    打开 SQLite 数据库并查看数据：
    ```sh
    sqlite3 sensordata.db
    ```
    设置显示表头和分隔符：
    ```sql
    .headers on
    .mode column
    ```
    运行查询命令查看数据：
    ```sql
    SELECT * FROM SensorData;
    ```
    退出 SQLite 命令行工具：
    ```sh
    .exit
    ```


