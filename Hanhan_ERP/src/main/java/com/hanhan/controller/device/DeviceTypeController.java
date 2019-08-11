package com.hanhan.controller.device;

import com.hanhan.bean.*;
import com.hanhan.service.device.DeviceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("deviceType")
public class DeviceTypeController {
    @Autowired
    DeviceTypeService deviceTypeService;


    /**
     *获取DeviceType数据
     */
    @RequestMapping("list")
    @ResponseBody
    public ResponseVo SelectAllDeviceType(int page, int rows){
        ResponseVo<DeviceType> deviceTypeResponseVo = deviceTypeService.selectDeviceTypeByExample(page, rows);
        return deviceTypeResponseVo;
    }

    /**
     * 添加
     */
    @RequestMapping("add_judge")
    @ResponseBody
    public String addJudge(){
        return "";
    }

    @RequestMapping("add")
    public String entryAdd(){
        return "/WEB-INF/jsp/deviceType_add.jsp";
    }

    @RequestMapping("insert")
    @ResponseBody
    public Data insertDeviceType(DeviceType deviceType){
        Data data = new Data();
        int insert = deviceTypeService.insertDeviceType(deviceType);
        if(insert == 1){
            data.setStatus(200);
            data.setMsg("ok");
            data.setData(null);
        }else {
            data.setStatus(400);
            data.setMsg("Not OK");
            data.setMsg(null);
        }
        return data;
    }

    /**
     * 编辑
     */
    @RequestMapping("edit_judge")
    @ResponseBody
    public String editJudge(){
        return "";
    }
    @RequestMapping("edit")
    public String editDeviceType(){
        return "/WEB-INF/jsp/deviceType_edit.jsp";
    }
    @RequestMapping("update")
    @ResponseBody
    public Data updateDeviceType(DeviceType deviceType){
        Data data = new Data();
        int update = deviceTypeService.updateByPrimaryKey(deviceType);
        if(update == 1){
            data.setStatus(200);
            data.setMsg("ok");
            data.setData(null);
        }else {
            data.setStatus(500);
            data.setMsg("Not OK");
            data.setMsg(null);
        }
        return data;
    }

    /**
     * 删除逻辑
     */
    @RequestMapping("delete_judge")
    @ResponseBody
    public String deleteJudge(){
        return "";
    }

    @RequestMapping("delete_batch")
    @ResponseBody
    public Data deleteDeviceType(String[] ids){
        Data data = new Data();
        int delete = deviceTypeService.deleteByPrimaryKey(ids);
        if(delete >= 1){
            data.setStatus(200);
            data.setMsg("ok");
            data.setData(null);
        }else {
            data.setStatus(302);
            data.setMsg("Not OK");
            data.setMsg(null);
        }
        return data;
    }
    /**
     *获取设备信息
     */
    @RequestMapping("get_data")
    @ResponseBody
    public List<DeviceType> getData(){
        return deviceTypeService.getData();
    }

    /**
     * rest风格 根据id查询设备种类
     */
    @RequestMapping("get/{id}")
    @ResponseBody
    public DeviceType queryDeviceTypeById(@PathVariable("id") String id){
        DeviceType deviceType = deviceTypeService.selectDeviceTypeById(id);
        return deviceType;

    }

    /**
     * 编辑DeviceType信息
     */
    @RequestMapping("update_all")
    @ResponseBody
    public Data updateAllDeviceType(DeviceType deviceType){
        Data data = new Data();
        int update = deviceTypeService.updateByPrimaryKeySelective(deviceType);
        if(update == 1){
            data.setStatus(200);
            data.setMsg("ok");
            data.setData(null);
        }else {
            data.setStatus(500);
            data.setMsg("Not OKyaya");
            data.setMsg(null);
        }
        return data;
    }

    /**
     * 模糊查询逻辑 通过设备种类的id
     */
    @RequestMapping("search_deviceType_by_deviceTypeId")
    @ResponseBody
    public ResponseVo<DeviceType> fuzzyQueryByDeviceTypeId(String searchValue,int page,int rows){
        DeviceTypeExample deviceTypeExample = new DeviceTypeExample();
        deviceTypeExample.createCriteria().andDeviceTypeIdLike("%" + searchValue + "%");
        ResponseVo<DeviceType> responseVo = deviceTypeService.fuzzyQueryByDeviceTypeId(page, rows, deviceTypeExample);
        return responseVo;
    }

    /**
     * 模糊查询逻辑 通过设备种类的name
     */
    @RequestMapping("search_deviceType_by_deviceTypeName")
    @ResponseBody
    public ResponseVo<DeviceType> fuzzyQueryByDeviceTypeName(String searchValue,int page,int rows){
        DeviceTypeExample deviceTypeExample = new DeviceTypeExample();
        deviceTypeExample.createCriteria().andDeviceTypeNameLike("%" + searchValue + "%");
        ResponseVo<DeviceType> responseVo = deviceTypeService.fuzzyQueryByDeviceTypeName(page, rows, deviceTypeExample);
        return responseVo;
    }
}
