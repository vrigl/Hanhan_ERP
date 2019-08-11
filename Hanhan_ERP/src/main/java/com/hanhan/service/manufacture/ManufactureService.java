package com.hanhan.service.manufacture;

import com.hanhan.bean.Manufacture;
import com.hanhan.bean.ResponseVo;

public interface ManufactureService {
    ResponseVo<Manufacture> queryManufactureByPageAndRows(int page, int rows);
}
