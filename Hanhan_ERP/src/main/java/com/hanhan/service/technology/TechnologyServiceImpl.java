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


    @Override
    public List<Technology> getData() {
        TechnologyExample technologyExample = new TechnologyExample();
        List<Technology> technologies = technologyMapper.selectByExample(technologyExample);
        return technologies;
    }

    @Override
    public Technology queryTechnologyById(String technologyId) {
        TechnologyExample technologyExample = new TechnologyExample();
        technologyExample.createCriteria().andTechnologyIdEqualTo(technologyId);
        List<Technology> technologies = technologyMapper.selectByExample(technologyExample);
        return technologies.remove(0);
    }
}
