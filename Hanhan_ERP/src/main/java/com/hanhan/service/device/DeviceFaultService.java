package com.hanhan.service.device;

import com.hanhan.bean.DeviceCheck;
import com.hanhan.bean.DeviceFault;

import com.hanhan.bean.DeviceFaultExample;
import com.hanhan.bean.ResponseVo;

import java.util.List;


public interface DeviceFaultService {
    //查询
    ResponseVo<DeviceFault> selectAllDeviceFault(int page, int rows);
    //新增
    int insertDeviceFault(DeviceFault record);
    //编辑
    int updateByPrimaryKey(DeviceFault record);
    //删除
    int deleteByPrimaryKey(String[] ids);
    //回显数据查询
    List<DeviceFault> selectByExample(DeviceFaultExample example);
    //模糊查询 通过设备故障编号
    ResponseVo<DeviceFault> fuzzyQueryByDeviceFaultId(int page, int rows, String searchValue);
    //模糊查询 通过设备名称
    ResponseVo<DeviceFault> fuzzyQueryByDeviceName(int page, int rows, String searchValue);
}
