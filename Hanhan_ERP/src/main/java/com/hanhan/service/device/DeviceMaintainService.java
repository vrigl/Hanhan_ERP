package com.hanhan.service.device;

import com.hanhan.bean.DeviceCheck;
import com.hanhan.bean.DeviceMaintain;
import com.hanhan.bean.ResponseVo;

public interface DeviceMaintainService {
    //查询数据
    ResponseVo<DeviceMaintain> queryDeviceMaintainByPage(int page, int rows);
    //添加
    int insertDeviceMaintain(DeviceMaintain record);
    //编辑
    int updateByPrimaryKey(DeviceMaintain record);
    //删除
    int deleteByPrimaryKey(String[] ids);
    //模糊查询通过设备维修的Id
    ResponseVo<DeviceMaintain> fuzzyQueryByDeviceMaintainId(int page,int rows,String searchValue);
    //模糊查询通过设备故障的Id
    ResponseVo<DeviceMaintain> fuzzyQueryByDeviceFaultId(int page,int rows,String searchValue);
}
