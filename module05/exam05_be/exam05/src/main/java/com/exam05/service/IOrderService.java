package com.exam05.service;

import com.exam05.model.Orders;

import java.util.List;

public interface IOrderService {
    List<Orders> findAll();
    boolean saveOrder(Orders orders);
    boolean deleteOrder(Long id);
    Orders findById(Long id);
    void updateOrder(Orders orders);
    List<Orders> searchOrder(String startDate,String endDate,String productId);
}
