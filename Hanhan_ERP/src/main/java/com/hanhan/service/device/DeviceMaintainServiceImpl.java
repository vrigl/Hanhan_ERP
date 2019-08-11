package com.hanhan.service.device;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hanhan.bean.DeviceCheck;
import com.hanhan.bean.DeviceMaintain;
import com.hanhan.bean.DeviceMaintainExample;
import com.hanhan.bean.ResponseVo;
import com.hanhan.mapper.DeviceMaintainMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceMaintainServiceImpl implements DeviceMaintainService {
    @Autowired
    DeviceMaintainMapper deviceMaintainMapper;

    @Override
    public ResponseVo<DeviceMaintain> queryDeviceMaintainByPage(int page, int rows) {
        ResponseVo<DeviceMaintain> responseVo = new ResponseVo<>();
        DeviceMaintainExample deviceMaintainExample = new DeviceMaintainExample();
        int total = (int) deviceMaintainMapper.countByExample(deviceMaintainExample);
        PageHelper.startPage(page,rows);
        List<DeviceMaintain> deviceMaintains = deviceMaintainMapper.selectAllDeviceMaintain();
        responseVo.setTotal(total);
        responseVo.setRows(deviceMaintains);
        return responseVo;
    }

    @Override
    public int insertDeviceMaintain(DeviceMaintain record) {
        return deviceMaintainMapper.insert(record);
    }

    @Override
    public int updateByPrimaryKey(DeviceMaintain record) {
        return deviceMaintainMapper.updateByPrimaryKey(record);
    }

    @Override
    public int deleteByPrimaryKey(String[] ids) {
        int delete = 0;
        for (String id : ids) {
            delete += deviceMaintainMapper.deleteByPrimaryKey(id);
        }
        return delete;
    }

    @Override
    public ResponseVo<DeviceMaintain> fuzzyQueryByDeviceMaintainId(int page, int rows, String searchValue) {
        ResponseVo<DeviceMaintain> responseVo = new ResponseVo<>();
        PageHelper.startPage(page,rows);
        PageInfo<DeviceMaintain> deviceMaintainPageInfo = new PageInfo<>();
        List<DeviceMaintain> deviceMaintains = deviceMaintainMapper.fuzzyQueryByDeviceMaintainId(searchValue);
        int total = (int) deviceMaintainPageInfo.getTotal();
        responseVo.setTotal(total);
        responseVo.setRows(deviceMaintains);
        return responseVo;
    }

    @Override
    public ResponseVo<DeviceMaintain> fuzzyQueryByDeviceFaultId(int page, int rows, String searchValue) {
        ResponseVo<DeviceMaintain> responseVo = new ResponseVo<>();
        PageHelper.startPage(page,rows);
        PageInfo<DeviceMaintain> deviceMaintainPageInfo = new PageInfo<>();
        List<DeviceMaintain> deviceMaintains = deviceMaintainMapper.fuzzyQueryByDeviceFaultId(searchValue);
        int total = (int) deviceMaintainPageInfo.getTotal();
        responseVo.setTotal(total);
        responseVo.setRows(deviceMaintains);
        return responseVo;
    }
}
