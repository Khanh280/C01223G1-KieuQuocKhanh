package models.repository;

import models.model.Customer;
import models.model.CustomerDAO;
import models.model.OrderDetail;
import models.model.ProductDAO;

import java.util.List;

public interface IOrderDetailRepository {
    boolean addOrderDetail(OrderDetail orderDetail);
    boolean deleteOrderDetail(int productId);
    List<ProductDAO> getOrderDetailProduct(int customerId);
    List<ProductDAO> searchOrderDetailProduct(int customerId, String customerName);

    List<OrderDetail> getOrderDetail( int customerId);
    List<CustomerDAO> getCustomerOrder();
    List<CustomerDAO> searchCustomerOrder(String customerName, String phoneNumber);
    boolean updateOrderDetail(int quantity,int orderDetailId);
    ProductDAO getOrderDetailById(int orderDetailId);
}
