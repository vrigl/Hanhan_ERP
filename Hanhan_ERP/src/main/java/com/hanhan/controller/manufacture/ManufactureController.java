package com.hanhan.controller.manufacture;

import com.hanhan.bean.Manufacture;
import com.hanhan.bean.ResponseVo;
import com.hanhan.service.manufacture.ManufactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("manufacture")
public class ManufactureController {
    @Autowired
    ManufactureService manufactureService;
    @RequestMapping("find")
    public String find(HttpSession httpSession){

        return "/WEB-INF/jsp/manufacture_list.jsp";
    }
    @RequestMapping("list")
    @ResponseBody
    public ResponseVo<Manufacture> queryManufactureByPageAndRows(int page,int rows){
        return manufactureService.queryManufactureByPageAndRows(page,rows);
    }
}
