package com.hanhan.service.department;

import com.hanhan.bean.Department;
import com.hanhan.bean.DepartmentExample;

import java.util.List;

public interface DepartmentService {

    List<Department> selectByExample(DepartmentExample example);

}
