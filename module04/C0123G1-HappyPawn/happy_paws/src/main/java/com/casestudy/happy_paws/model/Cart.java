package com.casestudy.happy_paws.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;
    @ManyToOne
    @JoinColumn
    private Product product;
    @ManyToOne
    @JoinColumn
    private Customer customer;

    private Integer quantity;
    @Column(name = "date_create", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT now()")
    @CreationTimestamp
    private LocalDateTime dateCreate;
    @Column(name = "date_update", nullable = false, columnDefinition = "TIMESTAMP DEFAULT now()")
    @UpdateTimestamp
    private LocalDateTime dateUpdate;
    @Column(columnDefinition = "BIT DEFAULT 0")
    private boolean pendingStatus;


    public Cart() {
    }

    public Cart(Long cartId, Product product, Customer customer, Integer quantity, LocalDateTime dateCreate, LocalDateTime dateUpdate,boolean pendingStatus) {
        this.cartId = cartId;
        this.product = product;
        this.customer = customer;
        this.quantity = quantity;
        this.dateCreate = dateCreate;
        this.dateUpdate = dateUpdate;
        this.pendingStatus = pendingStatus;
    }

    public Cart(Product product, Customer customer, Integer quantity) {
        this.product = product;
        this.customer = customer;
        this.quantity = quantity;
    }

    public Cart(Product product, Customer customer, Integer quantity, LocalDateTime dateCreate, LocalDateTime dateUpdate) {
        this.product = product;
        this.customer = customer;
        this.quantity = quantity;
        this.dateCreate = dateCreate;
        this.dateUpdate = dateUpdate;
    }

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(LocalDateTime dateCreate) {
        this.dateCreate = dateCreate;
    }

    public LocalDateTime getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(LocalDateTime dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

    public boolean isPendingStatus() {
        return pendingStatus;
    }

    public void setPendingStatus(boolean pendingStatus) {
        this.pendingStatus = pendingStatus;
    }
}
