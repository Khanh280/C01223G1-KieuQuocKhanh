package com.casestudy.happy_paws.service;


import com.casestudy.happy_paws.dto.BookingServiceDTO;
import com.casestudy.happy_paws.model.BookingService;
import com.casestudy.happy_paws.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;

public interface IBookingServiceService {

    Page<BookingService> findPage(Pageable pageable);

    void deleteById(Long id);

    Page<Customer> findPageCustomer(Pageable pageable);

    Customer findCustomerById(Integer customerId);

    void save(BookingService bookingService);

    BookingService findBookingServiceById(Long bookingServiceId);

    Page<BookingService> searchByDate(Pageable pageable, LocalDate date);



    List<BookingService> findAll();

    List<BookingService> searchByDateWithTotal(LocalDate date);
}
