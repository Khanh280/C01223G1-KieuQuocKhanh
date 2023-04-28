package models.model;

public class Product {
    private int id;
    private String productName;
    private float price;
    private String productDetail;

    public Product() {
    }

    public Product(int id, String productName, float price, String productDetail) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.productDetail = productDetail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getProductDetail() {
        return productDetail;
    }

    public void setProductDetail(String productDetail) {
        this.productDetail = productDetail;
    }
}
