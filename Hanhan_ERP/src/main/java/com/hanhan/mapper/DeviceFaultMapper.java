package com.hanhan.mapper;

import com.hanhan.bean.DeviceCheck;
import com.hanhan.bean.DeviceFault;
import com.hanhan.bean.DeviceFaultExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DeviceFaultMapper {

    List<DeviceFault> selectAllDeviceFault();

    List<DeviceFault> fuzzyQueryByDeviceFaultId(String searchValue);

    List<DeviceFault> fuzzyQueryByDeviceName(String searchValue);

    long countByExample(DeviceFaultExample example);

    int deleteByExample(DeviceFaultExample example);

    int deleteByPrimaryKey(String deviceFaultId);

    int insert(DeviceFault record);

    int insertSelective(DeviceFault record);

    List<DeviceFault> selectByExample(DeviceFaultExample example);

    DeviceFault selectByPrimaryKey(String deviceFaultId);

    int updateByExampleSelective(@Param("record") DeviceFault record, @Param("example") DeviceFaultExample example);

    int updateByExample(@Param("record") DeviceFault record, @Param("example") DeviceFaultExample example);

    int updateByPrimaryKeySelective(DeviceFault record);

    int updateByPrimaryKey(DeviceFault record);
}