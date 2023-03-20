package user_arrray_list_and_linked_list_in_java.models;

import java.util.Comparator;

public class Product implements Comparator<Product> {
    private int id;
    private String nameProduct;
    private String price;
    private String manuFacturers;
    private int numberOfProducts;

    public Product() {
    }


    public Product(int id, String nameProduct, String price, String manuFacturers, int numberOfProducts) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.price = price;
        this.manuFacturers = manuFacturers;
        this.numberOfProducts = numberOfProducts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getManuFacturers() {
        return manuFacturers;
    }

    public void setManuFacturers(String manuFacturers) {
        this.manuFacturers = manuFacturers;
    }

    public int getNumberOfProducts() {
        return numberOfProducts;
    }

    public void setNumberOfProducts(int numberOfProducts) {
        this.numberOfProducts = numberOfProducts;
    }


    @Override
    public String toString() {
        return "IdProduct='" + id + '\'' +
                "NameProduct='" + nameProduct + '\'' +
                " Price='" + price + '\'' +
                " Manufacturers='" + manuFacturers + '\'' +
                " Number of products ='" + numberOfProducts + '\'';
    }

    @Override
    public int compare(Product o1, Product o2) {
        return o1.price.compareTo(o2.price);
    }

    @Override
    public Comparator reversed() {
        return Comparator.super.reversed();
    }
}
