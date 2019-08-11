package com.hanhan.service.department;

import com.hanhan.bean.Department;
import com.hanhan.bean.DepartmentExample;
import com.hanhan.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    DepartmentMapper departmentMapper;


    @Override
    public List<Department> selectByExample(DepartmentExample example) {
        return departmentMapper.selectByExample(example);
    }
}
