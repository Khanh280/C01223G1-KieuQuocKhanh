package models.service.impl;

import models.model.Customer;
import models.model.CustomerDAO;
import models.model.OrderDetail;
import models.model.ProductDAO;
import models.repository.IOrderDetailRepository;
import models.repository.Impl.OrderDetailRepositoryImpl;
import models.service.IOrderDetailSevice;

import java.util.List;

public class OrderDetailServiceImpl implements IOrderDetailSevice {
    IOrderDetailRepository orderDetailRepository = new OrderDetailRepositoryImpl();
    @Override
    public boolean addOrderDetail(OrderDetail orderDetail) {
        return orderDetailRepository.addOrderDetail(orderDetail);
    }

    @Override
    public boolean deleteOrderDetail(int productOrderDetailId) {
        return orderDetailRepository.deleteOrderDetail(productOrderDetailId);
    }

    @Override
    public List<ProductDAO> getOrderDetailProduct(int customerId) {
        return orderDetailRepository.getOrderDetailProduct(customerId);
    }

    @Override
    public List<ProductDAO> searchOrderDetailProduct(int customerId, String customerName) {
        return orderDetailRepository.searchOrderDetailProduct(customerId,customerName);
    }

    @Override
    public List<OrderDetail> getOrderDetail( int customerId) {
        return orderDetailRepository.getOrderDetail(customerId);
    }

    @Override
    public List<CustomerDAO> searchCustomerOrder(String customerName, String phoneNumber) {
        return orderDetailRepository.searchCustomerOrder(customerName,phoneNumber);
    }

    @Override
    public List<CustomerDAO> getCustomerOrder() {
        return orderDetailRepository.getCustomerOrder();
    }

    @Override
    public boolean updateOrderDetail(int quantity, int orderDetailId) {
        return orderDetailRepository.updateOrderDetail(quantity,orderDetailId);
    }

    @Override
    public ProductDAO getOrderDetailById(int orderDetailId) {
        return orderDetailRepository.getOrderDetailById(orderDetailId);
    }
}
