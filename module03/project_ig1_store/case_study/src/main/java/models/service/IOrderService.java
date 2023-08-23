package models.service;

import models.model.Order;

import java.util.List;

public interface IOrderService {
    int getOrderId(int customerId);
    List<Order> getAll();
    boolean addOrder(int customerId);

}
