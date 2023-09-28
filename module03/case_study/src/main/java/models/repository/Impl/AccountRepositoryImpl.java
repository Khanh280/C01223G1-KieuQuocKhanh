package models.repository.Impl;

import models.model.Account;
import models.repository.BaseRepository;
import models.repository.IAccountRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountRepositoryImpl implements IAccountRepository {
    private final String SELECT_ACCOUNT = "SELECT * FROM account_users;";
    private final String GET_ROLE_USER = "SELECT r.role_name \n" +
            "FROM users_role  AS u\n" +
            "INNER JOIN account_users AS ac ON u.account_id = ac.account_id\n" +
            "INNER JOIN roles AS r ON u.role_id = r.role_id\n" +
            "WHERE ac.account_id = ?;";

    @Override
    public String checkRole(int id) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ROLE_USER);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                return resultSet.getString("role_name");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "";
    }

    @Override
    public List<Account> getAllAccount() {
        List<Account> accountList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ACCOUNT);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("account_id");
                String userName = resultSet.getString("user_name");
                String password = resultSet.getString("password");
                Account account = new Account(id,userName,password);
                accountList.add(account);
            }
            return accountList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
