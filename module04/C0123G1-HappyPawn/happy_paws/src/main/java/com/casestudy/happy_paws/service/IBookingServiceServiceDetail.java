package com.casestudy.happy_paws.service;

import com.casestudy.happy_paws.model.BookingServiceDetail;

import java.util.List;

public interface IBookingServiceServiceDetail {
    void save(BookingServiceDetail bookingServiceDetail);

    Double getTotalByIdBooking(Long bookingServiceId);

    List<BookingServiceDetail> findByBookingServiceId(Long bookingServiceId);

    List<BookingServiceDetail> findByBookingServiceIdJoinWithPetService(Long bookingServiceId);
}
