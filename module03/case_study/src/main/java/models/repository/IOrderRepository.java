package models.repository;

import models.model.Order;

import java.util.List;

public interface IOrderRepository {
    boolean addOrder(int customerId);
    int getOrderId(int customerId);
    List<Order> getAll();
}
