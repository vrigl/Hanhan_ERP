package com.hanhan.controller.product;

import com.hanhan.bean.Custom;
import com.hanhan.bean.Data;
import com.hanhan.bean.Product;
import com.hanhan.bean.ResponseVo;
import com.hanhan.service.product.ProductService;
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


    @RequestMapping("add_judge")
    @ResponseBody
    public String addJudge(){
        return "";
    }


    @RequestMapping("add")
    public String add(HttpSession httpSession){

        return "/WEB-INF/jsp/product_add.jsp";
    }
    @RequestMapping("edit_judge")
    @ResponseBody
    public String editJudge(){
        return "";
    }


    @RequestMapping("edit")
    public String edit(){
        return "/WEB-INF/jsp/product_edit.jsp";
    }


    @RequestMapping("update_all")
    @ResponseBody
    public Data updataAll( Product product){
        boolean result = productService.updateProduct(product);
        Data data = new Data();
        if(result){
            data.setMsg("OK");
            data.setStatus(200);
        }
        return data;
    }



    @RequestMapping("delete_judge")
    @ResponseBody
    public String deleteJudge(){
        return "";
    }


    @RequestMapping("insert")
    @ResponseBody
    public Data insert(Product product){
        boolean result = productService.insertProduct(product);
        Data data = new Data();
        if(result){
            data.setMsg("新增客户成功");
            data.setStatus(200);
        }else {
            data.setMsg("该客户编号已经存在，请更换客户编号！");
        }
        return data;
    }


    @RequestMapping("delete_batch")
    @ResponseBody
    public Data deleteJudge(String[] ids){
        boolean result = productService.deleteProduct(ids);
        Data data = new Data();
        if(result){
            data.setMsg("OK");
            data.setStatus(200);
        }
        return data;
    }


    @RequestMapping("search_product_by_productId")
    @ResponseBody
    public ResponseVo<Product> searchProductByProductId(String searchValue,int page,int rows){
        return productService.searchProductByProductId(searchValue,page,rows);
    }


    @RequestMapping("search_product_by_productName")
    @ResponseBody
    public ResponseVo<Product> searchProductByProductName(String searchValue,int page,int rows){
        return productService.searchProductByProductName(searchValue,page,rows);
    }


    @RequestMapping("search_product_by_productType")
    @ResponseBody
    public ResponseVo<Product> searchProductByProductType(String searchValue,int page,int rows){
        return productService.searchProductByProductType(searchValue,page,rows);
    }
}
