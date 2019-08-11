package com.hanhan.service;

import com.hanhan.bean.Custom;
import com.hanhan.bean.CustomExample;
import com.hanhan.mapper.CustomMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {
    @Autowired
    CustomMapper customMapper;
    @Override
    public Custom queryCustomById(String id) {
        CustomExample customExample = new CustomExample();
        customExample.createCriteria().andCustomIdEqualTo(id);
        List<Custom> customs = customMapper.selectByExample(customExample);
        return customs.get(0);
    }
}
