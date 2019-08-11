package com.hanhan.service.device;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hanhan.bean.DeviceType;
import com.hanhan.bean.DeviceTypeExample;
import com.hanhan.bean.ResponseVo;
import com.hanhan.mapper.DeviceMapper;
import com.hanhan.mapper.DeviceTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class DeviceTypeServiceImpl implements DeviceTypeService {
    @Autowired
    DeviceTypeMapper deviceTypeMapper;

    //分页查询
    @Override
    public ResponseVo<DeviceType> selectDeviceTypeByExample(int page , int rows) {
        DeviceTypeExample deviceTypeExample = new DeviceTypeExample();

        ResponseVo<DeviceType> responseVo = new ResponseVo<>();
        //查询数据总数
         int total = (int) deviceTypeMapper.countByExample(deviceTypeExample);
        //数据分页
        PageHelper.startPage(page,rows);
        //查询所有数据
        List<DeviceType> deviceTypes = deviceTypeMapper.selectByExample(deviceTypeExample);

        responseVo.setTotal(total);
        responseVo.setRows(deviceTypes);

        return responseVo;
    }

    @Override
    public int insertDeviceType(DeviceType record) {
        return deviceTypeMapper.insert(record);
    }

    @Override
    public int updateByPrimaryKey(DeviceType record) {
        return deviceTypeMapper.updateByPrimaryKey(record);
    }

    @Override
    public int deleteByPrimaryKey(String[] ids) {
        int delete = 0;
        for (String id : ids) {
            delete += deviceTypeMapper.deleteByPrimaryKey(id);
        }
        return delete;
    }

    @Override
    public List<DeviceType> getData() {
        DeviceTypeExample typeExample = new DeviceTypeExample();
        return deviceTypeMapper.selectByExample(typeExample);
    }

    @Override
    public DeviceType selectDeviceTypeById(String deviceTypeId) {
        return deviceTypeMapper.selectByPrimaryKey(deviceTypeId);
    }

    @Override
    public int updateByPrimaryKeySelective(DeviceType record) {
        return deviceTypeMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public ResponseVo<DeviceType> fuzzyQueryByDeviceTypeId(int page, int rows, DeviceTypeExample example) {
        ResponseVo<DeviceType> responseVo = new ResponseVo<>();
        //分页
        PageHelper.startPage(page,rows);
        //查询
        List<DeviceType> deviceTypes = deviceTypeMapper.selectByExample(example);
        //获得数据的总数
        PageInfo<DeviceType> deviceTypePageInfo = new PageInfo<>(deviceTypes);
        int total = (int) deviceTypePageInfo.getTotal();
        //set状态值
        responseVo.setTotal(total);
        responseVo.setRows(deviceTypes);
        return responseVo;
    }

    @Override
    public ResponseVo<DeviceType> fuzzyQueryByDeviceTypeName(int page, int rows, DeviceTypeExample example) {
        ResponseVo<DeviceType> responseVo = new ResponseVo<>();
        //分页
        PageHelper.startPage(page,rows);
        //查询
        List<DeviceType> deviceTypes = deviceTypeMapper.selectByExample(example);
        //获得数据的总数
        PageInfo<DeviceType> deviceTypePageInfo = new PageInfo<>(deviceTypes);
        int total = (int) deviceTypePageInfo.getTotal();
        //set状态值
        responseVo.setTotal(total);
        responseVo.setRows(deviceTypes);
        return responseVo;
    }
}
