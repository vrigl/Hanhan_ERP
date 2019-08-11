package com.hanhan.service.work;

import com.hanhan.bean.ResponseVo;
import com.hanhan.bean.Work;

import java.util.List;

public interface WorkService {
    ResponseVo<Work> queryWorkByPageAndRows(int page, int rows);

    Work queryWorkById(String workId);

    boolean deleteWork(String[] ids);

    ResponseVo<Work> searchWorkByWorkProcess(String searchValue, int page, int rows);

    ResponseVo<Work> searchWorkByWorkDevice(String searchValue, int page, int rows);

    ResponseVo<Work> searchWorkByWorkProduct(String searchValue, int page, int rows);

    ResponseVo<Work> searchWorkByWorkId(String searchValue, int page, int rows);

    boolean insertWork(Work work);

    List<Work> getData();

    boolean updateWork(Work work);
}
