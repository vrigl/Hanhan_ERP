package com.hanhan.service.technology;

import com.hanhan.bean.ResponseVo;
import com.hanhan.bean.Technology;

import java.util.List;

public interface TechnologyService {


    List<Technology> getData();

    Technology queryTechnologyById(String technologyId);
}
