package com.hanhan.service.product;

import com.github.pagehelper.PageHelper;
import com.hanhan.bean.Product;
import com.hanhan.bean.ProductExample;
import com.hanhan.bean.ResponseVo;
import com.hanhan.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    ProductMapper productMapper;

    @Override
    public List<Product> getData() {
        ProductExample productExample = new ProductExample();
        List<Product> products = productMapper.selectByExample(productExample);
        return products;
    }

    @Override
    public Product queryProductById(String productId) {
        ProductExample productExample = new ProductExample();
        productExample.createCriteria().andProductIdEqualTo(productId);
        List<Product> products = productMapper.selectByExample(productExample);
        return products.remove(0);
    }

    @Override
    public ResponseVo<Product> queryCustomByPageAndRows(int page, int rows) {
        ProductExample productExample = new ProductExample();
        /*查询数据总数*/
        int total= (int)productMapper.countByExample(productExample);
        PageHelper.startPage(page,rows);
        List<Product> products = productMapper.selectByExample(productExample);
        ResponseVo<Product> productResponseVo = new ResponseVo<>();
        productResponseVo.setTotal(total);
        productResponseVo.setRows(products);
        return productResponseVo;
    }

    @Override
    public boolean deleteProduct(String[] ids) {
        int delete = 0;
        for (String id : ids) {
            delete += productMapper.deleteByPrimaryKey(id);
        }
        return delete >=1;
    }

    @Override
    public ResponseVo<Product> searchProductByProductId(String searchValue, int page, int rows) {
        ProductExample productExample = new ProductExample();
        productExample.createCriteria().andProductIdLike("%"+searchValue+"%");
        int total = (int)productMapper.countByExample(productExample);
        PageHelper.startPage(page,rows);
        List<Product> products = productMapper.selectByExample(productExample);

        ResponseVo<Product> productResponseVo = new ResponseVo<>();
        productResponseVo.setTotal(total);
        productResponseVo.setRows(products);
        return productResponseVo;
    }

    @Override
    public ResponseVo<Product> searchProductByProductName(String searchValue, int page, int rows) {

        ProductExample productExample = new ProductExample();
        productExample.createCriteria().andProductNameLike("%"+searchValue+"%");

        int total = (int)productMapper.countByExample(productExample);

        PageHelper.startPage(page,rows);
        List<Product> products = productMapper.selectByExample(productExample);

        ResponseVo<Product> productResponseVo = new ResponseVo<>();
        productResponseVo.setTotal(total);
        productResponseVo.setRows(products);
        return productResponseVo;
    }

    @Override
    public ResponseVo<Product> searchProductByProductType(String searchValue, int page, int rows) {
        ProductExample productExample = new ProductExample();
        productExample.createCriteria().andProductTypeLike("%"+searchValue+"%");
        int total = (int)productMapper.countByExample(productExample);
        PageHelper.startPage(page,rows);
        List<Product> products = productMapper.selectByExample(productExample);

        ResponseVo<Product> productResponseVo = new ResponseVo<>();
        productResponseVo.setTotal(total);
        productResponseVo.setRows(products);
        return productResponseVo;
    }

    @Override
    public boolean insertProduct(Product product) {
        int insert = productMapper.insert(product);
        return insert == 1;
    }

    @Override
    public boolean updateProduct(Product product) {
        int i = productMapper.updateByPrimaryKey(product);
        return i ==1;
    }
}
