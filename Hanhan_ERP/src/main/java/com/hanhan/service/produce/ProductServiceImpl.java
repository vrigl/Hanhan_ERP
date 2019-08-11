package com.hanhan.service.produce;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hanhan.bean.CustomExample;
import com.hanhan.bean.Product;
import com.hanhan.bean.ProductExample;
import com.hanhan.bean.ResponseVo;
import com.hanhan.mapper.CustomMapper;
import com.hanhan.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    ProductMapper productMapper;
    ProductExample productExample = new ProductExample();
    @Override
    public List<Product> getData() {
        List<Product> products = productMapper.selectByExample(productExample);
        return products;
    }

    @Override
    public Product queryProductById(String productId) {
        productExample.createCriteria().andProductIdEqualTo(productId);
        List<Product> products = productMapper.selectByExample(productExample);
        return products.remove(0);
    }

    @Override
    public ResponseVo<Product> queryCustomByPageAndRows(int page, int rows) {
        /*查询数据总数*/
        int total= (int)productMapper.countByExample(productExample);
        PageHelper.startPage(page,rows);
        List<Product> products = productMapper.selectByExample(productExample);
        ResponseVo<Product> productResponseVo = new ResponseVo<>();
        productResponseVo.setTotal(total);
        productResponseVo.setRows(products);
        return productResponseVo;
    }
}
