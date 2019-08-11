package com.hanhan.service.manufacture;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hanhan.bean.Manufacture;
import com.hanhan.bean.ManufactureExample;
import com.hanhan.bean.ResponseVo;
import com.hanhan.mapper.ManufactureMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManufactureServiceImpl implements ManufactureService {
    @Autowired
    ManufactureMapper manufactureMapper;

    @Override
    public ResponseVo<Manufacture> queryManufactureByPageAndRows(int page, int rows) {
        ManufactureExample manufactureExample = new ManufactureExample();
        int total = (int)manufactureMapper.countByExample(manufactureExample);
        PageHelper.startPage(page,rows);
        List<Manufacture> manufactures = manufactureMapper.queryPageManufacture();
        ResponseVo<Manufacture> manufactureResponseVo = new ResponseVo<>();
        manufactureResponseVo.setRows(manufactures);
        manufactureResponseVo.setTotal(total);
        return manufactureResponseVo;
    }

    @Override
    public Manufacture queryByManufactureSn(String manufactureSn) {
        return manufactureMapper.queryByManufactureSn(manufactureSn);

    }

    @Override
    public boolean deleteManufacture(String[] ids) {
        int delete = 0;
        for (String id : ids) {
            delete += manufactureMapper.deleteByPrimaryKey(id);
        }
        return delete >= 1;
    }

    @Override
    public ResponseVo<Manufacture> searchManufactureByManufactureSn(String searchValue, int page, int rows) {
        PageHelper.startPage(page,rows);
        List<Manufacture> manufactures = manufactureMapper.searchManufactureByManufactureSn(searchValue);
        PageInfo<Manufacture> manufacturePageInfo = new PageInfo<>(manufactures);
        int total = (int)manufacturePageInfo.getTotal();

        ResponseVo<Manufacture> manufactureResponseVo = new ResponseVo<>();
        manufactureResponseVo.setTotal(total);
        manufactureResponseVo.setRows(manufactures);
        return manufactureResponseVo;
    }

    @Override
    public ResponseVo<Manufacture> searchManufactureByManufactureTechnologyName(String searchValue, int page, int rows) {
        PageHelper.startPage(page,rows);
        List<Manufacture> manufactures = manufactureMapper.searchManufactureByManufactureTechnologyName(searchValue);
        PageInfo<Manufacture> manufacturePageInfo = new PageInfo<>(manufactures);
        int total = (int)manufacturePageInfo.getTotal();

        ResponseVo<Manufacture> manufactureResponseVo = new ResponseVo<>();
        manufactureResponseVo.setTotal(total);
        manufactureResponseVo.setRows(manufactures);
        return manufactureResponseVo;
    }

    @Override
    public ResponseVo<Manufacture> searchManufactureByManufactureOrderId(String searchValue, int page, int rows) {

        PageHelper.startPage(page,rows);
        List<Manufacture> manufactures = manufactureMapper.searchManufactureByManufactureOrderId(searchValue);

        PageInfo<Manufacture> manufacturePageInfo = new PageInfo<>(manufactures);
        int total = (int)manufacturePageInfo.getTotal();

        ResponseVo<Manufacture> manufactureResponseVo = new ResponseVo<>();
        manufactureResponseVo.setTotal(total);
        manufactureResponseVo.setRows(manufactures);
        return manufactureResponseVo;
    }

    @Override
    public boolean insertManufacture(Manufacture manufacture) {
        int insert = manufactureMapper.insert(manufacture);
        return insert==1;
    }

    @Override
    public List<Manufacture> getData() {
        ManufactureExample manufactureExample = new ManufactureExample();
        List<Manufacture> manufactures = manufactureMapper.selectByExample(manufactureExample);
        return manufactures;
    }

    @Override
    public boolean updateManufacture(Manufacture manufacture) {
        int i = manufactureMapper.updateByPrimaryKey(manufacture);
        return i == 1;
    }


}
