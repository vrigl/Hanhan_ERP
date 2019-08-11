package com.hanhan.service.custom;

import com.hanhan.bean.Custom;
import com.hanhan.bean.ResponseVo;

import javax.xml.ws.Response;
import java.util.List;

public interface CustomService {
    List<Custom> queryCustomByPageAndRows(int page,int rows);

    boolean insertCustom(Custom custom);

    List<Custom> getData();

    boolean updateCustom(Custom custom);

    boolean deleteCustom(String[] ids);

    ResponseVo<Custom> searchCustomByCustomId(String searchValue, int page, int rows);

    ResponseVo<Custom> searchCustomByCustomName(String searchValue, int page, int rows);

    Custom queryCustomById(String customId);
}
