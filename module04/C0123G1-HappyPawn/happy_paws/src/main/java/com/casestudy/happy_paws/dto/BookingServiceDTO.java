package com.casestudy.happy_paws.dto;

import com.casestudy.happy_paws.model.Customer;

import java.time.LocalDate;
import java.util.Date;

public class BookingServiceDTO {

    private Long bookingServiceId;
    private Customer customer;


    private LocalDate bookingDate;

    private String bookingTime;

    private Date createTime;
    private Date updateTime;
    private Double total;

    public BookingServiceDTO(Long bookingServiceId, Customer customer, LocalDate bookingDate, String bookingTime, Date createTime, Date updateTime, Double price) {
        this.bookingServiceId = bookingServiceId;
        this.customer = customer;
        this.bookingDate = bookingDate;
        this.bookingTime = bookingTime;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.total = price;
    }

    public BookingServiceDTO(Customer customer, LocalDate bookingDate, String bookingTime, Double price) {
        this.customer = customer;
        this.bookingDate = bookingDate;
        this.bookingTime = bookingTime;
        this.total = price;
    }

    public BookingServiceDTO(Customer customer, LocalDate bookingDate, String bookingTime) {
        this.customer = customer;
        this.bookingDate = bookingDate;
        this.bookingTime = bookingTime;
    }

    public BookingServiceDTO() {
    }

    public Long getBookingServiceId() {
        return bookingServiceId;
    }

    public void setBookingServiceId(Long bookingServiceId) {
        this.bookingServiceId = bookingServiceId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(String bookingTime) {
        this.bookingTime = bookingTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
