package com.hanhan.service.device;

import com.hanhan.bean.*;

import java.util.List;

public interface DeviceTypeService {
    //分页查询
    ResponseVo<DeviceType> selectDeviceTypeByExample(int page , int rows);
    //添加
    int insertDeviceType(DeviceType record);
    //编辑
    int updateByPrimaryKey(DeviceType record);
    //删除
    int deleteByPrimaryKey(String[] ids);
    //获取设备信息
    List<DeviceType> getData();
    //通过id获取设备种类
    DeviceType selectDeviceTypeById(String deviceTypeId);
    //编辑选取的设备种类的信息
    int updateByPrimaryKeySelective(DeviceType record);
    //模糊查询通过设备种类的Id
    ResponseVo<DeviceType> fuzzyQueryByDeviceTypeId(int page, int rows, DeviceTypeExample example);
    //模糊查询通过设备种类的name
    ResponseVo<DeviceType> fuzzyQueryByDeviceTypeName(int page, int rows, DeviceTypeExample example);
}
