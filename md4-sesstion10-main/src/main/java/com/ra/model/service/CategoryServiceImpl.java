package com.ra.model.service;

import com.ra.model.dao.CategoryDao;
import com.ra.model.dao.CategoryDaoImpl;
import com.ra.model.entity.Category;

import java.util.List;

public class CategoryServiceImpl implements CategoryService{

    CategoryDao categoryDao=new CategoryDaoImpl();
    @Override
    public List findAll() {
        return categoryDao.findAll();
    }

    @Override
    public boolean saveOfUpdate(Category category) {
        return false;
    }

    @Override
    public Category findById(Integer integer) {
        return categoryDao.findById(integer);
    }

    @Override
    public void delete(Integer integer) {

    }


}
