package com.hanhan.controller.device;

import com.hanhan.bean.*;
import com.hanhan.service.device.DeviceCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("deviceCheck")
public class DeviceCheckController {

    @Autowired
    DeviceCheckService deviceCheckService;

    /**
     *查询表中数据
     */
    @RequestMapping("list")
    @ResponseBody
    public ResponseVo SelectAllDeviceCheckByPage(int page,int rows){
        ResponseVo<DeviceCheck> responseVo = deviceCheckService.queryAllDeviceCheckByPage(page, rows);
        return responseVo;
    }

    /**
     * 新增逻辑
     */
    @RequestMapping("add_judge")
    @ResponseBody
    public String addJudge(){
        return "";
    }
    @RequestMapping("add")
    public String entryAdd(){
        return "/WEB-INF/jsp/deviceCheck_add.jsp";
    }
    @RequestMapping("insert")
    @ResponseBody
    public Data insertDeviceCheck(DeviceCheck deviceCheck){
        Data data = new Data();
        int insert = deviceCheckService.insertDeviceCheck(deviceCheck);
        if(insert == 1){
            data.setStatus(200);
            data.setMsg("ok");
            data.setData(null);
        }else {
            data.setStatus(302);
            data.setMsg("OKGeQiuQiu");
            data.setMsg(null);
        }
        return data;
    }

    /**
     * 编辑逻辑
     */
    @RequestMapping("edit_judge")
    @ResponseBody
    public String editJudge(){
        return "";
    }

    @RequestMapping("edit")
    public String editDeviceCheck(){
        return "/WEB-INF/jsp/deviceCheck_edit.jsp";
    }

    @RequestMapping("update")
    @ResponseBody
    public Data updateDeviceCheck(DeviceCheck deviceCheck){
        Data data = new Data();
        int update = deviceCheckService.updateByPrimaryKey(deviceCheck);
        if(update == 1){
            data.setStatus(200);
            data.setMsg("ok");
            data.setData(null);
        }else {
            data.setStatus(500);
            data.setMsg("OKGeChuiZi");
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
    public Data deleteDeviceCheck(String[] ids){
        Data data = new Data();
        int delete = deviceCheckService.deleteByPrimaryKey(ids);
        if(delete >= 1){
            data.setStatus(200);
            data.setMsg("ok");
            data.setData(null);
        }else {
            data.setStatus(302);
            data.setMsg("Not OK yy");
            data.setMsg(null);
        }
        return data;
    }
    /**
     * 模糊查询逻辑 通过设备例检编号
     */
    @RequestMapping("search_deviceCheck_by_deviceCheckId")
    @ResponseBody
    public ResponseVo<DeviceCheck> fuzzyQueryByDeviceCheckId(String searchValue, int page, int rows){

        ResponseVo<DeviceCheck> deviceResponseVo =deviceCheckService.fuzzyQueryByDeviceCheckId(page, rows, searchValue);
        return deviceResponseVo;
    }

    /**
     * 模糊查询逻辑 通过设备名称
     */
    @RequestMapping("search_deviceCheck_by_deviceName")
    @ResponseBody
    public ResponseVo<DeviceCheck> fuzzyQueryByDeviceName(String searchValue, int page, int rows){

        ResponseVo<DeviceCheck> deviceResponseVo =deviceCheckService.fuzzyQueryByDeviceName(page, rows, searchValue);
        return deviceResponseVo;
    }
}
