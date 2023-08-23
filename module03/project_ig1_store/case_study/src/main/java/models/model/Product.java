package models.model;

public class Product {
    private int id;
    private String name;
    private int productType;
    private String describe;
    private double price;
    private String productImage;
    private String creatAt;
    private String updateAt;

    public Product() {
    }

    public Product(String name, int productType, String describe, double price, String productImage, String updateAt) {
        this.name = name;
        this.productType = productType;
        this.describe = describe;
        this.price = price;
        this.productImage = productImage;
        this.updateAt = updateAt;
    }

    public Product(int id, String name, int productType, String describe, double price, String productImage) {
        this.id = id;
        this.name = name;
        this.productType = productType;
        this.describe = describe;
        this.price = price;
        this.productImage = productImage;
    }

    public Product(int id, String name, int productType, String describe, double price, String productImage, String creatAt, String updateAt) {
        this.id = id;
        this.name = name;
        this.productType = productType;
        this.describe = describe;
        this.price = price;
        this.productImage = productImage;
        this.creatAt = creatAt;
        this.updateAt = updateAt;
    }

    public Product(String name, int productType, String describe, double price, String productImage) {
        this.name = name;
        this.productType = productType;
        this.describe = describe;
        this.price = price;
        this.productImage = productImage;
    }

    public Product(int id, String name, int productType, String describe, double price, String productImage, String updateAt) {
        this.id=id;
        this.name = name;
        this.productType = productType;
        this.describe = describe;
        this.price = price;
        this.productImage = productImage;
        this.updateAt = updateAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getCreatAt() {
        return creatAt;
    }

    public void setCreatAt(String creatAt) {
        this.creatAt = creatAt;
    }

    public String getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(String updateAt) {
        this.updateAt = updateAt;
    }
}
