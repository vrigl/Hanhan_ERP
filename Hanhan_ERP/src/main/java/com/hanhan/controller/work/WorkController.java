package com.hanhan.controller.work;

import com.hanhan.bean.*;
import com.hanhan.service.work.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("work")
public class WorkController {
    @Autowired
    WorkService workService;

    @RequestMapping("get_data")
    @ResponseBody
    public List<Work> getData(){
        List<Work> data = workService.getData();
        return data;
    }

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


    @RequestMapping("get/{workId}")
    @ResponseBody
    public Work get(@PathVariable("workId") String workId){
        return workService.queryWorkById(workId);
    }


    @RequestMapping("add_judge")
    @ResponseBody
    public String addJudge(){
        return "";
    }


    @RequestMapping("add")
    public String add(HttpSession httpSession){

        return "/WEB-INF/jsp/work_add.jsp";
    }


    @RequestMapping("edit_judge")
    @ResponseBody
    public String editJudge(){
        return "";
    }


    @RequestMapping("edit")
    public String edit(){
        return "/WEB-INF/jsp/work_edit.jsp";
    }

    @RequestMapping("update_all")
    @ResponseBody
    public Data upDateAll(Work work){
        boolean result = workService.updateWork(work);
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
        boolean result = workService.deleteWork(ids);
        Data data = new Data();
        if(result){
            data.setMsg("OK");
            data.setStatus(200);
        }
        return data;
    }


    @RequestMapping("insert")
    @ResponseBody
    public Data insert(Work work){
        boolean result = workService.insertWork(work);
        Data data = new Data();
        if(result){
            data.setMsg("新增客户成功");
            data.setStatus(200);
        }else {
            data.setMsg("该客户编号已经存在，请更换客户编号！");
        }
        return data;
    }


    @RequestMapping("search_work_by_workId")
    @ResponseBody
    public ResponseVo<Work> searchWorkByWorkId(String searchValue,int page,int rows){
        return workService.searchWorkByWorkId(searchValue,page,rows);
    }


    @RequestMapping("search_work_by_workProduct")
    @ResponseBody
    public ResponseVo<Work> searchWorkByWorkProduct(String searchValue,int page,int rows){
        return workService.searchWorkByWorkProduct(searchValue,page,rows);
    }


    @RequestMapping("search_work_by_workDevice")
    @ResponseBody
    public ResponseVo<Work> searchWorkByWorkDevice(String searchValue,int page,int rows){
        return workService.searchWorkByWorkDevice(searchValue,page,rows);
    }


    @RequestMapping("search_work_by_workProcess")
    @ResponseBody
    public ResponseVo<Work> searchWorkByWorkProcess(String searchValue,int page,int rows){
        return workService.searchWorkByWorkProcess(searchValue,page,rows);
    }
}
