package com.casestudy.happy_paws.model;
import javax.persistence.*;
@Entity
//@Table(uniqueConstraints = {
//        @UniqueConstraint(name = "UK" , columnNames = {"pet_service_id", "booking_service_id"})
//})
public class BookingServiceDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double price;
    @ManyToOne
    @JoinColumn(name = "pet_service_id",nullable = false)
    private PetService petService;
    @ManyToOne
    @JoinColumn(name = "booking_service_id",nullable = false)
    private BookingService bookingService;
    public BookingServiceDetail(Long id, Double price, PetService petService, BookingService bookingService) {
        this.id = id;
        this.price = price;
        this.petService = petService;
        this.bookingService = bookingService;
    }
    public BookingServiceDetail() {
    }
    public BookingServiceDetail(Double price, PetService petService, BookingService bookingService) {
        this.price = price;
        this.petService = petService;
        this.bookingService = bookingService;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public PetService getPetService() {
        return petService;
    }
    public void setPetService(PetService petService) {
        this.petService = petService;
    }
    public BookingService getBookingService() {
        return bookingService;
    }
    public void setBookingService(BookingService bookingService) {
        this.bookingService = bookingService;
    }
}