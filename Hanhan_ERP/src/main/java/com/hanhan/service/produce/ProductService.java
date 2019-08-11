package com.hanhan.service.produce;

import com.hanhan.bean.Product;
import com.hanhan.bean.ResponseVo;

import java.util.List;

public interface ProductService {
    List<Product> getData();

    Product queryProductById(String productId);

    ResponseVo<Product> queryCustomByPageAndRows(int page, int rows);
}
