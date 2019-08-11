package com.hanhan.service.work;

import com.hanhan.bean.ResponseVo;
import com.hanhan.bean.Work;

public interface WorkService {
    ResponseVo<Work> queryWorkByPageAndRows(int page, int rows);
}
