package models.repository.impl;

import models.model.Customer;
import models.repository.BaseRepository;
import models.repository.ICustomerRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl implements ICustomerRepository {
    private final String INSER_ACCOUNT = "INSERT INTO account_customer (user_name,`password`) VALUES (?,?);";
    private final String INSER_CUSTOMER = "INSERT INTO customers(customer_name, email, phone_number, address, account_id ) VALUES (?,?,?,?,?)";
    private final String SELECT_ACCOUNT = "SELECT * from account_customer;";


    @Override
    public void saveCustomer(HttpServletRequest request, HttpServletResponse response) {
        String customerName = request.getParameter("customerName");
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phoneNumber");
        String address = request.getParameter("address");
        String password = request.getParameter("password");
        Connection connection = BaseRepository.getConnectDB();
        try {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(INSER_ACCOUNT);
            preparedStatement.setString(1, customerName);
            preparedStatement.setString(2, password);
            int transction = preparedStatement.executeUpdate();
            if (transction > 0) {
                preparedStatement = connection.prepareStatement(SELECT_ACCOUNT);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    if (resultSet.getString("user_name").equals(customerName)) {
                        int account_id = resultSet.getInt("account_id");
                        preparedStatement = connection.prepareStatement(INSER_CUSTOMER);
                        preparedStatement.setString(1, customerName);
                        preparedStatement.setString(2, email);
                        preparedStatement.setString(3, phoneNumber);
                        preparedStatement.setString(4, address);
                        preparedStatement.setInt(5, account_id);
                        transction += preparedStatement.executeUpdate();
                        break;
                    }
                }
            }
            if(transction == 2){
                connection.commit();
            } else {
                connection.rollback();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean checkAccount(String userName, String password) {
//        for (int i = 0; i < customerList.size(); i++) {
//            if(userName.equals(customerList.get(i).getCustomer_name())){
//                if(password.equals(customerList.get(i).getPassword())){
//                    return true;
//                }
//            }
//        }
        return false;
    }
}
