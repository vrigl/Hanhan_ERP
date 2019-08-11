package com.hanhan.service.task;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hanhan.bean.Manufacture;
import com.hanhan.bean.ResponseVo;
import com.hanhan.bean.Task;
import com.hanhan.bean.TaskExample;
import com.hanhan.mapper.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    TaskMapper taskMapper;

    @Override
    public ResponseVo<Task> qeuryTaskByPageAndRows(int page, int rows) {
        TaskExample taskExample = new TaskExample();
        int total = (int)taskMapper.countByExample(taskExample);
        PageHelper.startPage(page,rows);
        List<Task> tasks = taskMapper.selectByExample(taskExample);
        ResponseVo<Task> taskResponseVo = new ResponseVo<>();
        taskResponseVo.setTotal(total);
        taskResponseVo.setRows(tasks);
        return taskResponseVo;
    }

    @Override
    public boolean deleteTask(String[] ids) {
        int delete = 0;
        for (String id : ids) {
            delete += taskMapper.deleteByPrimaryKey(id);
        }
        return delete >= 1;
    }

    @Override
    public ResponseVo<Task> searchTaskByTaskId(String searchValue, int page, int rows) {
        TaskExample taskExample = new TaskExample();
        taskExample.createCriteria().andTaskIdLike("%"+searchValue+"%");

        PageHelper.startPage(page,rows);
        List<Task> tasks = taskMapper.selectByExample(taskExample);
        PageInfo<Task> taskPageInfo = new PageInfo<>(tasks);
        int total = (int)taskPageInfo.getTotal();

        ResponseVo<Task> taskResponseVo = new ResponseVo<>();
        taskResponseVo.setTotal(total);
        taskResponseVo.setRows(tasks);
        return taskResponseVo;
    }

    @Override
    public ResponseVo<Task> searchTaskByTaskWorkId(String searchValue, int page, int rows) {
        TaskExample taskExample = new TaskExample();
        taskExample.createCriteria().andWorkIdLike("%"+searchValue+"%");

        PageHelper.startPage(page,rows);
        List<Task> tasks = taskMapper.selectByExample(taskExample);
        PageInfo<Task> taskPageInfo = new PageInfo<>(tasks);
        int total = (int)taskPageInfo.getTotal();

        ResponseVo<Task> taskResponseVo = new ResponseVo<>();
        taskResponseVo.setTotal(total);
        taskResponseVo.setRows(tasks);
        return taskResponseVo;
    }

    @Override
    public ResponseVo<Task> searchTaskByTaskManufactureSn(String searchValue, int page, int rows) {
        TaskExample taskExample = new TaskExample();
        taskExample.createCriteria().andManufactureSnLike("%"+searchValue+"%");

        PageHelper.startPage(page,rows);
        List<Task> tasks = taskMapper.selectByExample(taskExample);
        PageInfo<Task> taskPageInfo = new PageInfo<>(tasks);
        int total = (int)taskPageInfo.getTotal();

        ResponseVo<Task> taskResponseVo = new ResponseVo<>();
        taskResponseVo.setTotal(total);
        taskResponseVo.setRows(tasks);
        return taskResponseVo;
    }

    @Override
    public boolean insertTask(Task task) {
        int insert = taskMapper.insert(task);
        return insert == 1;
    }

    @Override
    public boolean updateTask(Task task) {
        int i = taskMapper.updateByPrimaryKey(task);
        return i == 1;

    }
}
