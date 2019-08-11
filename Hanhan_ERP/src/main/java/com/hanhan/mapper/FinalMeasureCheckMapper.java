package com.hanhan.mapper;

import com.hanhan.bean.FinalMeasureCheck;
import com.hanhan.bean.FinalMeasureCheckExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FinalMeasureCheckMapper {
    long countByExample(FinalMeasureCheckExample example);

    int deleteByExample(FinalMeasureCheckExample example);

    int deleteByPrimaryKey(String fMeasureCheckId);

    int insert(FinalMeasureCheck record);

    int insertSelective(FinalMeasureCheck record);

    List<FinalMeasureCheck> selectByExample(FinalMeasureCheckExample example);

    FinalMeasureCheck selectByPrimaryKey(String fMeasureCheckId);

    int updateByExampleSelective(@Param("record") FinalMeasureCheck record, @Param("example") FinalMeasureCheckExample example);

    int updateByExample(@Param("record") FinalMeasureCheck record, @Param("example") FinalMeasureCheckExample example);

    int updateByPrimaryKeySelective(FinalMeasureCheck record);

    int updateByPrimaryKey(FinalMeasureCheck record);
}