package com.hanhan.service.manufacture;

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
    ManufactureExample manufactureExample = new ManufactureExample();
    @Override
    public ResponseVo<Manufacture> queryManufactureByPageAndRows(int page, int rows) {
        int total = (int)manufactureMapper.countByExample(manufactureExample);
        List<Manufacture> manufactures = manufactureMapper.queryPageManufacture();
        ResponseVo<Manufacture> manufactureResponseVo = new ResponseVo<>();
        manufactureResponseVo.setRows(manufactures);
        manufactureResponseVo.setTotal(total);
        return manufactureResponseVo;
    }
}
