package com.hanhan.controller.task;

import com.hanhan.bean.*;
import com.hanhan.service.task.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
@RequestMapping("task")
public class TaskController {

    @Autowired
    TaskService taskService;
    @RequestMapping("find")
    public String find(HttpSession httpSession){
        ArrayList<String> sysPermissionList = new ArrayList<>();
        sysPermissionList.add("task:add");
        sysPermissionList.add("task:edit");
        sysPermissionList.add("task:delete");
        httpSession.setAttribute("sysPermissionList",sysPermissionList);
        return "/WEB-INF/jsp/task_list.jsp";
    }
    @RequestMapping("list")
    @ResponseBody
    public ResponseVo<Task> queryTaskByPageAndRows(int page,int rows){
       return taskService.qeuryTaskByPageAndRows(page,rows);
    }
    @RequestMapping("add_judge")
    @ResponseBody
    public String addJudge(){
        return "";
    }
    @RequestMapping("add")
    public String add(HttpSession httpSession){

        return "/WEB-INF/jsp/task_add.jsp";
    }
    @RequestMapping("edit_judge")
    @ResponseBody
    public String editJudge(){
        return "";
    }
    @RequestMapping("edit")
    public String edit(){
        return "/WEB-INF/jsp/task_edit.jsp";
    }


    @RequestMapping("update_all")
    @ResponseBody
    public Data upDateAll(Task task){
        boolean result = taskService.updateTask(task);
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
        boolean result = taskService.deleteTask(ids);
        Data data = new Data();
        if(result){
            data.setMsg("OK");
            data.setStatus(200);
        }
        return data;
    }
    @RequestMapping("insert")
    @ResponseBody
    public Data insert(Task task){
        boolean result = taskService.insertTask(task);
        Data data = new Data();
        if(result){
            data.setMsg("新增客户成功");
            data.setStatus(200);
        }else {
            data.setMsg("该客户编号已经存在，请更换客户编号！");
        }
        return data;
    }
    @RequestMapping("search_task_by_taskId")
    @ResponseBody
    public ResponseVo<Task> searchTaskByTaskId(String searchValue,int page,int rows){
        return taskService.searchTaskByTaskId(searchValue,page,rows);
    }

    @RequestMapping("search_task_by_taskWorkId")
    @ResponseBody
    public ResponseVo<Task> searchTaskByTaskWorkId(String searchValue,int page,int rows){
        return taskService.searchTaskByTaskWorkId(searchValue,page,rows);
    }

    @RequestMapping("search_task_by_taskManufactureSn")
    @ResponseBody
    public ResponseVo<Task> searchTaskByTaskManufactureSn(String searchValue,int page,int rows){
        return taskService.searchTaskByTaskManufactureSn(searchValue,page,rows);
    }


}

