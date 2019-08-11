package com.hanhan.service.device;

import com.github.pagehelper.PageHelper;
import com.hanhan.bean.Device;
import com.hanhan.bean.DeviceExample;
import com.hanhan.bean.ResponseVo;
import com.hanhan.mapper.DeviceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceListListServiceImpl implements DeviceListService {

    @Autowired
    DeviceMapper deviceMapper;

    /**
     *带分页查询的service层
     */
    @Override
    public ResponseVo<Device> queryAllDevicesByPage(int page, int rows) {
        DeviceExample deviceExample = new DeviceExample();
        //查询数据的总数
        int total = (int) deviceMapper.countByExample(deviceExample);
        //数据分页
        PageHelper.startPage(page,rows);
        //查询所有数据
        List<Device> devices = deviceMapper.queryAllDevices();
        //获得状态实例
        ResponseVo responseVo = new ResponseVo();
        responseVo.setRows(devices);
        responseVo.setTotal(total);
        return responseVo;
    }

    @Override
    public int insert(Device record) {
        return deviceMapper.insert(record);
    }

    @Override
    public int updateByPrimaryKey(Device record) {
        return deviceMapper.updateByPrimaryKey(record);
    }

    @Override
    public int deleteDeviceByPrimaryKey(String[] ids) {
        int delete = 0;
        for (String id : ids) {
            delete += deviceMapper.deleteByPrimaryKey(id);
        }
        return delete;
    }

    @Override
    public List<Device> selectByExample(DeviceExample example) {
        return deviceMapper.selectByExample(example);
    }

    @Override
    public ResponseVo<Device> fuzzyQueryByDeviceId(int page,int rows,DeviceExample example) {
        ResponseVo<Device> responseVo = new ResponseVo<>();
        int total = (int) deviceMapper.countByExample(example);
        PageHelper.startPage(page,rows);
        List<Device> devices = deviceMapper.selectByExample(example);
        responseVo.setRows(devices);
        responseVo.setTotal(total);
        return responseVo;
    }

    @Override
    public ResponseVo<Device> fuzzyQueryByDeviceName(int page, int rows, DeviceExample example) {
        ResponseVo<Device> responseVo = new ResponseVo<>();
        int total = (int) deviceMapper.countByExample(example);
        PageHelper.startPage(page,rows);
        List<Device> devices = deviceMapper.selectByExample(example);
        responseVo.setRows(devices);
        responseVo.setTotal(total);
        return responseVo;
    }

    @Override
    public ResponseVo<Device> fuzzyQueryByDeviceTypeName(int page, int rows, String searchValue) {
        ResponseVo<Device> responseVo = new ResponseVo<>();
        DeviceExample deviceExample = new DeviceExample();
        int total = (int) deviceMapper.countByExample(deviceExample);
        PageHelper.startPage(page,rows);
        List<Device> devices = deviceMapper.fuzzyQueryByDeviceTypeName(searchValue);
        responseVo.setRows(devices);
        responseVo.setTotal(total);
        return responseVo;
    }
}
