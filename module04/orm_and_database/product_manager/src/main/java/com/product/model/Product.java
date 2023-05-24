package com.product.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String codeProduct;
    private String name;
    private String description;
    private Double price;
    private String branch;

    public Product() {
    }

    public Product(String codeProduct, String name, String description, Double price, String branch) {
        this.codeProduct = codeProduct;
        this.name = name;
        this.description = description;
        this.price = price;
        this.branch = branch;
    }

    public Product(Integer id, String codeProduct, String name, String description, Double price, String branch) {
        this.id = id;
        this.codeProduct = codeProduct;
        this.name = name;
        this.description = description;
        this.price = price;
        this.branch = branch;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodeProduct() {
        return codeProduct;
    }

    public void setCodeProduct(String codeProduct) {
        this.codeProduct = codeProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }
}
