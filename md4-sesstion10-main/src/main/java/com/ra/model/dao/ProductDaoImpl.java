package com.ra.model.dao;

import com.ra.model.entity.Category;
import com.ra.model.entity.Product;
import com.ra.until.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao{
    @Override
    public List<Product> findAll() {
        Connection connection = null;
        List<Product>  productList = new ArrayList<>();
        try {
            connection = ConnectionDB.openConnection();
            PreparedStatement call = connection.prepareStatement("SELECT * FROM product");
            ResultSet resultSet = call.executeQuery();
            while (resultSet.next()) {
                Product product = new Product();
                product.setId(resultSet.getInt("id"));
                product.setName(resultSet.getString("name"));
                product.setPrice(resultSet.getFloat("price"));
                Category category = new CategoryDaoImpl().findById(resultSet.getInt("category_id"));
                product.setCategory(category);
                productList.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return productList;
    }

    @Override
    public boolean saveOfUpdate(Product product) {
        Connection connection = null;
        connection = ConnectionDB.openConnection();
        boolean check = false;
        int s1;
        try {
            connection.setAutoCommit(false);
           if (product.getId()==0){
               String sql = "INSERT INTO product(name,price,category_id) VALUES(?,?,?)";
               PreparedStatement statement = connection.prepareStatement(sql);
               statement.setString(1, product.getName());
               statement.setFloat(2,product.getPrice());
               statement.setInt(3,product.getCategory().getId());
               s1 = statement.executeUpdate();
           }else {
               String sql = "UPDATE product set name=?,price=?,category_id=? where id=?";
               PreparedStatement statement = connection.prepareStatement(sql);
               statement.setString(1, product.getName());
               statement.setFloat(2,product.getPrice());
               statement.setInt(3,product.getCategory().getId());
               statement.setInt(4,product.getId());
               s1 = statement.executeUpdate();
           }
            if(s1 > 0)
            {
                check = true;
                connection.commit();
            }
        }catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return check;
    }

    @Override
    public Product findById(Integer integer) {
        Connection connection = null;
        Product product = new Product();
        try {
            connection = ConnectionDB.openConnection();
            PreparedStatement pstm = connection.prepareStatement("SELECT * FROM product where id=?");
            pstm.setInt(1,integer);
            ResultSet resultSet = pstm.executeQuery();
            while (resultSet.next()) {
                product.setId(resultSet.getInt("id"));
                product.setName(resultSet.getString("name"));
                product.setPrice(resultSet.getFloat("price"));
                Category category = new CategoryDaoImpl().findById(resultSet.getInt("category_id"));
                product.setCategory(category);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return  product;
    }

    @Override
    public void delete(Integer integer) {
        Connection connection = null;
        connection = ConnectionDB.openConnection();
        String sql = "DELETE from product where id=?";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, integer);
            int check=statement.executeUpdate();
            if (check==0){
                System.out.println(integer);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectionDB.closeConnection(connection);
        }
    }
}
