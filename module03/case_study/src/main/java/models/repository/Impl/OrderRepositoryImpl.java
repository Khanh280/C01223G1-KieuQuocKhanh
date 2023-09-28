package models.repository.Impl;

import models.model.Order;
import models.repository.BaseRepository;
import models.repository.IOrderRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderRepositoryImpl implements IOrderRepository {
    private final String SELECT_ORDER = "SELECT o.order_id, c.customer_name, SUM(od.price) as price_total , o.order_date\n" +
            "from customers as c \n" +
            "inner join `orders` as o on c.customer_id = o.customer_id\n" +
            "INNER join order_detail as od on o.order_id = od.order_id\n" +
            "GROUP BY o.order_id;";

    private final String INSERT_ORDER = "INSERT into `orders` (customer_id) VALUES (?);";
    private final String SELECT_ORDER_BY_ID = "SELECT * FROM orders WHERE customer_id = ?;";

    @Override
    public boolean addOrder(int customerId) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ORDER);
            preparedStatement.setInt(1,customerId);
            return preparedStatement.executeUpdate() >0;
        } catch (SQLException e) {
           e.printStackTrace();
        }
        return false;
    }

    @Override
    public int getOrderId(int customerId) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ORDER_BY_ID);
            preparedStatement.setInt(1,customerId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                if(resultSet.getInt("customer_id") == customerId){
                    int orderId = resultSet.getInt("order_id");
                  return orderId;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Order> getAll() {
        List<Order> orderList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ORDER);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("order_id");
                String customerName = resultSet.getString("customer_name");
                double price = resultSet.getDouble("price_total");
                String orderDate = resultSet.getString("order_date");
                Order order = new Order(id,customerName,price,orderDate);
                orderList.add(order);
            }
            return orderList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
