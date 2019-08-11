package com.hanhan.controller.device;

import com.hanhan.bean.Data;
import com.hanhan.bean.Device;
import com.hanhan.bean.DeviceExample;
import com.hanhan.bean.ResponseVo;
import com.hanhan.service.device.DeviceListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping("deviceList")
public class DeviceListController {

    @Autowired
    DeviceListService deviceListService;

    /**
     * 获取deviceList数据
     */
    @RequestMapping("list")
    @ResponseBody
    public ResponseVo<Device> SelectAllDevices(int page,int rows){

        ResponseVo<Device> deviceResponseVo = deviceListService.queryAllDevicesByPage(page, rows);
        return deviceResponseVo;
    }

    /**
     * 添加逻辑：1、添加页面判断
     */
    @RequestMapping("add_judge")
    @ResponseBody
    public String addJudge(){
        return "";
    }
    /**
     * 添加逻辑：2、显示添加页面
     */
    @RequestMapping("add")
    public String entryAdd(){

        return "/WEB-INF/jsp/deviceList_add.jsp";
    }


    /**
     * 添加逻辑：3、添加
     */
    @RequestMapping("insert")
    @ResponseBody
    public Data insertDeviceList(Device device){
        Data data = new Data();
        int insert = deviceListService.insert(device);

        String deviceStatusId = device.getDeviceStatusId();
        if ("1".equals(deviceStatusId)) {
            device.setDeviceStatus("良好");
        } else if ("2".equals(deviceStatusId)) {
            device.setDeviceStatus("故障");
        } else if ("3".equals(deviceStatusId)) {
            device.setDeviceStatus("维修");
        } else {
            device.setDeviceStatus("报废");
        }
        if(insert == 1) {
            data.setStatus(200);
            data.setMsg("ok");
            data.setData(null);
        }else {
            data.setStatus(302);
            data.setMsg("Not OK");
            data.setMsg(null);
        }
        return  data;
    }

    /**
     * 编辑逻辑： 1、编辑判断
     */
    @RequestMapping("edit_judge")
    @ResponseBody
    public String editJudge(){
        return "";
    }

    /**
     * 编辑逻辑： 2、编辑页面显示
     */
    @RequestMapping("edit")
    public String entryEdit(){
        return "/WEB-INF/jsp/deviceList_edit.jsp";
    }
    /**
     * 编辑逻辑： 3、编辑
     */

    @RequestMapping("update")
    @ResponseBody
    public Data updateDeviceList(Device device){
        Data data = new Data();
        int update = deviceListService.updateByPrimaryKey(device);

        String deviceStatusId = device.getDeviceStatusId();
        if ("1".equals(deviceStatusId)) {
            device.setDeviceStatus("良好");
        } else if ("2".equals(deviceStatusId)) {
            device.setDeviceStatus("故障");
        } else if ("3".equals(deviceStatusId)) {
            device.setDeviceStatus("维修");
        } else {
            device.setDeviceStatus("报废");
        }
        if(update == 1){
            data.setStatus(200);
            data.setMsg("ok");
            data.setData(null);
        }else {
            data.setStatus(302);
            data.setMsg("NotOk");
            data.setData(null);
        }
        return data;
    }

    /**
     * 删除逻辑 1、删除判断
     */
    @RequestMapping("delete_judge")
    @ResponseBody
    public String deleteJudge(){
        return "";
    }
    /**
     * 删除逻辑 1、删除
     */
    @RequestMapping("delete_batch")
    @ResponseBody
    public Data deleteDeviceList(String[] ids){
        Data data = new Data();

        int delete = deviceListService.deleteDeviceByPrimaryKey(ids);

        if(delete>=1){
            data.setStatus(200);
            data.setMsg("ok");
            data.setData(null);
        }else {
            data.setStatus(302);
            data.setMsg("NotOk");
            data.setData(null);
        }
        return data;
    }
    /**
     * 模糊查询逻辑 通过id
     */
    @RequestMapping("search_device_by_deviceId")
    @ResponseBody
    public ResponseVo<Device> fuzzyQueryByDeviceId(String searchValue,int page,int rows){
        DeviceExample deviceExample = new DeviceExample();
        deviceExample.createCriteria().andDeviceIdLike("%" + searchValue + "%");
        ResponseVo<Device> deviceResponseVo = deviceListService.fuzzyQueryByDeviceId(page, rows, deviceExample);
        return deviceResponseVo;
    }
    /**
     * 模糊查询逻辑 通过设备名称
     */
    @RequestMapping("search_device_by_deviceName")
    @ResponseBody
    public ResponseVo<Device> fuzzyQueryByDeviceName(String searchValue,int page,int rows){
        DeviceExample deviceExample = new DeviceExample();
        deviceExample.createCriteria().andDeviceNameLike("%" + searchValue + "%");
        ResponseVo<Device> deviceResponseVo = deviceListService.fuzzyQueryByDeviceName(page, rows, deviceExample);
        return deviceResponseVo;
    }
    /**
     * 模糊查询逻辑 通过设备名称
     */
    @RequestMapping("search_device_by_deviceTypeName")
    @ResponseBody
    public ResponseVo<Device> fuzzyQueryByDeviceTypeName(String searchValue,int page,int rows){

        ResponseVo<Device> deviceResponseVo = deviceListService.fuzzyQueryByDeviceTypeName(page, rows, searchValue);
        return deviceResponseVo;
    }

    /**
     * 回显数据
     */
    @RequestMapping("get_data")
    @ResponseBody
    public List<Device> getData(DeviceExample deviceExample){
        List<Device> devices = deviceListService.selectByExample(deviceExample);
        return devices;
    }
}
