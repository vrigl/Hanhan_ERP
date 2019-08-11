package com.hanhan.controller.device;

import com.hanhan.bean.*;
import com.hanhan.service.device.DeviceMaintainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("deviceMaintain")
public class DeviceMaintainController {

    @Autowired
    DeviceMaintainService deviceMaintainService;

    /**
     *分页查询数据
     */
    @RequestMapping("list")
    @ResponseBody
    public ResponseVo<DeviceMaintain> selectAllDeviceMaintain(int page, int rows){
        ResponseVo<DeviceMaintain> deviceMaintainResponseVo = deviceMaintainService.queryDeviceMaintainByPage(page, rows);
        return deviceMaintainResponseVo;
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
        return "/WEB-INF/jsp/deviceMaintain_add.jsp";
    }
    @RequestMapping("insert")
    @ResponseBody
    public Data insertDeviceMaintain(DeviceMaintain deviceMaintain){
        Data data = new Data();
        int insert = deviceMaintainService.insertDeviceMaintain(deviceMaintain);
        if(insert == 1){
            data.setStatus(200);
            data.setMsg("ok");
            data.setData(null);
        }else {
            data.setStatus(302);
            data.setMsg("OKjbQiuQiu");
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
        return "/WEB-INF/jsp/deviceMaintain_edit.jsp";
    }

    @RequestMapping("update")
    @ResponseBody
    public Data updateDeviceMaintain(DeviceMaintain deviceMaintain){
        Data data = new Data();
        int update = deviceMaintainService.updateByPrimaryKey(deviceMaintain);
        if(update == 1){
            data.setStatus(200);
            data.setMsg("ok");
            data.setData(null);
        }else {
            data.setStatus(500);
            data.setMsg("OKChuiZi hehe");
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
    public Data deleteDeviceMaintain(String[] ids){
        Data data = new Data();
        int delete = deviceMaintainService.deleteByPrimaryKey(ids);
        if(delete >= 1){
            data.setStatus(200);
            data.setMsg("ok");
            data.setData(null);
        }else {
            data.setStatus(302);
            data.setMsg("Not OK qiuqiu");
            data.setMsg(null);
        }
        return data;
    }

    /**
     * 模糊查询逻辑 通过设备维修编号
     */
    @RequestMapping("search_deviceMaintain_by_deviceMaintainId")
    @ResponseBody
    public ResponseVo<DeviceMaintain> fuzzyQueryByDeviceMaintainId(String searchValue, int page, int rows){

        ResponseVo<DeviceMaintain> deviceResponseVo =deviceMaintainService.fuzzyQueryByDeviceMaintainId(page, rows, searchValue);
        return deviceResponseVo;
    }

    /**
     * 模糊查询逻辑 通过设备维修编号
     */
    @RequestMapping("search_deviceMaintain_by_deviceFaultId")
    @ResponseBody
    public ResponseVo<DeviceMaintain> fuzzyQueryByDeviceFaultId(String searchValue, int page, int rows){

        ResponseVo<DeviceMaintain> deviceResponseVo =deviceMaintainService.fuzzyQueryByDeviceFaultId(page, rows, searchValue);
        return deviceResponseVo;
    }

}
