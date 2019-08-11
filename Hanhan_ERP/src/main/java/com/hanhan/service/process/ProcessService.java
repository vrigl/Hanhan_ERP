package com.hanhan.service.process;


import com.hanhan.bean.Process;

import java.util.List;

public interface ProcessService {
    List<Process> getData();

    Process queryProcessById(String processId);
}
