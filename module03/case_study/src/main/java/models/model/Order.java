package models.model;

public class Order {
    private int id;
    private String customerName;
    private double price;
    private String orderDate;

    public Order() {
    }

    public Order(int id, String customer_name, double price, String order_date) {
        this.id = id;
        this.customerName = customer_name;
        this.price = price;
        this.orderDate = order_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }
}
