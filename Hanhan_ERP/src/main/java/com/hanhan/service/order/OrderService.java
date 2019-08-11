package com.hanhan.service.order;

import com.hanhan.bean.Order;
import com.hanhan.bean.ResponseVo;

import java.util.List;

public interface OrderService {
    ResponseVo<Order> queryOrderByPageAndRows(int page, int rows);

    boolean updateOrder(Order order);
}
