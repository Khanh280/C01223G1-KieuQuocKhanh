package com.casestudy.happy_paws.repository;

import com.casestudy.happy_paws.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ICustomerRepository extends JpaRepository<Customer,Integer> {


    @Query(value = "SELECT * FROM customer c INNER JOIN account u ON u.account_id = c.account_account_id  WHERE  c.name LIKE :name AND c.phone LIKE  :phone AND u.username  LIKE :username  AND c.id_delete = false ",nativeQuery = true)
    Page<Customer> findByCustomer(String name, String phone, String username, Pageable pageable);



        @Query(value = "UPDATE Customer  c  SET  c.idDelete = true  WHERE c.customerId = :customerId")
        @Modifying
    @Transactional
    void deleteByIdCustomer(@Param("customerId") Integer customerId);

    @Query(value ="SELECT c FROM Customer c WHERE c.idDelete = false ")
    Page<Customer> findAllCustomer(PageRequest pageRequest);

    @Query(value = "SELECT c FROM Customer c   WHERE  c.name LIKE :s AND c.phone LIKE  :s1  AND c.idDelete = false ")

    Page<Customer> findCustomerToBookService(String s, String s1, Pageable pageable);
    @Query(value = "select c from  Customer c inner  join Account a on c.account.accountId = a.accountId where a.username = :userName and a.isDelete = false")
    Customer findCustomerByUserName(@Param("userName") String userName);


}
