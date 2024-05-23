const noble = require("@abandonware/noble");

// 替换为您的SensorTag的MAC地址
const SENSOR_TAG_UUID = "8dd9badfcf0cd1cd56e7f8bb813a344b".toLowerCase();

// UUIDs for the temperature service and characteristics
const TEMP_SERVICE_UUID = "f000aa00-0451-4000-b000-000000000000";
const TEMP_DATA_UUID = "f000aa01-0451-4000-b000-000000000000";
const TEMP_CONFIG_UUID = "f000aa02-0451-4000-b000-000000000000";

// 监听蓝牙状态变化
noble.on("stateChange", (state) => {
  if (state === "poweredOn") {
    console.log("开始扫描...");
    noble.startScanning([TEMP_SERVICE_UUID], false);
  } else {
    noble.stopScanning();
  }
});

// 发现设备时触发
noble.on("discover", (peripheral) => {
  if (peripheral.address === SENSOR_TAG_UUID) {
    console.log(`找到设备：${peripheral.advertisement.localName}`);
    noble.stopScanning();
    connectAndSetUp(peripheral);
  }
});

// 连接和设置设备
function connectAndSetUp(peripheral) {
  peripheral.connect((error) => {
    if (error) {
      console.error("连接设备时出错:", error);
      return;
    }
    console.log("已连接到设备:", peripheral.advertisement.localName);

    peripheral.discoverSomeServicesAndCharacteristics(
      [TEMP_SERVICE_UUID],
      [TEMP_DATA_UUID, TEMP_CONFIG_UUID],
      (error, services, characteristics) => {
        if (error) {
          console.error("发现服务和特征时出错:", error);
          return;
        }
        enableTemperatureSensor(characteristics);
      }
    );
  });

  peripheral.on("disconnect", () => {
    console.log("设备已断开连接");
  });
}

// 启用温度传感器
function enableTemperatureSensor(characteristics) {
  const tempConfigCharacteristic = characteristics.find(
    (c) => c.uuid === TEMP_CONFIG_UUID
  );
  const tempDataCharacteristic = characteristics.find(
    (c) => c.uuid === TEMP_DATA_UUID
  );

  if (!tempConfigCharacteristic || !tempDataCharacteristic) {
    console.error("未找到温度特征值");
    return;
  }

  tempConfigCharacteristic.write(Buffer.from([0x01]), false, (error) => {
    if (error) {
      console.error("启用温度传感器时出错:", error);
      return;
    }
    console.log("温度传感器已启用");
    readTemperatureData(tempDataCharacteristic);
  });
}

// 读取温度数据
function readTemperatureData(tempDataCharacteristic) {
  tempDataCharacteristic.read((error, data) => {
    if (error) {
      console.error("读取温度数据时出错:", error);
      return;
    }
    console.log("温度数据:", data.toString("hex"));
  });
}
