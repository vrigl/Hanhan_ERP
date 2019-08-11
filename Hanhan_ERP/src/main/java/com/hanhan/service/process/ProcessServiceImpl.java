package com.hanhan.service.process;

import com.hanhan.bean.Process;
import com.hanhan.bean.ProcessExample;
import com.hanhan.mapper.ProcessMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProcessServiceImpl implements  ProcessService {
    @Autowired
    ProcessMapper processMapper;


    @Override
    public List<Process> getData() {
        ProcessExample processExample = new ProcessExample();
        List<Process> processes = processMapper.selectByExample(processExample);
        return processes;
    }

    @Override
    public Process queryProcessById(String processId) {
        ProcessExample processExample = new ProcessExample();
        processExample.createCriteria().andProcessIdEqualTo(processId);
        List<Process> processes = processMapper.selectByExample(processExample);
        return processes.remove(0);
    }
}
