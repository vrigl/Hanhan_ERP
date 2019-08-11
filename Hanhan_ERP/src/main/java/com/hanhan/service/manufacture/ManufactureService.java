package com.hanhan.service.manufacture;

import com.hanhan.bean.Manufacture;
import com.hanhan.bean.ResponseVo;

import java.util.List;

public interface ManufactureService {
    ResponseVo<Manufacture> queryManufactureByPageAndRows(int page, int rows);

    Manufacture queryByManufactureSn(String manufactureSn);

    boolean deleteManufacture(String[] ids);

    ResponseVo<Manufacture> searchManufactureByManufactureSn(String searchValue, int page, int rows);

    ResponseVo<Manufacture> searchManufactureByManufactureTechnologyName(String searchValue, int page, int rows);

    ResponseVo<Manufacture> searchManufactureByManufactureOrderId(String searchValue, int page, int rows);


    boolean insertManufacture(Manufacture manufacture);

    List<Manufacture> getData();

    boolean updateManufacture(Manufacture manufacture);
}
