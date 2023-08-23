package models.repository.Impl;


import models.model.Product;
import models.repository.BaseRepository;
import models.repository.IProductRepostory;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepostory {
    private static final String GET_ALL = "SELECT * FROM products ;";
    private static final String GET_BY_ID = "SELECT * FROM products WHERE product_id=?;";
    private static final String INSERT_INTO = "INSERT INTO products (product_name, product_type_id, `describe`,price,product_image_url) VALUES (?,?,?,?,?);";
    private static final String DELETE_BY_ID = "DELETE FROM products WHERE product_id=?;";
    private static final String UPDATE_BY_ID = "UPDATE products SET product_name=?, product_type_id=?, `describe`=?,price=?,product_image_url=?,updateAt=current_timestamp() Where product_id=?;";
    private static final String SEARCH_PRODUCT = "SELECT * FROM products  WHERE product_type_id LIKE 1 AND product_name LIKE ? AND price BETWEEN ? and ?;";
    private static final String SEARCH_PRODUCT_USER = "SELECT * FROM products WHERE product_name LIKE ?;";

    @Override
    public List<Product> getList() {
        List<Product> productList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("product_id");
                String name = resultSet.getString("product_name");
                int productType = resultSet.getInt("product_type_id");
                String describe = resultSet.getString("describe");
                double price = resultSet.getDouble("price");
                String productImage = resultSet.getString("product_image_url");
                String createAt = resultSet.getString("createAt");
                String updateAt = resultSet.getString("updateAt");
                productList.add(new Product(id, name, productType, describe, price, productImage, createAt, updateAt));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }

    @Override
    public Product findByID(int id) {
        Product product = null;
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idBase = resultSet.getInt("product_id");
                String name = resultSet.getString("product_name");
                int productType = resultSet.getInt("product_type_id");
                String describe = resultSet.getString("describe");
                double price = resultSet.getDouble("price");
                String productImage = resultSet.getString("product_image_url");
                String updateAt = resultSet.getString("updateAt");
                product = new Product(idBase, name, productType, describe, price, productImage, updateAt);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public boolean createAt(Product product) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setInt(2, product.getProductType());
            preparedStatement.setString(3, product.getDescribe());
            preparedStatement.setDouble(4, product.getPrice());
            preparedStatement.setString(5, product.getProductImage());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean remove(int id) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_ID);
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean edit(Product product) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setInt(2, product.getProductType());
            preparedStatement.setString(3, product.getDescribe());
            preparedStatement.setDouble(4, product.getPrice());
            preparedStatement.setString(5, product.getProductImage());
            preparedStatement.setInt(6, product.getId());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Product> search(String name, int startPrice, int endPricee) {
        List<Product> productList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_PRODUCT);
            preparedStatement.setString(1, '%' + name + '%');
            preparedStatement.setDouble(2, startPrice);
            preparedStatement.setDouble(3, endPricee);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("product_id");
                String nameProduct = resultSet.getString("product_name");
                int productType = resultSet.getInt("product_type_id");
                String describe = resultSet.getString("describe");
                double price = resultSet.getDouble("price");
                String productImage = resultSet.getString("product_image_url");
                String createAt = resultSet.getString("createAt");
                String updateAt = resultSet.getString("updateAt");
                Product product = new Product(id, nameProduct, productType, describe, price, productImage, createAt, updateAt);
                productList.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }

    @Override
    public List<Product> searchUser(String productName) {
        List<Product> productList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_PRODUCT_USER);
            preparedStatement.setString(1, '%' + productName + '%');
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("product_id");
                String nameProduct = resultSet.getString("product_name");
                int productType = resultSet.getInt("product_type_id");
                String describe = resultSet.getString("describe");
                double price = resultSet.getDouble("price");
                String productImage = resultSet.getString("product_image_url");
                String createAt = resultSet.getString("createAt");
                String updateAt = resultSet.getString("updateAt");
                Product product = new Product(id, nameProduct, productType, describe, price, productImage, createAt, updateAt);
                productList.add(product);
            }
            return productList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
