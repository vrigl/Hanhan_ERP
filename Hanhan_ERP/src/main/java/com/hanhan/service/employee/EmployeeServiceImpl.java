package com.hanhan.service.employee;

import com.hanhan.bean.Employee;
import com.hanhan.bean.EmployeeExample;
import com.hanhan.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;

    @Override
    public List<Employee> getData() {
        EmployeeExample employeeExample = new EmployeeExample();
        List<Employee> employees = employeeMapper.selectByExample(employeeExample);
        return employees;
    }
}
