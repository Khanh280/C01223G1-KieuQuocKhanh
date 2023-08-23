package com.casestudy.happy_paws.service;

import com.casestudy.happy_paws.dto.OrderDetailDAO;
import com.casestudy.happy_paws.model.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IOrderDetailService {
    Double findTotalPriceOrderDetail();
    Page<Product> findAllProduct(Pageable pageable);
    Page<OrderDetail> findAllOrderDetailByOrderId(Pageable pageable,Long orderId);
    Customer findCustomerById(Integer customerId);
    Product findProductById(Long productId);
    boolean saveOrderDetail(List<OrderDetail> cart, Orders orders);
    Page<OrderDetail> searchProductOrderDetail(String name,Long orderId,Pageable pageable);
    boolean delete(Long orderDetailId);
    Double getTotalPriceOrder(Long orderId);
    List<Cart> findAllCart(Integer customerId);
}
