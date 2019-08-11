package com.hanhan.service.device;

import com.hanhan.bean.*;


public interface DeviceCheckService {
    //查询数据
    ResponseVo<DeviceCheck> queryAllDeviceCheckByPage(int page,int rows);
    //添加数据
    int insertDeviceCheck(DeviceCheck record);
    //编辑数据
    int updateByPrimaryKey(DeviceCheck record);
    //删除数据
    int deleteByPrimaryKey(String[] ids);
    //模糊查询通过设备例检的Id
    ResponseVo<DeviceCheck> fuzzyQueryByDeviceCheckId(int page,int rows,String searchValue);
    //模糊查询通过设备例检的Id
    ResponseVo<DeviceCheck> fuzzyQueryByDeviceName(int page,int rows,String searchValue);
}
