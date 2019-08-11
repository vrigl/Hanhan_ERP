package com.hanhan.service.device;

import com.hanhan.bean.DeviceType;
import com.hanhan.bean.DeviceTypeExample;
import com.hanhan.mapper.DeviceMapper;
import com.hanhan.mapper.DeviceTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceTypeServiceImpl implements DeviceTypeService {
    @Autowired
    DeviceTypeMapper deviceTypeMapper;

    @Override
    public List<DeviceType> getData() {
        DeviceTypeExample typeExample = new DeviceTypeExample();
        return deviceTypeMapper.selectByExample(typeExample);
    }
}
