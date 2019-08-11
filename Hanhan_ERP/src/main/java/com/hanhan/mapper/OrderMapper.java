package com.hanhan.mapper;

import com.hanhan.bean.Order;
import com.hanhan.bean.OrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderMapper {

   List<Order> searchOrderByOrderCustom(String searchValue) ;

    List<Order> selectPageOrders();

    long countByExample(OrderExample example);

    int deleteByExample(OrderExample example);

    int deleteByPrimaryKey(String orderId);

    int insert(Order record);

    int insertSelective(Order record);

    List<Order> selectByExample(OrderExample example);

    Order selectByPrimaryKey(String orderId);

    int updateByExampleSelective(@Param("record") Order record, @Param("example") OrderExample example);

    int updateByExample(@Param("record") Order record, @Param("example") OrderExample example);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    Order selectByOrderId(String orderId);

    List<Order> searchCustomByOrderId(String searchValue);

    int countSearchOrderByOrderCustom(String searchValue);

    int countSearchOrderByOrderProduct(String searchValue);

    List<Order> searchOrderByOrderProduct(String searchValue);
}