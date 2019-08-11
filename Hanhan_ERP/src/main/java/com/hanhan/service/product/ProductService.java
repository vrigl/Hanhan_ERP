package com.hanhan.service.product;

import com.hanhan.bean.Product;
import com.hanhan.bean.ResponseVo;

import java.util.List;

public interface ProductService {
    List<Product> getData();

    Product queryProductById(String productId);

    ResponseVo<Product> queryCustomByPageAndRows(int page, int rows);

    boolean deleteProduct(String[] ids);

    ResponseVo<Product> searchProductByProductId(String searchValue, int page, int rows);

    ResponseVo<Product> searchProductByProductName(String searchValue, int page, int rows);

    ResponseVo<Product> searchProductByProductType(String searchValue, int page, int rows);

    boolean insertProduct(Product product);

    boolean updateProduct(Product product);
}
