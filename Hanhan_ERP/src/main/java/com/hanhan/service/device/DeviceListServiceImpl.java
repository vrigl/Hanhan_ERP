package com.hanhan.service.device;

import com.hanhan.bean.Device;
import com.hanhan.bean.DeviceExample;
import com.hanhan.mapper.DeviceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceListServiceImpl implements DeviceListService {
    @Autowired
    DeviceMapper deviceMapper;

    @Override
    public List<Device> getData() {
        DeviceExample deviceExample = new DeviceExample();
        return deviceMapper.selectByExample(deviceExample);
    }

    @Override
    public Device queryDeviceById(String deviceId) {
        DeviceExample deviceExample = new DeviceExample();
        deviceExample.createCriteria().andDeviceIdEqualTo(deviceId);
        List<Device> devices = deviceMapper.selectByExample(deviceExample);
        return devices.remove(0);
    }
}
