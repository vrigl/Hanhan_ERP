package com.hanhan.service.technology;

import com.github.pagehelper.PageHelper;
import com.hanhan.bean.ResponseVo;
import com.hanhan.bean.Technology;
import com.hanhan.bean.TechnologyExample;
import com.hanhan.mapper.TechnologyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnologyServiceImpl implements TechnologyService {
    @Autowired
    TechnologyMapper technologyMapper;
    TechnologyExample technologyExample = new TechnologyExample();
    @Override
    public ResponseVo<Technology> queryTechnologyByPageAndRows(int page, int rows) {
        int total = (int)technologyMapper.countByExample(technologyExample);
        PageHelper.startPage(page,rows);
        List<Technology> technologies = technologyMapper.selectByExample(technologyExample);
        ResponseVo<Technology> technologyResponseVo = new ResponseVo<>();
        technologyResponseVo.setRows(technologies);
        technologyResponseVo.setTotal(total);
        return technologyResponseVo;
    }

    @Override
    public List<Technology> getData() {
        List<Technology> technologies = technologyMapper.selectByExample(technologyExample);
        return technologies;
    }
}
