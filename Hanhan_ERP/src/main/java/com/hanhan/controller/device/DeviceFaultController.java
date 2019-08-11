package com.hanhan.controller.device;

import com.hanhan.bean.*;
import com.hanhan.service.device.DeviceFaultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("deviceFault")
public class DeviceFaultController {
    @Autowired
    DeviceFaultService deviceFaultService;

    @RequestMapping("list")
    @ResponseBody
    public ResponseVo<DeviceFault> selectAllDeviceFault(int page,int rows){
        ResponseVo<DeviceFault> deviceFaultResponseVo = deviceFaultService.selectAllDeviceFault(page, rows);
        return deviceFaultResponseVo;
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
        return "/WEB-INF/jsp/deviceFault_add.jsp";
    }
    @RequestMapping("insert")
    @ResponseBody
    public Data insertDeviceFault(DeviceFault deviceFault){
        Data data = new Data();
        int insert = deviceFaultService.insertDeviceFault(deviceFault);
        if(insert == 1){
            data.setStatus(200);
            data.setMsg("ok");
            data.setData(null);
        }else {
            data.setStatus(302);
            data.setMsg("OKQiuQiu");
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
        return "/WEB-INF/jsp/deviceFault_edit.jsp";
    }

    @RequestMapping("update")
    @ResponseBody
    public Data updateDeviceFault(DeviceFault deviceFault){
        Data data = new Data();
        int update = deviceFaultService.updateByPrimaryKey(deviceFault);
        if(update == 1){
            data.setStatus(200);
            data.setMsg("ok");
            data.setData(null);
        }else {
            data.setStatus(500);
            data.setMsg("OKJB");
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
    public Data deleteDeviceFault(String[] ids){
        Data data = new Data();
        int delete = deviceFaultService.deleteByPrimaryKey(ids);
        if(delete >= 1){
            data.setStatus(200);
            data.setMsg("ok");
            data.setData(null);
        }else {
            data.setStatus(302);
            data.setMsg("Not OK jj");
            data.setMsg(null);
        }
        return data;
    }
    /**
     * 回显信息
     */
    @RequestMapping("get_data")
    @ResponseBody
    public List<DeviceFault> getData(DeviceFaultExample deviceFaultExample){
        List<DeviceFault> deviceFaults = deviceFaultService.selectByExample(deviceFaultExample);
        return deviceFaults;
    }

    /**
     * 模糊查询逻辑 通过设备故障编号
     */
    @RequestMapping("search_deviceFault_by_deviceFaultId")
    @ResponseBody
    public ResponseVo<DeviceFault> fuzzyQueryByDeviceFaultId(String searchValue, int page, int rows){

        ResponseVo<DeviceFault> deviceResponseVo =deviceFaultService.fuzzyQueryByDeviceFaultId(page, rows, searchValue);
        return deviceResponseVo;
    }

    /**
     * 模糊查询逻辑 通过设备名称
     */
    @RequestMapping("search_deviceFault_by_deviceName")
    @ResponseBody
    public ResponseVo<DeviceFault> fuzzyQueryByDeviceName(String searchValue, int page, int rows){

        ResponseVo<DeviceFault> deviceResponseVo =deviceFaultService.fuzzyQueryByDeviceName(page, rows, searchValue);
        return deviceResponseVo;
    }
}
