package com.hanhan.service.device;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hanhan.bean.DeviceCheck;
import com.hanhan.bean.DeviceCheckExample;
import com.hanhan.bean.DeviceType;
import com.hanhan.bean.ResponseVo;
import com.hanhan.mapper.DeviceCheckMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceCheckServiceImpl implements DeviceCheckService {

    @Autowired
    DeviceCheckMapper deviceCheckMapper;

    @Override
    public ResponseVo<DeviceCheck> queryAllDeviceCheckByPage(int page, int rows) {
        DeviceCheckExample deviceCheckExample = new DeviceCheckExample();
        ResponseVo responseVo = new ResponseVo();
        //查询数据总数
        int total = (int) deviceCheckMapper.countByExample(deviceCheckExample);
        //数据分页
        PageHelper.startPage(page,rows);
        //查询所有数据
        List<DeviceCheck> deviceChecks = deviceCheckMapper.queryAllDeviceCheck();
        //set状态
        responseVo.setTotal(total);
        responseVo.setRows(deviceChecks);
        return responseVo;
    }

    @Override
    public int insertDeviceCheck(DeviceCheck record) {
        return deviceCheckMapper.insert(record);
    }

    @Override
    public int updateByPrimaryKey(DeviceCheck record) {
        return deviceCheckMapper.updateByPrimaryKey(record);
    }

    @Override
    public int deleteByPrimaryKey(String[] ids) {
        int delete = 0;
        for (String id : ids){
            delete += deviceCheckMapper.deleteByPrimaryKey(id);
        }
        return delete;
    }

    @Override
    public ResponseVo<DeviceCheck> fuzzyQueryByDeviceCheckId(int page, int rows, String searchValue) {
        ResponseVo<DeviceCheck> responseVo = new ResponseVo<>();
        PageHelper.startPage(page, rows);
        List<DeviceCheck> deviceChecks = deviceCheckMapper.fuzzyQueryByDeviceCheckId(searchValue);
        PageInfo<DeviceCheck> deviceCheckPageInfo = new PageInfo<>(deviceChecks);
       int total = (int) deviceCheckPageInfo.getTotal();
       responseVo.setRows(deviceChecks);
       responseVo.setTotal(total);
        return responseVo;
    }

    @Override
    public ResponseVo<DeviceCheck> fuzzyQueryByDeviceName(int page, int rows, String searchValue) {
        ResponseVo<DeviceCheck> responseVo = new ResponseVo<>();
        PageHelper.startPage(page, rows);
        List<DeviceCheck> deviceChecks = deviceCheckMapper.fuzzyQueryByDeviceName(searchValue);
        PageInfo<DeviceCheck> deviceCheckPageInfo = new PageInfo<>(deviceChecks);
        int total = (int) deviceCheckPageInfo.getTotal();
        responseVo.setRows(deviceChecks);
        responseVo.setTotal(total);
        return responseVo;
    }


}
