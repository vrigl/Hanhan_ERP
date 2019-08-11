package com.hanhan.controller.device;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
@RequestMapping("device")
public class DeviceController {
    /**
     *加载设备台账页面
     */
    @RequestMapping("deviceList")
    public String entryDeviceList(HttpSession httpSession){
        ArrayList<String> sysPermissionList = new ArrayList<>();
        sysPermissionList.add("device:add");
        sysPermissionList.add("device:edit");
        sysPermissionList.add("device:delete");
        httpSession.setAttribute("sysPermissionList",sysPermissionList);
        return "/WEB-INF/jsp/deviceList.jsp";
    }


    /**
     * 加载设备种类页面
     */
    @RequestMapping("deviceType")
    public String entryDeviceType(HttpSession httpSession){
        ArrayList<String> sysPermissionList = new ArrayList<>();
        sysPermissionList.add("deviceType:add");
        sysPermissionList.add("deviceType:edit");
        sysPermissionList.add("deviceType:delete");
        httpSession.setAttribute("sysPermissionList",sysPermissionList);
        return "/WEB-INF/jsp/deviceType.jsp";
    }

    /**
     *加载设备例检页面
     */
    @RequestMapping("deviceCheck")
    public String entryDeviceCheck(HttpSession httpSession){
        ArrayList<String> sysPermissionList = new ArrayList<>();
        sysPermissionList.add("deviceCheck:add");
        sysPermissionList.add("deviceCheck:edit");
        sysPermissionList.add("deviceCheck:delete");
        httpSession.setAttribute("sysPermissionList",sysPermissionList);
        return "/WEB-INF/jsp/deviceCheck.jsp";
    }

    /**
     * 加载设备故障页面
     */
    @RequestMapping("deviceFault")
    public String entryDeviceFault(HttpSession httpSession){
        ArrayList<String> sysPermissionList = new ArrayList<>();
        sysPermissionList.add("deviceFault:add");
        sysPermissionList.add("deviceFault:edit");
        sysPermissionList.add("deviceFault:delete");
        httpSession.setAttribute("sysPermissionList",sysPermissionList);
        return "/WEB-INF/jsp/deviceFault.jsp";
    }

    /**
     * 加载设备维修页面
     */
    @RequestMapping("deviceMaintain")
    public String entryDeviceMaintain(HttpSession httpSession){
        ArrayList<String> sysPermissionList = new ArrayList<>();
        sysPermissionList.add("deviceMaintain:add");
        sysPermissionList.add("deviceMaintain:edit");
        sysPermissionList.add("deviceMaintain:delete");
        httpSession.setAttribute("sysPermissionList",sysPermissionList);
        return "/WEB-INF/jsp/deviceMaintain.jsp";
    }
}
