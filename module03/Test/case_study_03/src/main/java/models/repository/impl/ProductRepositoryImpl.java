package models.repository.impl;

import models.model.Products;
import models.repository.BaseRepository;
import models.repository.IProductRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements IProductRepository {
    private final String SELECT_ALL = "SELECT * FROM products;";
    private final String DELETE_PRODUCT = "DELETE FROM products WHERE product_id = ? ;";
    private final String ADD_PRODUCT = "INSERT INTO products (product_id,product_name,product_type_id,`describe`,price,product_image_url) VALUES (?,?,?,?,?,?);";
    private final String UPDATE_PRODUCT = "UPDATE products set product_name = ?, product_type_id = ?, `describe` = ?, price = ?, product_image_url =? WHERE product_id = ?;";

    @Override
    public boolean addProduct(HttpServletRequest request, HttpServletResponse response) {
        int productId = Integer.parseInt(request.getParameter("productId"));
        String productName = request.getParameter("productName");
        String productType = request.getParameter("productTypeId");
        String describe = request.getParameter("describe");
        double price = Double.parseDouble(request.getParameter("price"));
        String imageUrl = request.getParameter("imageUrl");
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_PRODUCT);
            preparedStatement.setInt(1, productId);
            preparedStatement.setString(2, productName);
            preparedStatement.setString(3, productType);
            preparedStatement.setString(4, describe);
            preparedStatement.setDouble(5, price);
            preparedStatement.setString(6, imageUrl);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Products> getAll() {
        List<Products> productsList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int productId = resultSet.getInt("product_id");
                String productName = resultSet.getString("product_name");
                int productType = resultSet.getInt("product_type_id");
                String describe = resultSet.getString("describe");
                double price = resultSet.getDouble("price");
                String imageUrl = resultSet.getString("product_image_url");
                Products products = new Products(productId, productName, productType, describe, price, imageUrl);
                productsList.add(products);
            }
            return productsList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void delete(int productId) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PRODUCT);
            preparedStatement.setInt(1, productId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Products products) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PRODUCT);
            preparedStatement.setString(1, products.getProductName());
            preparedStatement.setInt(2, products.getProductType());
            preparedStatement.setString(3, products.getDescribe());
            preparedStatement.setDouble(4, products.getPrice());
            preparedStatement.setString(5, products.getImageUrl());
            preparedStatement.setInt(6, products.getProductId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
