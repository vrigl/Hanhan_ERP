package com.hanhan.mapper;

import com.hanhan.bean.Device;
import com.hanhan.bean.DeviceCheck;
import com.hanhan.bean.DeviceCheckExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DeviceCheckMapper {

    List<DeviceCheck> queryAllDeviceCheck();

    List<DeviceCheck> fuzzyQueryByDeviceCheckId(String searchValue);

    List<DeviceCheck> fuzzyQueryByDeviceName(String searchValue);

    long countByExample(DeviceCheckExample example);

    int deleteByExample(DeviceCheckExample example);

    int deleteByPrimaryKey(String deviceCheckId);

    int insert(DeviceCheck record);

    int insertSelective(DeviceCheck record);

    List<DeviceCheck> selectByExample(DeviceCheckExample example);

    DeviceCheck selectByPrimaryKey(String deviceCheckId);

    int updateByExampleSelective(@Param("record") DeviceCheck record, @Param("example") DeviceCheckExample example);

    int updateByExample(@Param("record") DeviceCheck record, @Param("example") DeviceCheckExample example);

    int updateByPrimaryKeySelective(DeviceCheck record);

    int updateByPrimaryKey(DeviceCheck record);
}