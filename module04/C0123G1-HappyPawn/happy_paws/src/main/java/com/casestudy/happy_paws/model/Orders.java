package com.casestudy.happy_paws.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn
    private Customer customer;
    @Column(nullable = false,updatable = false, columnDefinition = "TIMESTAMP DEFAULT now()")
    @CreationTimestamp
    private LocalDateTime buyDate;

    public Orders() {
    }

    public Orders(Customer customer) {
        this.customer = customer;
    }

    public Orders(Long id , Customer customer) {
        this.id = id;
        this.customer = customer;
    }

    public Orders(Long id, Customer customer, LocalDateTime buyDate) {
        this.id = id;
        this.customer = customer;

        this.buyDate = buyDate;
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
}
