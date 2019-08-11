package com.hanhan.mapper;

import com.hanhan.bean.Work;
import com.hanhan.bean.WorkExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WorkMapper {
    Work selectByWorkId(String workId);
    long countByExample(WorkExample example);

    int deleteByExample(WorkExample example);

    int deleteByPrimaryKey(String workId);

    int insert(Work record);

    int insertSelective(Work record);

    List<Work> selectByExample(WorkExample example);

    Work selectByPrimaryKey(String workId);

    int updateByExampleSelective(@Param("record") Work record, @Param("example") WorkExample example);

    int updateByExample(@Param("record") Work record, @Param("example") WorkExample example);

    int updateByPrimaryKeySelective(Work record);

    int updateByPrimaryKey(Work record);

    List<Work> selectPageWorks();

    List<Work> searchWorkByWorkId(String searchValue);

    int countSearchWorkByWorkProduct(String searchValue);

    List<Work> searchWorkByWorkProduct(String searchValue);

    int countSearchWorkByWorkDevice(String searchValue);

    List<Work> searchWorkByWorkDevice(String searchValue);

    int countSearchWorkByWorkProcess(String searchValue);

    List<Work> searchWorkByWorkProcess(String searchValue);
}