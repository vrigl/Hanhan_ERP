package com.hanhan.service.custom;

import com.hanhan.bean.Custom;
import com.hanhan.bean.CustomExample;
import com.hanhan.mapper.CustomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CustomServiceImpl implements CustomService {
    @Autowired
    CustomMapper customMapper;
    CustomExample customExample = new CustomExample();
    @Override
    public List<Custom> queryCustomByPageAndRows(int page, int rows) {
        customExample.createCriteria().andCustomIdBetween(String.valueOf((page-1)*rows),String.valueOf((rows+page-1)*rows));
        List<Custom> customs = customMapper.selectByExample(customExample);
        return customs;
    }

    @Override
    public boolean insertCustom(Custom custom) {
        int insert = customMapper.insert(custom);
        return insert == 1;
    }

    @Override
    public List<Custom> getData() {
        List<Custom> customs = customMapper.selectByExample(customExample);
        return customs;
    }

    @Override
    public boolean updateCustom(Custom custom) {
        int update = customMapper.updateByPrimaryKey(custom);
        return update == 1;
    }

    @Override
    public boolean deleteCustom(String[] ids) {
        int delete = 0;
        for (String id : ids) {
            delete += customMapper.deleteByPrimaryKey(id);
        }

        return delete >= 1;
    }

    @Override
    public List<Custom> searchCustomByCustomId(String searchValue, int page, int rows) {
        customExample.createCriteria().andCustomIdLike("%"+searchValue+"%");
        List<Custom> customs = customMapper.selectByExample(customExample);
        return customs;
    }

    @Override
    public List<Custom> searchCustomByCustomName(String searchValue, int page, int rows) {
        customExample.createCriteria().andCustomNameLike("%"+searchValue+"%");
        List<Custom> customs = customMapper.selectByExample(customExample);
        return customs;
    }

    @Override
    public Custom queryCustomById(String customId) {
        customExample.createCriteria().andCustomIdEqualTo(customId);
        List<Custom> customs = customMapper.selectByExample(customExample);
        return customs.remove(0);
    }
}
