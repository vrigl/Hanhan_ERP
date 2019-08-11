package com.hanhan.controller.work;

import com.hanhan.bean.ResponseVo;
import com.hanhan.bean.Work;
import com.hanhan.service.work.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
@RequestMapping("work")
public class WorkController {
    @Autowired
    WorkService workService;
    @RequestMapping("find")
    public String find(HttpSession httpSession){
        ArrayList<String> sysPermissionList = new ArrayList<>();
        sysPermissionList.add("work:add");
        sysPermissionList.add("work:edit");
        sysPermissionList.add("work:delete");
        httpSession.setAttribute("sysPermissionList",sysPermissionList);
        return "/WEB-INF/jsp/work_list.jsp";
    }
    @RequestMapping("list")
    @ResponseBody
    public ResponseVo<Work> queryWorkByPageAndRows(int page, int rows){
        return workService.queryWorkByPageAndRows(page,rows);
    }
}
