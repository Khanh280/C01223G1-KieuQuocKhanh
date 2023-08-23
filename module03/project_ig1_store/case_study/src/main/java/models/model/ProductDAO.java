package models.model;

public class ProductDAO {
    private int id;
    private String name;
    private int productType;
    private String describe;
    private double price;
    private String productImage;
    private String creatAt;
    private String updateAt;
    private  int orderDetailId;
    private  int quantity;

    public ProductDAO() {
    }

    public ProductDAO(int id, String name, int productType, String describe, double price, String productImage, String creatAt, String updateAt, int orderDetailId, int quantity) {
        this.id = id;
        this.name = name;
        this.productType = productType;
        this.describe = describe;
        this.price = price;
        this.productImage = productImage;
        this.creatAt = creatAt;
        this.updateAt = updateAt;
        this.orderDetailId = orderDetailId;
        this.quantity = quantity;
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

    public int getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(int orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
