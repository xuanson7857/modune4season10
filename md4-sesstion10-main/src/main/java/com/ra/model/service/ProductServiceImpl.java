package com.ra.model.service;

import com.ra.model.dao.ProductDao;
import com.ra.model.dao.ProductDaoImpl;
import com.ra.model.entity.Product;

import java.util.List;

public class ProductServiceImpl implements ProductService{
    ProductDao productDao=new ProductDaoImpl();
    @Override
    public List<Product> findAll() {
        return productDao.findAll();
    }

    @Override
    public boolean saveOfUpdate(Product product) {
        return productDao.saveOfUpdate(product);
    }

    @Override
    public Product findById(Integer integer) {
        return productDao.findById(integer);
    }

    @Override
    public void delete(Integer integer) {
        productDao.delete(integer);
    }
}
