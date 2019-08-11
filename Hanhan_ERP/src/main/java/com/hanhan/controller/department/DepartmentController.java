package com.hanhan.controller.department;

import com.hanhan.bean.Department;
import com.hanhan.bean.DepartmentExample;
import com.hanhan.service.department.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("department")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @RequestMapping("get_data")
    @ResponseBody
    public List<Department> getData(DepartmentExample example){
        List<Department> departments = departmentService.selectByExample(example);
        return departments;
    }
}
