Raspberry Pi connection 

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



