package com.casestudy.happy_paws.repository;

import com.casestudy.happy_paws.model.Customer;
import com.casestudy.happy_paws.model.Orders;
import com.casestudy.happy_paws.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IOrderRepository extends JpaRepository<Orders, Long> {
    @Query(value = "select o from Orders o inner join OrderDetail od on o.id = od.order.id where od.isDelete = false and o.customer.name like :name and o.customer.phone like :phone  group by o.id")
    Page<Orders> searchByNameAndPhone(@Param("name") String name, @Param("phone") String phone, Pageable pageable);

    @Query(value = "select c from Customer c where c.name like :name and c.phone like :phone")
    Page<Customer> searchCustomerByNameAndPhone(@Param("name") String name, @Param("phone") String phone, Pageable pageable);

    @Query(value = "select o from Orders o inner join OrderDetail od on o.id = od.order.id and od.isDelete = false group by o.id")
    Page<Orders> findAllOrders(Pageable pageable);

    //    @Query(value = "select p from  Product  p where p.name like :name and ( p.price between :start and :end)")
    @Query(value = "select p from Product p where p.name like :name and (p.price between :start and :end)")
    Page<Product> searchProductByNameAndPrice(@Param("name") String name, @Param("start") Double start, @Param("end") Double end, Pageable pageable);
}
