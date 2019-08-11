package com.hanhan.controller.product;

import com.hanhan.bean.Custom;
import com.hanhan.bean.Product;
import com.hanhan.bean.ResponseVo;
import com.hanhan.service.produce.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("product")
public class ProductController {
    @Autowired
    ProductService productService;

    @RequestMapping("find")
    public String find(HttpSession httpSession){
        ArrayList<String> sysPermissionList = new ArrayList<>();
        sysPermissionList.add("product:add");
        sysPermissionList.add("product:edit");
        sysPermissionList.add("product:delete");
        httpSession.setAttribute("sysPermissionList",sysPermissionList);
        return "/WEB-INF/jsp/product_list.jsp";
    }

    @RequestMapping("list")
    @ResponseBody
    public ResponseVo<Product> queryCustomByPageAndRows(int page, int rows){
        ResponseVo<Product> products = productService.queryCustomByPageAndRows(page, rows);
        return products;
    }
    /*用于加载商品的信息*/
    @RequestMapping("get_data")
    @ResponseBody
    public List<Product> getData(){
        List<Product> data = productService.getData();
        return data;
    }
    /*用于订单页面的商品详情点击*/
    @RequestMapping("get/{productId}")
    @ResponseBody
    public Product get(@PathVariable("productId") String productId){
        Product product = productService.queryProductById(productId);
        return product;
    }
}
