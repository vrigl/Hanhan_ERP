package com.hanhan.mapper;

import com.hanhan.bean.Manufacture;
import com.hanhan.bean.ManufactureExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ManufactureMapper {
    long countByExample(ManufactureExample example);

    int deleteByExample(ManufactureExample example);

    int deleteByPrimaryKey(String manufactureSn);

    int insert(Manufacture record);

    int insertSelective(Manufacture record);

    List<Manufacture> selectByExample(ManufactureExample example);

    Manufacture selectByPrimaryKey(String manufactureSn);

    int updateByExampleSelective(@Param("record") Manufacture record, @Param("example") ManufactureExample example);

    int updateByExample(@Param("record") Manufacture record, @Param("example") ManufactureExample example);

    int updateByPrimaryKeySelective(Manufacture record);

    int updateByPrimaryKey(Manufacture record);

    List<Manufacture> queryPageManufacture();


    Manufacture queryByManufactureSn(String manufactureSn);

    List<Manufacture> searchManufactureByManufactureSn(String searchValue);

    List<Manufacture> searchManufactureByManufactureTechnologyName(String searchValue);

    List<Manufacture> searchManufactureByManufactureOrderId(String searchValue);
}