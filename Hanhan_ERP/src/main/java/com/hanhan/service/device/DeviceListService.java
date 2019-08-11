package com.hanhan.service.device;

import com.hanhan.bean.Device;

import java.util.List;

public interface DeviceListService {
    List<Device> getData();

    Device queryDeviceById(String deviceId);
}
