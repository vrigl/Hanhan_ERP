package com.hanhan.service.order;

import com.hanhan.bean.Order;
import com.hanhan.bean.ResponseVo;

import java.util.List;

public interface OrderService {
    ResponseVo<Order> queryOrderByPageAndRows(int page, int rows);

    boolean updateOrder(Order order);

    List<Order> getData();

    Order queryOrderById(String orderId);

    boolean insertOrder(Order order);

    boolean deleteOrder(String[] ids);

    ResponseVo<Order> searchCustomByOrderId(String searchValue, int page, int rows);

    ResponseVo<Order> searchOrderByOrderCustom(String searchValue, int page, int rows);

    ResponseVo<Order> searchOrderByOrderProduct(String searchValue, int page, int rows);

}
