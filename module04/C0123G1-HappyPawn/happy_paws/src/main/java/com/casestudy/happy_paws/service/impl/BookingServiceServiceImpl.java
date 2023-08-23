package com.casestudy.happy_paws.service.impl;

import com.casestudy.happy_paws.dto.BookingServiceDTO;
import com.casestudy.happy_paws.model.BookingService;
import com.casestudy.happy_paws.model.Customer;
import com.casestudy.happy_paws.repository.IBookingServiceRepository;
import com.casestudy.happy_paws.repository.ICustomerBookingServiceRepository;
import com.casestudy.happy_paws.service.IBookingServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BookingServiceServiceImpl implements IBookingServiceService {
    @Autowired
    private IBookingServiceRepository iBookingServiceRepository;

    @Autowired
    private ICustomerBookingServiceRepository iCustomerBookingServiceRepository;

    @Override
    public Page<BookingService> findPage(Pageable pageable) {
        return iBookingServiceRepository.findAllWithTotal(pageable);
    }

    @Override
    public void deleteById(Long id) {
        iBookingServiceRepository.deleteById(id);
    }

    @Override
    public Page<Customer> findPageCustomer(Pageable pageable) {
        return iCustomerBookingServiceRepository.findAll(pageable);
    }

    @Override
    public Customer findCustomerById(Integer customerId) {
        return iCustomerBookingServiceRepository.findById(customerId).get();
    }

    @Override
    public void save(BookingService bookingService) {
        iBookingServiceRepository.save(bookingService);
    }

    @Override
    public BookingService findBookingServiceById(Long bookingServiceId) {
        return iBookingServiceRepository.findById(bookingServiceId).get();
    }

    @Override
    public Page<BookingService> searchByDate(Pageable pageable, LocalDate searchDate) {
        return iBookingServiceRepository.searchByDate(pageable, searchDate);
    }



    @Override
    public List<BookingService> findAll() {

        return iBookingServiceRepository.findAll();
    }

    @Override
    public List<BookingService> searchByDateWithTotal(LocalDate date) {
        return iBookingServiceRepository.searchByDateWithTotal(date);
    }
}
