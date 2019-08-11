package com.hanhan.service.device;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hanhan.bean.DeviceFault;
import com.hanhan.bean.DeviceFaultExample;
import com.hanhan.bean.ResponseVo;
import com.hanhan.mapper.DeviceFaultMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceFaultServiceImpl implements DeviceFaultService {

    @Autowired
    DeviceFaultMapper deviceFaultMapper;


    @Override
    public ResponseVo<DeviceFault> selectAllDeviceFault(int page, int rows) {
        ResponseVo responseVo = new ResponseVo();
        DeviceFaultExample deviceFaultExample = new DeviceFaultExample();

        int total = (int) deviceFaultMapper.countByExample(deviceFaultExample);
        PageHelper.startPage(page,rows);
        List<DeviceFault> deviceFaults = deviceFaultMapper.selectAllDeviceFault();

        responseVo.setRows(deviceFaults);
        responseVo.setTotal(total);

        return responseVo;
    }

    @Override
    public int insertDeviceFault(DeviceFault record) {
        return deviceFaultMapper.insert(record);
    }

    @Override
    public int updateByPrimaryKey(DeviceFault record) {
        return deviceFaultMapper.updateByPrimaryKey(record);
    }

    @Override
    public int deleteByPrimaryKey(String[] ids) {
        int delete = 0;
        for (String id : ids){
            delete += deviceFaultMapper.deleteByPrimaryKey(id);
        }
        return delete;
    }

    @Override
    public List<DeviceFault> selectByExample(DeviceFaultExample example) {
        return deviceFaultMapper.selectByExample(example);
    }

    @Override
    public ResponseVo<DeviceFault> fuzzyQueryByDeviceFaultId(int page, int rows, String searchValue) {
        ResponseVo<DeviceFault> responseVo = new ResponseVo<>();
        PageHelper.startPage(page, rows);
        List<DeviceFault> deviceFaults = deviceFaultMapper.fuzzyQueryByDeviceFaultId(searchValue);
        PageInfo<DeviceFault> deviceFaultPageInfo = new PageInfo<>(deviceFaults);
        int total = (int) deviceFaultPageInfo.getTotal();
        responseVo.setRows(deviceFaults);
        responseVo.setTotal(total);
        return responseVo;
    }

    @Override
    public ResponseVo<DeviceFault> fuzzyQueryByDeviceName(int page, int rows, String searchValue) {
        ResponseVo<DeviceFault> responseVo = new ResponseVo<>();
        PageHelper.startPage(page, rows);
        List<DeviceFault> deviceFaults = deviceFaultMapper.fuzzyQueryByDeviceName(searchValue);
        PageInfo<DeviceFault> deviceFaultPageInfo = new PageInfo<>(deviceFaults);
        int total = (int) deviceFaultPageInfo.getTotal();
        responseVo.setRows(deviceFaults);
        responseVo.setTotal(total);
        return responseVo;
    }
}
