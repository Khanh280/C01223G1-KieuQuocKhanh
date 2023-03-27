package io_binary_file.product_manager.models;

import java.io.Serializable;

public class Product implements Serializable {
    private int horseProduct;
    private String nameProduct;
    private String price;
    private String manufacturers;
    private String describe;

    public Product() {
    }

    public Product(int horseProduct, String nameProduct, String price, String manufacturers, String describe) {
        this.horseProduct = horseProduct;
        this.nameProduct = nameProduct;
        this.price = price;
        this.manufacturers = manufacturers;
        this.describe = describe;
    }

    public int getHorseProduct() {
        return horseProduct;
    }

    public void setHorseProduct(int horseProduct) {
        this.horseProduct = horseProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getManufacturers() {
        return manufacturers;
    }

    public void setManufacturers(String manufacturers) {
        this.manufacturers = manufacturers;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    @Override
    public String toString() {
        return "Product{" +
                "horseProduct=" + this.getHorseProduct() +
                ", nameProduct='" + this.getNameProduct() + '\'' +
                ", price='" + this.getPrice() + '\'' +
                ", manufacturers='" + this.getManufacturers() + '\'' +
                ", describe='" + this.getDescribe() + '\'' +
                '}';
    }

    public String getInfoToCSV() {
        return this.getHorseProduct() +
                "," + this.getNameProduct() +
                "," + this.getPrice() +
                "," + this.getManufacturers() +
                "," + this.getDescribe();
    }
}
