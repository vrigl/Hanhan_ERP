package com.hanhan.service.order;

import com.github.pagehelper.PageHelper;
import com.hanhan.bean.CustomExample;
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

    @Override
    public ResponseVo<Order> queryOrderByPageAndRows(int page, int rows) {
        OrderExample orderExample = new OrderExample();
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

    @Override
    public List<Order> getData() {
        return orderMapper.selectPageOrders();
    }

    @Override
    public Order queryOrderById(String orderId) {
        return orderMapper.selectByOrderId(orderId);
    }

    @Override
    public boolean insertOrder(Order order) {
        int insert = orderMapper.insert(order);
        return insert== 1;
    }

    @Override
    public boolean deleteOrder(String[] ids) {
        OrderExample orderExample = new OrderExample();
        int delete = 0;
        for (String id : ids) {
            delete += orderMapper.deleteByPrimaryKey(id);
        }

        return delete >= 1;
    }

    @Override
    public ResponseVo<Order> searchCustomByOrderId(String searchValue, int page, int rows) {
        OrderExample orderExample = new OrderExample();
        orderExample.createCriteria().andOrderIdLike("%"+searchValue+"%");

        int total = (int)orderMapper.countByExample(orderExample);
        PageHelper.startPage(page,rows);
        List<Order> orders = orderMapper.searchCustomByOrderId(searchValue);
        ResponseVo<Order> orderResponseVo = new ResponseVo<>();
        orderResponseVo.setRows(orders);
        orderResponseVo.setTotal(total);
        return orderResponseVo;
    }

    @Override
    public ResponseVo<Order> searchOrderByOrderCustom(String searchValue, int page, int rows) {
        int total = orderMapper.countSearchOrderByOrderCustom(searchValue);
        PageHelper.startPage(page,rows);
        List<Order> orders = orderMapper.searchOrderByOrderCustom(searchValue);

        ResponseVo<Order> orderResponseVo = new ResponseVo<>();
        orderResponseVo.setTotal(total);
        orderResponseVo.setRows(orders);
        return orderResponseVo;
    }

    @Override
    public ResponseVo<Order> searchOrderByOrderProduct(String searchValue, int page, int rows) {

        int total = orderMapper.countSearchOrderByOrderProduct(searchValue);
        PageHelper.startPage(page,rows);
        List<Order> orders = orderMapper.searchOrderByOrderProduct(searchValue);

        ResponseVo<Order> orderResponseVo = new ResponseVo<>();
        orderResponseVo.setTotal(total);
        orderResponseVo.setRows(orders);
        return orderResponseVo;
    }
}
