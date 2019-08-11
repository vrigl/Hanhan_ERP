package com.hanhan.controller.process;

import com.hanhan.bean.Process;
import com.hanhan.service.process.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("process")
public class ProcessController {
    @Autowired
    ProcessService processService;
    @RequestMapping("get_data")
    @ResponseBody
    public List<Process> getData(){
        return processService.getData();
    }
    @RequestMapping("get/{processId}")
    @ResponseBody
    public Process get(@PathVariable("processId") String processId){
        return processService.queryProcessById(processId);
    }
}
