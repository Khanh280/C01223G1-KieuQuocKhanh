package com.casestudy.happy_paws.repository;

import com.casestudy.happy_paws.model.Cart;
import com.casestudy.happy_paws.model.OrderDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IOrderDetailRepository extends JpaRepository<OrderDetail, Long> {
    @Query(value = "select od from OrderDetail od where od.order.id = :orderId and od.isDelete = false ")
    Page<OrderDetail> findAllOrderDetailByOrderId(Pageable pageable, @Param("orderId") Long orderId);

    @Query(value = "select od from OrderDetail  od where od.products.name like :name and od.order.id= :orderId and od.isDelete = false")
    Page<OrderDetail> searchProductOrderDetail(@Param("name") String name, @Param("orderId") Long orderId, Pageable pageable);

    @Query(value = "select sum(od.price * od.quantity) from  OrderDetail  od where od.order.id = :orderId and od.isDelete = false")
    Double getTotalPriceOrder(@Param("orderId") Long orderId);

    @Query(value = "update OrderDetail set isDelete = true where id = :orderDetailId and isDelete = false")
    @Modifying
    @Transactional
    void deleteOrderDetailById(@Param("orderDetailId") Long orderDetailId);

    @Query(value = "select od from OrderDetail od where od.id = :orderDetailId and od.isDelete = false")
    OrderDetail findOrderDetailById(@Param("orderDetailId") Long orderDetailId);

    @Query(value = "select sum(od.price * od.quantity) from OrderDetail od where od.isDelete=false ")
    Double findTotalPriceOrderDetail();
    @Query(value = "select c from Cart c where c.customer.customerId = :customerId and c.pendingStatus = false")
    List<Cart> findAllCart(@Param("customerId") Integer customerId);
}
