package com.ra.controller;

import com.ra.model.entity.Category;
import com.ra.model.entity.Product;
import com.ra.model.service.CategoryService;
import com.ra.model.service.CategoryServiceImpl;
import com.ra.model.service.ProductService;
import com.ra.model.service.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "productController",value = "/product")
public class ProductController extends HttpServlet {
    private static final ProductService productService =new ProductServiceImpl();
    private static final CategoryService categoryService=new CategoryServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action=req.getParameter("action");
        if (action==null){
            action="";
        }
        switch (action) {
            case "add":
                List<Category> listCategory=categoryService.findAll();
                req.setAttribute("listCategory",listCategory);
                req.getRequestDispatcher("views/add-product.jsp").forward(req,resp);
                break;
            case "edit":
                List<Category> listCat=categoryService.findAll();
                req.setAttribute("listCategory",listCat);
                int idEdit= Integer.parseInt(req.getParameter("id"));
                Product product=productService.findById(idEdit);
                req.setAttribute("listPro",product);
                req.getRequestDispatcher("views/edit-product.jsp").forward(req,resp);
                break;
            case "delete":
                int idDelete= Integer.parseInt(req.getParameter("id"));
                productService.findById(idDelete);
                productService.delete(idDelete);
                showForm(req,resp);
                break;
            default:
                showForm(req,resp);
                break;
        }
    }

    private void showForm(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException  {
        List<Product> listProduct=productService.findAll();
        req.setAttribute("listProduct",listProduct);
        req.getRequestDispatcher("views/product.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action=req.getParameter("action");
        if (action==null){
            action="";
        }
        switch (action) {
            case "add":
                actionAddForm(req,resp);
                break;
            case "edit":
                actionEdit(req,resp);
                break;
            default:
                showForm(req,resp);
                break;
        }
    }

    private void actionEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        int idEdit= Integer.parseInt(req.getParameter("id"));
        categoryService.findById(idEdit);
        String name=req.getParameter("name");
        float price= Float.parseFloat(req.getParameter("price"));
        int categoryId= Integer.parseInt(req.getParameter("category"));
        Category category= categoryService.findById(categoryId);
        Product product=new Product(idEdit,name,price,category);
        productService.saveOfUpdate(product);
        showForm(req,resp);
    }

    private void actionAddForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Product product=new Product();
        product.setName(req.getParameter("name"));
        product.setPrice(Float.parseFloat(req.getParameter("price")));
        int categoryId= Integer.parseInt(req.getParameter("category"));
        Category category= categoryService.findById(categoryId);
        product.setCategory(category);
        productService.saveOfUpdate(product);
        showForm(req,resp);
    }
}
