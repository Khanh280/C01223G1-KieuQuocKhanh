package models.service.impl;

import models.model.Order;
import models.repository.IOrderRepository;
import models.repository.Impl.OrderRepositoryImpl;
import models.service.IOrderService;

import java.util.List;

public class OrderServiceImpl implements IOrderService {
    IOrderRepository orderRepository = new OrderRepositoryImpl();

    @Override
    public int getOrderId(int customerId) {
        return orderRepository.getOrderId(customerId);
    }

    @Override
    public List<Order> getAll() {
        return orderRepository.getAll();
    }

    @Override
    public boolean addOrder(int customerId) {
        return orderRepository.addOrder(customerId);
    }
}
