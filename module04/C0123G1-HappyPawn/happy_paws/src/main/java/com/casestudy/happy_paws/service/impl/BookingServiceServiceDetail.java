package com.casestudy.happy_paws.service.impl;

import com.casestudy.happy_paws.model.BookingServiceDetail;
import com.casestudy.happy_paws.repository.IBookingServiceServiceDetailRepository;
import com.casestudy.happy_paws.service.IBookingServiceServiceDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceServiceDetail implements IBookingServiceServiceDetail {
    @Autowired private IBookingServiceServiceDetailRepository iBookingServiceServiceDetailRepository;
    @Override
    public void save(BookingServiceDetail bookingServiceDetail) {
        iBookingServiceServiceDetailRepository.save(bookingServiceDetail);
    }

    @Override
    public Double getTotalByIdBooking(Long bookingServiceId) {
        return iBookingServiceServiceDetailRepository.getTotal(bookingServiceId);
    }

    @Override
    public List<BookingServiceDetail> findByBookingServiceId(Long bookingServiceId) {
        return iBookingServiceServiceDetailRepository.findByBookingServiceId(bookingServiceId);
    }

    @Override
    public List<BookingServiceDetail> findByBookingServiceIdJoinWithPetService(Long bookingServiceId) {
        return iBookingServiceServiceDetailRepository.findByBookingServiceIdJoinWithPetService(bookingServiceId);
    }
}
