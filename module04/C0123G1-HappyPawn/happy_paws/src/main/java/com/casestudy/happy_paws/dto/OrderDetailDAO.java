package com.casestudy.happy_paws.dto;

import com.casestudy.happy_paws.model.Orders;
import com.casestudy.happy_paws.model.Product;

import java.time.LocalDateTime;

public class OrderDetailDAO {
    private Long id;
    private Product product;

    private Orders order;
    private Integer quantity;
    private Double price;

    private LocalDateTime createDate;

    private LocalDateTime updateDate;

    public OrderDetailDAO() {
    }

    public OrderDetailDAO(Long id, Product product, Orders order, Integer quantity, Double price, LocalDateTime createDate, LocalDateTime updateDate) {
        this.id = id;
        this.product = product;
        this.order = order;
        this.quantity = quantity;
        this.price = price;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProducts() {
        return product;
    }

    public void setProducts(Product product) {
        this.product = product;
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }
}
