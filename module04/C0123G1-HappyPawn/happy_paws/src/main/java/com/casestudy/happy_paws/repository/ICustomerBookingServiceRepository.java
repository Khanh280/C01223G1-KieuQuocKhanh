package com.casestudy.happy_paws.repository;

import com.casestudy.happy_paws.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerBookingServiceRepository extends JpaRepository<Customer,Integer> {
}
