package models.repository.impl;

import models.model.User;
import models.repository.BaseRepositoryUser;
import models.repository.IUserRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements IUserRepository {
    private final String SELECT_ALL = "SELECT* FROM users;";
    private final String INSERT_INTO = "insert into users(name, email, country) values(?,?,?);";
    private final String DELETE_USER = "DELETE From users WHERE id=?;";
    private final String UPDATE_USER = "UPDATE users set name=?, email=? , country=? WHERE id=?;";
    private final String SEARCH_COUNTRY = "SELECT * From users as u WHERE u.country=?; ";
    private final String SORT_BY_NAME = "SELECT * FROM users AS u ORDER BY u.name ASC;";

    @Override
    public List<User> getAll() {
        List<User> userList = new ArrayList<>();
        Connection connection = BaseRepositoryUser.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                User user = new User(id, name, email, country);
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public boolean createUser(User user) {
        Connection connection = BaseRepositoryUser.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteUser(int id) {
        Connection connection = BaseRepositoryUser.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER);
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateUser(User user) {
        Connection connection = BaseRepositoryUser.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            preparedStatement.setInt(4, user.getId());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<User> searchCountry(String country) {
        List<User> userList = new ArrayList<>();
        Connection connection = BaseRepositoryUser.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_COUNTRY);
            preparedStatement.setString(1,country);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String countryQuery = resultSet.getString("country");
                User user = new User(id,name,email,countryQuery);
                userList.add(user);
            }
            return userList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<User> sortByName() {
        List<User> userList = new ArrayList<>();
        Connection connection = BaseRepositoryUser.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SORT_BY_NAME);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String countryQuery = resultSet.getString("country");
                User user = new User(id,name,email,countryQuery);
                userList.add(user);
            }
            return userList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean addUserTransaction(User user) {
        Connection connection = BaseRepositoryUser.getConnectDB();
        Savepoint savepoint1=null;
        try {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            int rowAffect = preparedStatement.executeUpdate();
            savepoint1 = connection.setSavepoint();
            if(rowAffect == 1){
                connection.commit();
            }else {
                connection.rollback(savepoint1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
}
