package com.hanhan.controller.technology;

import com.hanhan.bean.Technology;
import com.hanhan.service.technology.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("technology")
public class TechnologyController {
    @Autowired
    TechnologyService technologyService;


    @RequestMapping("get/{technologyId}")
    @ResponseBody
    public Technology get(@PathVariable("technologyId") String technologyId){
        return technologyService.queryTechnologyById(technologyId);

    }

    @RequestMapping("get_data")
    @ResponseBody
    public List<Technology> getData(){
        List<Technology> data = technologyService.getData();
        return data;
    }
}
