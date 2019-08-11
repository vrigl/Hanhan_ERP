package com.hanhan.controller.custom;

import com.hanhan.bean.Custom;
import com.hanhan.bean.Data;
import com.hanhan.service.custom.CustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("custom")
public class CustomController {
    @Autowired
    CustomService customService;

    @RequestMapping("find")
    public String find(){
        return "/WEB-INF/jsp/custom_list.jsp";
    }

    @RequestMapping("list")
    @ResponseBody
    public List<Custom> queryCustomByPageAndRows(int page,int rows){
        List<Custom> customs = customService.queryCustomByPageAndRows(page, rows);
        return customs;
    }

    @RequestMapping("add_judge")
    @ResponseBody
    public String addJudge(){
        return "";
    }
    @RequestMapping("add")
    public String add(HttpSession httpSession){
        ArrayList<String> sysPermissionList = new ArrayList<>();
        sysPermissionList.add("order:add");
        sysPermissionList.add("order:edit");
        sysPermissionList.add("order:delete");
        httpSession.setAttribute("sysPermissionList",sysPermissionList);
        return "/WEB-INF/jsp/custom_add.jsp";
    }
    @RequestMapping("insert")
    @ResponseBody
    public Data insert(Custom custom){
        boolean result = customService.insertCustom(custom);
        Data data = new Data();
        if(result){
            data.setMsg("新增客户成功");
            data.setStatus(200);
        }else {
            data.setMsg("该客户编号已经存在，请更换客户编号！");
        }
        return data;
    }
    /*查询custom数据，用于新增用户时的回显*/
    @RequestMapping("get_data")
    @ResponseBody
    public List<Custom> getData(){
        List<Custom> data = customService.getData();
        return data;
    }
    @RequestMapping("edit_judge")
    @ResponseBody
    public String editJudge(){
        return "";
    }
    @RequestMapping("edit")
    public String edit(){
        return "/WEB-INF/jsp/custom_edit.jsp";
    }
    @RequestMapping("update_all")
    @ResponseBody
    public Data upDateAll(Custom custom){
        boolean result = customService.updateCustom(custom);
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
        boolean result = customService.deleteCustom(ids);
        Data data = new Data();
        if(result){
            data.setMsg("OK");
            data.setStatus(200);
        }
        return data;
    }
    @RequestMapping("search_custom_by_customId")
    @ResponseBody
    public List<Custom> searchCustomByCustomId(String searchValue,int page,int rows){
        List<Custom> customs = customService.searchCustomByCustomId(searchValue, page, rows);
        return customs;
    }

    @RequestMapping("search_custom_by_customName")
    @ResponseBody
    public List<Custom> searchCustomByCustomName(String searchValue,int page,int rows){
        List<Custom> customs = customService.searchCustomByCustomName(searchValue, page, rows);
        return customs;
    }
    @RequestMapping("get/{customId}")
    @ResponseBody
    public Custom get(@PathVariable("customId") String customId){
        Custom custom = customService.queryCustomById(customId);
        return custom;
    }
}
