package com.casestudy.happy_paws.dto;

import com.casestudy.happy_paws.model.Orders;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

public class OrderDetailDTO {

    private Long id;
    private Long productsId;

    private Orders order;
    private Integer quantity;
    private Double price;

    private LocalDateTime createDate;

    private LocalDateTime updateDate;

    public OrderDetailDTO() {
    }

    public OrderDetailDTO( Long productsId, Orders order, Integer quantity, Double price, LocalDateTime createDate, LocalDateTime updateDate) {
        this.productsId = productsId;
        this.order = order;
        this.quantity = quantity;
        this.price = price;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }
    public OrderDetailDTO(Long id, Long productsId, Orders order, Integer quantity, Double price, LocalDateTime createDate, LocalDateTime updateDate) {
        this.id = id;
        this.productsId = productsId;
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

    public Long getProductsId() {
        return productsId;
    }

    public void setProductsId(Long productsId) {
        this.productsId = productsId;
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
