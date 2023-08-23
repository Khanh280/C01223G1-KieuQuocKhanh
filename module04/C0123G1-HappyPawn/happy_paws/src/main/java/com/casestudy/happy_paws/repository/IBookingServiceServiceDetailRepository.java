package com.casestudy.happy_paws.repository;

import com.casestudy.happy_paws.model.BookingServiceDetail;
import com.casestudy.happy_paws.service.impl.BookingServiceServiceDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBookingServiceServiceDetailRepository extends JpaRepository<BookingServiceDetail,Long> {


    @Query(value = "SELECT\n" +
            "       sum(bd.price) as total\n" +
            "FROM booking_service as bs\n" +
            "INNER JOIN booking_service_detail as bd on bs.booking_service_id = bd.booking_service_id\n" +
            "\n" +
            "WHERE (bs.is_delete = 0) and (bs.booking_service_id = ?1 )\n" +
            "GROUP BY bs.booking_service_id\n" +

            ";", nativeQuery = true)
    Double getTotal(Long bookingServiceId);



    @Query(value = "SELECT * FROM booking_service_detail WHERE booking_service_id = :id" ,nativeQuery = true)
//    @Query(value = "SELECT d.* FROM booking_service_detail as d WHERE booking_service_id = :id" )
    List<BookingServiceDetail> findByBookingServiceId( @Param("id") Long bookingServiceId);


    @Query(value = "SELECT * FROM booking_service_detail\n" +
            "         INNER JOIN pet_service PS ON booking_service_detail.pet_service_id = PS.pet_service_id\n" +
            "WHERE booking_service_id = :id" , nativeQuery = true)
    List<BookingServiceDetail> findByBookingServiceIdJoinWithPetService(@Param("id") Long bookingServiceId);
}
