package com.casestudy.happy_paws.service;

import com.casestudy.happy_paws.model.PetService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IPetServiceService {
    Page<PetService> findPage(Pageable pageable);

    void save(PetService petService);

    PetService findById(Long id);

    void deleteById(Long id);

    Page<PetService> searchPage(String search,Pageable pageable);

    List<PetService> findAll();

    List<PetService> findByBookingServiceIdJoinWithBookingService(Long bookingServiceId);
}
