package com.hanhan.service.custom;

import com.hanhan.bean.Custom;

import java.util.List;

public interface CustomService {
    List<Custom> queryCustomByPageAndRows(int page,int rows);

    boolean insertCustom(Custom custom);

    List<Custom> getData();

    boolean updateCustom(Custom custom);

    boolean deleteCustom(String[] ids);

    List<Custom> searchCustomByCustomId(String searchValue, int page, int rows);

    List<Custom> searchCustomByCustomName(String searchValue, int page, int rows);

    Custom queryCustomById(String customId);
}
