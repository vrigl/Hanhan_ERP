package com.hanhan.controller.manufacture;

import com.hanhan.bean.*;
import com.hanhan.service.manufacture.ManufactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("manufacture")
public class ManufactureController {
    @Autowired
    ManufactureService manufactureService;


    @RequestMapping("get_data")
    @ResponseBody
    public List<Manufacture> getData(){
        List<Manufacture> data = manufactureService.getData();
        return data;
    }


    @RequestMapping("find")
    public String find(HttpSession httpSession){
        ArrayList<String> sysPermissionList = new ArrayList<>();
        sysPermissionList.add("manufacture:add");
        sysPermissionList.add("manufacture:edit");
        sysPermissionList.add("manufacture:delete");
        httpSession.setAttribute("sysPermissionList",sysPermissionList);
        return "/WEB-INF/jsp/manufacture_list.jsp";
    }


    @RequestMapping("list")
    @ResponseBody
    public ResponseVo<Manufacture> queryManufactureByPageAndRows(int page,int rows){
        return manufactureService.queryManufactureByPageAndRows(page,rows);
    }


    @RequestMapping("get/{manufactureSn}")
    @ResponseBody
    public Manufacture get(@PathVariable("manufactureSn") String manufactureSn){
        return manufactureService.queryByManufactureSn(manufactureSn);
    }


    @RequestMapping("add_judge")
    @ResponseBody
    public String addJudge(){
        return "";
    }


    @RequestMapping("add")
    public String add(HttpSession httpSession){

        return "/WEB-INF/jsp/manufacture_add.jsp";
    }



    @RequestMapping("edit_judge")
    @ResponseBody
    public String editJudge(){
        return "";
    }


    @RequestMapping("edit")
    public String edit(){
        return "/WEB-INF/jsp/manufacture_edit.jsp";
    }


    @RequestMapping("update_all")
    @ResponseBody
    public Data upDateAll(Manufacture manufacture){
        boolean result = manufactureService.updateManufacture(manufacture);
        Data data = new Data();
        if(result){
            data.setMsg("OK");
            data.setStatus(200);
        }else {
            data.setMsg("该客户编号已经存在，请更换客户编号！");
        }
        return data;
    }


    @RequestMapping("delete_judge")
    @ResponseBody
    public String deleteJudge(){
        return "";
    }



    @RequestMapping("delete_batch")
    @ResponseBody
    public Data deleteJudge(String[] ids){
        boolean result = manufactureService.deleteManufacture(ids);
        Data data = new Data();
        if(result){
            data.setMsg("OK");
            data.setStatus(200);
        }
        return data;
    }


    @RequestMapping("insert")
    @ResponseBody
    public Data insert(Manufacture manufacture){
        boolean result = manufactureService.insertManufacture(manufacture);
        Data data = new Data();
        if(result){
            data.setMsg("新增客户成功");
            data.setStatus(200);
        }else {
            data.setMsg("该客户编号已经存在，请更换客户编号！");
        }
        return data;
    }



    @RequestMapping("search_manufacture_by_manufactureSn")
    @ResponseBody
    public ResponseVo<Manufacture> searchManufactureByManufactureSn(String searchValue,int page,int rows){
        return manufactureService.searchManufactureByManufactureSn(searchValue,page,rows);
    }
    @RequestMapping("search_manufacture_by_manufactureTechnologyName")
    @ResponseBody
    public ResponseVo<Manufacture> searchManufactureByManufactureTechnologyName(String searchValue,int page,int rows){
        return manufactureService.searchManufactureByManufactureTechnologyName(searchValue,page,rows);
    }
    @RequestMapping("search_manufacture_by_manufactureOrderId")
    @ResponseBody
    public ResponseVo<Manufacture> searchManufactureByManufactureOrderId(String searchValue,int page,int rows){
        return manufactureService.searchManufactureByManufactureOrderId(searchValue,page,rows);
    }
}
