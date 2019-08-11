package com.hanhan.service.order;

import com.github.pagehelper.PageHelper;
import com.hanhan.bean.Order;
import com.hanhan.bean.OrderExample;
import com.hanhan.bean.ResponseVo;
import com.hanhan.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;
    OrderExample orderExample = new OrderExample();
    @Override
    public ResponseVo<Order> queryOrderByPageAndRows(int page, int rows) {
        /*查询数据总数*/
        int total = (int)orderMapper.countByExample(orderExample);
        /*数据分页*/
        PageHelper.startPage(page,rows);
        List<Order> orders = orderMapper.selectPageOrders();

        ResponseVo<Order> orderResponseVo = new ResponseVo<>();
        orderResponseVo.setRows(orders);
        orderResponseVo.setTotal(total);
        return orderResponseVo;
    }

    @Override
    public boolean updateOrder(Order order) {
        int update = orderMapper.updateByPrimaryKey(order);
        return update==1;
    }
}
