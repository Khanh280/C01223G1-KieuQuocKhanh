package models.model;

public class Products {
    private int productId;
    private String productName;
    private int productType;
    private String describe;
    private double price;
    private String imageUrl;


    public Products() {
    }

    public Products(int productId, String productName, int productType, String describe, double price, String imageUrl) {
        this.productId = productId;
        this.productName = productName;
        this.productType = productType;
        this.describe = describe;
        this.price = price;
        this.imageUrl = imageUrl;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductType() {
        return productType;
    }

    public void setProductType(int productType) {
        this.productType = productType;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
