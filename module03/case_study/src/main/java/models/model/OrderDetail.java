package models.model;

public class OrderDetail {
    private  int orderDetailId;
    private int orderId;
    private int customerId;
    private int productId;
    private int productTypeId;
    private double price;
    private int quantity;

    public OrderDetail() {
    }

    public OrderDetail(int orderDetailId, int orderId, int customerId, int productId, int productTypeId, double price, int quantity) {
        this.orderDetailId = orderDetailId;
        this.orderId = orderId;
        this.customerId = customerId;
        this.productId = productId;
        this.productTypeId = productTypeId;
        this.price = price;
        this.quantity = quantity;
    }

    public OrderDetail(int orderId, int customerId, int productId, int productTypeId, double price, int quantity) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.productId = productId;
        this.productTypeId = productTypeId;
        this.price = price;
        this.quantity = quantity;
    }

    public int getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(int orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(int productTypeId) {
        this.productTypeId = productTypeId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
