package com.exam05.dto;

import com.exam05.model.Product;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class OrderDTO {
    private Long id;
    private Product product;
    private Double productPrice;
    private String buyDate;
    private Long quantity;
    private Double totalPrice;

    public OrderDTO() {
    }

    public OrderDTO(Long id, Product product, Double productPrice, String buyDate,Long quantity, Double totalPrice) {
        this.id = id;
        this.product = product;
        this.productPrice = productPrice;
        this.buyDate = buyDate;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public String getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(String buyDate) {
        this.buyDate = buyDate;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
