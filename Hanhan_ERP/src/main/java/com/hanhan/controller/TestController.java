package com.hanhan.controller;

import com.hanhan.bean.Custom;
import com.hanhan.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
    @Autowired
    TestService testService;
    @RequestMapping("queryTest/{id}")
    @ResponseBody
    public Custom queryTest(@PathVariable("id") String id){
        Custom custom = testService.queryCustomById(id);
        return custom;
    }
    @RequestMapping("/")
    public String index(){
        return "/WEB-INF/jsp/home.jsp";
    }
}
