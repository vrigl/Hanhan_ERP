package com.hanhan.controller.order;

import com.hanhan.bean.Data;
import com.hanhan.bean.Order;
import com.hanhan.bean.ResponseVo;
import com.hanhan.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("order")
public class OrderController {
    @Autowired
    OrderService orderService;
    @RequestMapping("find")
    public String find(HttpSession httpSession){
        ArrayList<String> sysPermissionList = new ArrayList<>();
        /*增加权限，增删改*/
        sysPermissionList.add("order:add");
        sysPermissionList.add("order:edit");
        sysPermissionList.add("order:delete");
        httpSession.setAttribute("sysPermissionList",sysPermissionList);
        return "/WEB-INF/jsp/order_list.jsp";
    }
    /*分页展示订单数据*/
    @RequestMapping("list")
    @ResponseBody
    public ResponseVo<Order> queryOrderByPageAndRows(int page,int rows){
        ResponseVo<Order> orders = orderService.queryOrderByPageAndRows(page, rows);
        return orders;
    }
    /*订单修改*/
    @RequestMapping("edit_judge")
    @ResponseBody
    public String editJudge(){
        return "";
    }
    @RequestMapping("edit")
    public String edit(){
        return "/WEB-INF/jsp/order_edit.jsp";
    }
    @RequestMapping("update_all")
    @ResponseBody
    public Data updataAll( Order order){
        boolean result = orderService.updateOrder(order);
        Data data = new Data();
        if(result){
            data.setMsg("OK");
            data.setStatus(200);
        }
        return data;
    }


}
