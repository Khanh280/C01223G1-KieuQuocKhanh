package com.casestudy.happy_paws.repository;

import com.casestudy.happy_paws.model.PetService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPetServiceRepository extends JpaRepository<PetService, Long> {
    @Query(value = "SELECT p FROM PetService AS p WHERE ( p.isDelete=false ) AND (p.name LIKE :search) ORDER BY p.updateTime DESC ")
    Page<PetService> searchPage(String search, Pageable pageable);


    @Query(value = "SELECT * FROM booking_service_detail INNER JOIN booking_service bs ON booking_service_detail.booking_service_id = bs.booking_service_id INNER  JOIN pet_service ps ON booking_service_detail.pet_service_id = ps.pet_service_id WHERE bs.booking_service_id = :id", nativeQuery = true)
    List<PetService> findByBookingServiceIdJoinWithBookingService(@Param("id") Long bookingServiceId);
}
