package com.ra.model.dao;

import com.ra.model.entity.Category;
import com.ra.until.ConnectionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDaoImpl implements CategoryDao{
    @Override
    public List<Category> findAll() {
        Connection connection = null;
        List<Category>  categoryList = new ArrayList<>();
        try {
            connection = ConnectionDB.openConnection();
            PreparedStatement call = connection.prepareStatement("SELECT * FROM category");
            ResultSet resultSet = call.executeQuery();
            while (resultSet.next()) {
                Category cte = new Category();
                cte.setId(resultSet.getInt("id"));
                cte.setName(resultSet.getString("name"));
                cte.setStatus(resultSet.getBoolean("status"));
                categoryList.add(cte);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return categoryList;
    }

    @Override
    public boolean saveOfUpdate(Category category) {
        return false;
    }

    @Override
    public Category findById(Integer integer) {
            Connection connection = null;
            Category category = new Category();
            try {
                connection = ConnectionDB.openConnection();
                PreparedStatement pstm = connection.prepareStatement("SELECT * FROM category where id=?");
                pstm.setInt(1,integer);
                ResultSet resultSet = pstm.executeQuery();
                while (resultSet.next()) {
                    category.setId(resultSet.getInt("id"));
                    category.setName(resultSet.getString("name"));
                    category.setStatus(resultSet.getBoolean("status"));
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                ConnectionDB.closeConnection(connection);
            }
            return  category;
        }

    @Override
    public void delete(Integer integer) {

    }
}
