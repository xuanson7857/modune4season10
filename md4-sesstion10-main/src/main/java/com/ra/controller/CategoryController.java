package com.ra.controller;

import com.ra.model.entity.Category;
import com.ra.model.service.CategoryService;
import com.ra.model.service.CategoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "categoryController" ,value = "/category")
public class CategoryController extends HttpServlet {
    private CategoryService categoryService=new CategoryServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action=req.getParameter("action");
        if (action==null){
            action="";
        }
        switch (action) {
            case "add":
                break;
            case "edit":
                break;
            default:
                showForm(req,resp);
                break;
        }
    }

    private void showForm(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException  {
        List<Category> listCategory=categoryService.findAll();
        req.setAttribute("listCategory",listCategory);
        req.getRequestDispatcher("views/category.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
