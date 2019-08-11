package com.hanhan.controller.technology;

import com.hanhan.bean.ResponseVo;
import com.hanhan.bean.Technology;
import com.hanhan.service.technology.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("technologyPlan")
public class TechnologyPlanController {
    @Autowired
    TechnologyService technologyService;
    @RequestMapping("get_data")
    @ResponseBody
    public List<Technology> getData(){
        List<Technology> data = technologyService.getData();
        return data;
    }
    @RequestMapping("find")
    public String find(HttpSession httpSession){
        ArrayList<String> sysPermissionList = new ArrayList<>();
        sysPermissionList.add("technology:add");
        sysPermissionList.add("technology:edit");
        sysPermissionList.add("technology:delete");
        httpSession.setAttribute("sysPermissionList",sysPermissionList);
        return "/WEB-INF/jsp/technology_list.jsp";
    }
    @RequestMapping("list")
    public ResponseVo<Technology> list(int page,int rows){
        ResponseVo<Technology> technologyResponseVo = technologyService.queryTechnologyByPageAndRows(page, rows);
        return technologyResponseVo;
    }
}
