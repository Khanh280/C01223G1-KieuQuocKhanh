package com.exam05.service;

import com.exam05.model.Orders;
import com.exam05.repository.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService {
    @Autowired
    private IOrderRepository iOrderRepository;

    @Override
    public List<Orders> findAll() {
        return iOrderRepository.findAllOrder();
    }

    @Override
    public boolean saveOrder(Orders orders) {
        iOrderRepository.createOrder(orders.getBuyDate(), orders.getProduct().getPrice(), orders.getQuantity(), orders.getTotalPrice(), orders.getProduct().getId());
        return true;
    }

    @Override
    public boolean deleteOrder(Long id) {
        iOrderRepository.deleteOrder(id);
        return true;
    }

    @Override
    public Orders findById(Long id) {
        return iOrderRepository.findOrderById(id);
    }

    @Override
    public void updateOrder(Orders orders) {
        iOrderRepository.updateOrder(orders.getBuyDate(), orders.getProduct().getPrice(), +orders.getQuantity(), orders.getTotalPrice(), orders.getProduct().getId(), orders.getId());
    }

    @Override
    public List<Orders> searchOrder(String startDate, String endDate, String productName) {
        return iOrderRepository.searchOrder(startDate,  endDate, '%' + productName + '%');
    }

}
