package com.thymeleaf.model;

public class Product {
    private String codeProduct;
    private String name;
    private String describe;
    private Double price;
    private String branch;

    public Product() {
    }

    public Product(String codeProduct, String name, String describe, Double price, String branch) {
        this.codeProduct = codeProduct;
        this.name = name;
        this.describe = describe;
        this.price = price;
        this.branch = branch;
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

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
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
