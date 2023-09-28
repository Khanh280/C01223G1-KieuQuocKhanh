package com.exam05.repository;

import com.exam05.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IOrderRepository extends JpaRepository<Orders, Long> {
    @Query(value = "select o from Orders o ")
    List<Orders> findAllOrder();

    @Modifying
    @Transactional
    @Query(value = "insert into orders (buy_date,product_price,quantity,total_price,product_id) values (:buyDate,:productPrice,:quantity,:totalPrice,:productId)", nativeQuery = true)
    void createOrder(@Param("buyDate") String buyDate, @Param("productPrice") Double productPrice, @Param("quantity") Long quantity,
                     @Param("totalPrice") Double totalPrice, @Param("productId") Long productId);

    @Query(value = "delete from Orders o where  o.id =:id")
    @Modifying
    @Transactional
    void deleteOrder(@Param("id") Long id);

    @Query(value = "select o from Orders o where o.id =:id")
    Orders findOrderById(@Param("id") Long id);

    @Query(value = "update Orders o set o.buyDate = :buyDate,o.productPrice=:productPrice,o.quantity = :quantity,o.totalPrice=:totalPrice,o.product.id=:productId where o.id =:orderId")
    @Modifying
    @Transactional
    void updateOrder(@Param("buyDate") String buyDate, @Param("productPrice") Double productPrice, @Param("quantity") Long quantity,
                     @Param("totalPrice") Double totalPrice, @Param("productId") Long productId, @Param("orderId") Long orderId);

    @Query(value = "select * from orders o inner join product p on o.product_id = p.id where (o.buy_date between :startDate and :endDate or (:startDate is null and :endDate is null)) and p.name like :productName", nativeQuery = true)
    List<Orders> searchOrder(@Param("startDate") String startDate, @Param("endDate") String endDate, @Param("productName") String productName);
}
