package com.hanhan.service.work;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hanhan.bean.ResponseVo;
import com.hanhan.bean.Work;
import com.hanhan.bean.WorkExample;
import com.hanhan.mapper.WorkMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkServiceImpl implements WorkService {
    @Autowired
    WorkMapper workMapper;

    @Override
    public ResponseVo<Work> queryWorkByPageAndRows(int page, int rows) {
        WorkExample workExample = new WorkExample();
        int total = (int)workMapper.countByExample(workExample);
        PageHelper.startPage(page,rows);
        List<Work> works = workMapper.selectPageWorks();

        ResponseVo<Work> workResponseVo = new ResponseVo<>();
        workResponseVo.setTotal(total);
        workResponseVo.setRows(works);
        return workResponseVo;
    }

    @Override
    public Work queryWorkById(String workId) {
        return workMapper.selectByWorkId(workId);

    }

    @Override
    public boolean deleteWork(String[] ids) {
        int delete = 0;
        for (String id : ids) {
            delete += workMapper.deleteByPrimaryKey(id);
        }
        return delete >=1 ;
    }
    @Override
    public ResponseVo<Work> searchWorkByWorkId(String searchValue, int page, int rows) {
        WorkExample workExample = new WorkExample();
        workExample.createCriteria().andDeviceIdLike("%"+searchValue+"%");
        int total = (int)workMapper.countByExample(workExample);

        PageHelper.startPage(page,rows);
        List<Work> works = workMapper.searchWorkByWorkId(searchValue);
        ResponseVo<Work> workResponseVo = new ResponseVo<>();
        workResponseVo.setTotal(total);
        workResponseVo.setRows(works);
        return workResponseVo;
    }

    @Override
    public boolean insertWork(Work work) {
        int insert = workMapper.insert(work);
        return insert==1;
    }

    @Override
    public List<Work> getData() {
        WorkExample workExample = new WorkExample();
        List<Work> works = workMapper.selectByExample(workExample);
        return works;
    }

    @Override
    public boolean updateWork(Work work) {
        int i = workMapper.updateByPrimaryKey(work);
        return i ==1;
    }

    @Override
    public ResponseVo<Work> searchWorkByWorkProduct(String searchValue, int page, int rows) {
        int total = workMapper.countSearchWorkByWorkProduct(searchValue);
        PageHelper.startPage(page,rows);
        List<Work> works = workMapper.searchWorkByWorkProduct(searchValue);
        ResponseVo<Work> workResponseVo = new ResponseVo<>();
        workResponseVo.setRows(works);
        workResponseVo.setTotal(total);
        return workResponseVo;
    }
    @Override
    public ResponseVo<Work> searchWorkByWorkDevice(String searchValue, int page, int rows) {

        int total = workMapper.countSearchWorkByWorkDevice(searchValue);

        PageHelper.startPage(page,rows);
        List<Work> works = workMapper.searchWorkByWorkDevice(searchValue);

        ResponseVo<Work> workResponseVo = new ResponseVo<>();

        workResponseVo.setRows(works);

        workResponseVo.setTotal(total);

        return workResponseVo;

    }
    @Override
    public ResponseVo<Work> searchWorkByWorkProcess(String searchValue, int page, int rows) {
        //int total = workMapper.countSearchWorkByWorkProcess(searchValue);

        PageHelper.startPage(page,rows);
        List<Work> works = workMapper.searchWorkByWorkProcess(searchValue);
        PageInfo<Work> workPageInfo = new PageInfo<>(works);
        int total = (int)workPageInfo.getTotal();
        ResponseVo<Work> workResponseVo = new ResponseVo<>();

        workResponseVo.setRows(works);

        workResponseVo.setTotal(total);

        return workResponseVo;
    }






}
