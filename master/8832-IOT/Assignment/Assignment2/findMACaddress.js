const noble = require("@abandonware/noble");

// 开始扫描
noble.on("stateChange", (state) => {
  if (state === "poweredOn") {
    console.log("开始扫描...");
    noble.startScanning();
  } else {
    noble.stopScanning();
  }
});

// 发现设备时触发
noble.on("discover", (peripheral) => {
  const localName = peripheral.advertisement.localName || "undefined";
  const macAddress = peripheral.address || peripheral.id || "undefined"; // 尝试使用其他属性

  console.log("发现设备:");
  console.log("名称:", localName);
  console.log("MAC地址:", macAddress);

  // 打印出更多的设备信息以帮助调试
  console.log("广告数据:", peripheral.advertisement);
  console.log("RSSI:", peripheral.rssi);
  console.log("服务UUIDs:", peripheral.advertisement.serviceUuids);

  // 打印出所有属性以调试
  console.log("所有属性:", peripheral);

  // 如果找到目标设备，停止扫描
  if (localName === "CC2650 SensorTag") {
    noble.stopScanning();
  }
});
