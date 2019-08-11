package com.hanhan.service.custom;

import com.github.pagehelper.PageHelper;
import com.hanhan.bean.Custom;
import com.hanhan.bean.CustomExample;
import com.hanhan.bean.ResponseVo;
import com.hanhan.mapper.CustomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.Response;
import java.util.List;
@Service
public class CustomServiceImpl implements CustomService {
    @Autowired
    CustomMapper customMapper;

    @Override
    public List<Custom> queryCustomByPageAndRows(int page, int rows) {
        CustomExample customExample = new CustomExample();
        customExample.createCriteria().andCustomIdBetween(String.valueOf((page-1)*rows),String.valueOf((rows+page-1)*rows));
        List<Custom> customs = customMapper.selectByExample(customExample);
        return customs;
    }

    @Override
    public boolean insertCustom(Custom custom) {
        CustomExample customExample = new CustomExample();
        int insert = customMapper.insert(custom);
        return insert == 1;
    }

    @Override
    public List<Custom> getData() {
        CustomExample customExample = new CustomExample();
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
        CustomExample customExample = new CustomExample();
        int delete = 0;
        for (String id : ids) {
            delete += customMapper.deleteByPrimaryKey(id);
        }

        return delete >= 1;
    }

    @Override
    public ResponseVo<Custom> searchCustomByCustomId(String searchValue, int page, int rows) {
        CustomExample customExample = new CustomExample();
        customExample.createCriteria().andCustomIdLike("%"+searchValue+"%");
        int total = (int)customMapper.countByExample(customExample);
        PageHelper.startPage(page,rows);
        List<Custom> customs = customMapper.selectByExample(customExample);

        ResponseVo<Custom> customResponseVo = new ResponseVo<>();
        customResponseVo.setRows(customs);
        customResponseVo.setTotal(total);
        return customResponseVo;
    }

    @Override
    public ResponseVo<Custom> searchCustomByCustomName(String searchValue, int page, int rows) {
        CustomExample customExample = new CustomExample();
        customExample.createCriteria().andCustomNameLike("%"+searchValue+"%");
        int  total = (int)customMapper.countByExample(customExample);
        PageHelper.startPage(page,rows);
        List<Custom> customs = customMapper.selectByExample(customExample);

        ResponseVo<Custom> customResponseVo = new ResponseVo<>();
        customResponseVo.setTotal(total);
        customResponseVo.setRows(customs);
        return customResponseVo;
    }

    @Override
    public Custom queryCustomById(String customId) {
        CustomExample customExample = new CustomExample();
        customExample.createCriteria().andCustomIdEqualTo(customId);
        List<Custom> customs = customMapper.selectByExample(customExample);
        return customs.remove(0);
    }
}
