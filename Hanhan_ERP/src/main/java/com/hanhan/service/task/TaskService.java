package com.hanhan.service.task;

import com.hanhan.bean.ResponseVo;
import com.hanhan.bean.Task;

public interface TaskService {
    ResponseVo<Task> qeuryTaskByPageAndRows(int page, int rows);

    boolean deleteTask(String[] ids);

    ResponseVo<Task> searchTaskByTaskId(String searchValue, int page, int rows);

    ResponseVo<Task> searchTaskByTaskWorkId(String searchValue, int page, int rows);

    ResponseVo<Task> searchTaskByTaskManufactureSn(String searchValue, int page, int rows);

    boolean insertTask(Task task);

    boolean updateTask(Task task);
}
