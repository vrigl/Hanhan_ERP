package com.hanhan.service.work;

import com.github.pagehelper.PageHelper;
import com.hanhan.bean.ResponseVo;
import com.hanhan.bean.Work;
import com.hanhan.bean.WorkExample;
import com.hanhan.mapper.WorkMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkServiceImpl implements WorkService {
    @Autowired
    WorkMapper workMapper;
    WorkExample workExample = new WorkExample();
    @Override
    public ResponseVo<Work> queryWorkByPageAndRows(int page, int rows) {
        int total = (int)workMapper.countByExample(workExample);
        PageHelper.startPage(page,rows);
        List<Work> works = workMapper.selectPageWorks();
        ResponseVo<Work> workResponseVo = new ResponseVo<>();
        workResponseVo.setTotal(total);
        workResponseVo.setRows(works);
        return workResponseVo;
    }
}
