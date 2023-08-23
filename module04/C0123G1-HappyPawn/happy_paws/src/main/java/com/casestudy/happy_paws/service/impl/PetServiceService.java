package com.casestudy.happy_paws.service.impl;

import com.casestudy.happy_paws.model.PetService;
import com.casestudy.happy_paws.repository.IPetServiceRepository;
import com.casestudy.happy_paws.service.IPetServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetServiceService implements IPetServiceService {
    @Autowired private IPetServiceRepository iPetServiceRepository;
    @Override
    public Page<PetService> findPage(Pageable pageable) {
        return iPetServiceRepository.findAll(pageable);
    }

    @Override
    public void save(PetService petService) {
        iPetServiceRepository.save(petService);
    }

    @Override
    public PetService findById(Long id) {
        return iPetServiceRepository.findById(id).get();
    }

    @Override
    public void deleteById(Long id) {
        iPetServiceRepository.deleteById(id);
    }

    @Override
    public Page<PetService> searchPage(String search,Pageable pageable) {
        return iPetServiceRepository.searchPage('%'+search+'%',pageable);
    }

    @Override
    public List<PetService> findAll() {
        return iPetServiceRepository.findAll();
    }

    @Override
    public List<PetService> findByBookingServiceIdJoinWithBookingService(Long bookingServiceId) {
        return iPetServiceRepository.findByBookingServiceIdJoinWithBookingService(bookingServiceId);
    }
}
