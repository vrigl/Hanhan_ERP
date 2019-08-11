package com.hanhan.service.device;

import com.hanhan.bean.Device;
import com.hanhan.bean.DeviceExample;
import com.hanhan.bean.ResponseVo;

import java.util.List;

public interface DeviceListService {
    //查询
    ResponseVo<Device> queryAllDevicesByPage(int page, int rows);
    //添加
    int insert(Device record);
    //编辑
    int updateByPrimaryKey(Device record);
    //删除
    int deleteDeviceByPrimaryKey(String[] ids);
    //回显数据查询
    List<Device> selectByExample(DeviceExample example);
    //模糊查询 通过id
    ResponseVo<Device> fuzzyQueryByDeviceId( int page,int rows,DeviceExample example);
    //模糊查询 通过DeviceName
    ResponseVo<Device> fuzzyQueryByDeviceName( int page,int rows,DeviceExample example);
    //模糊查询 通过DeviceTypeName
    ResponseVo<Device> fuzzyQueryByDeviceTypeName(int page,int rows,String searchValue);
}
