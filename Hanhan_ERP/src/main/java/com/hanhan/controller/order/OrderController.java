package com.hanhan.controller.order;

import com.hanhan.bean.Custom;
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
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;
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
    @RequestMapping("get_data")
    @ResponseBody
    public List<Order> getData(){
        return orderService.getData();
    }
    @RequestMapping("get/{orderId}")
    @ResponseBody
    public Order get(@PathVariable("orderId") String orderId){
        return orderService.queryOrderById(orderId);
    }
    @RequestMapping("add_judge")
    @ResponseBody
    public String addJudge(){
        return "";
    }
    @RequestMapping("add")
    public String add(){
        return "/WEB-INF/jsp/order_add.jsp";
    }
    @RequestMapping("insert")
    @ResponseBody
    public Data insert(Order order){
        boolean result = orderService.insertOrder(order);
        Data data = new Data();
        if(result){
            data.setMsg("新增客户成功");
            data.setStatus(200);
        }else {
            data.setMsg("该客户编号已经存在，请更换客户编号！");
        }
        return data;
    }
    @RequestMapping("delete_judge")
    @ResponseBody
    public String deleteJudge(){
        return "";
    }
    @RequestMapping("delete_batch")
    @ResponseBody
    public Data deleteJudge(String[] ids){
        boolean result = orderService.deleteOrder(ids);
        Data data = new Data();
        if(result){
            data.setMsg("OK");
            data.setStatus(200);
        }
        return data;
    }
    @RequestMapping("search_order_by_orderId")
    @ResponseBody
    public ResponseVo<Order> searchOrderByOrderId(String searchValue,int page,int rows){
        return orderService.searchCustomByOrderId(searchValue, page, rows);
    }
    @RequestMapping("search_order_by_orderCustom")
    @ResponseBody
    public ResponseVo<Order> searchOrderByOrderCustom(String searchValue,int page,int rows){
        return orderService.searchOrderByOrderCustom(searchValue,page,rows);
    }
    @RequestMapping("search_order_by_orderProduct")
    @ResponseBody
    public ResponseVo<Order> searchOrderByOrderProduct(String searchValue,int page,int rows){
        return orderService.searchOrderByOrderProduct(searchValue,page,rows);
    }
}
