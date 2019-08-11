package com.hanhan.controller.employee;

import com.hanhan.bean.Data;
import com.hanhan.bean.DeviceType;
import com.hanhan.bean.Employee;
import com.hanhan.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @RequestMapping("get_data")
    @ResponseBody
    public List<Employee> getData() {
        return employeeService.getData();
    }


    /**
     * rest风格 根据id查询保管人
     */
    @RequestMapping("get/{id}")
    @ResponseBody
    public Employee queryDeviceTypeById(@PathVariable("id") String id){
        Employee employee = employeeService.selectEmployeeById(id);
        return employee;

    }
}