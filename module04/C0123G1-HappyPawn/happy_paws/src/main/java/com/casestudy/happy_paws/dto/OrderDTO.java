package com.casestudy.happy_paws.dto;

import com.casestudy.happy_paws.model.Customer;
import java.time.LocalDateTime;

public class OrderDTO {
    private Long id;
    private Customer customer;

    private LocalDateTime buyDate;
    private Double price;

    public OrderDTO() {
    }

    public OrderDTO(Long id, Customer customer, LocalDateTime buyDate,Double price) {
        this.id = id;
        this.customer = customer;
        this.buyDate = buyDate;
        this.price=price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public LocalDateTime getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(LocalDateTime buyDate) {
        this.buyDate = buyDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
