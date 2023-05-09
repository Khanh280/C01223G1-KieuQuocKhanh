package models.model;

public class Customer {
    private int id_customer;
    private String customer_name;
    private String email;
    private String address;
    private String password;

    public Customer() {
    }

    public Customer(int id_customer, String customer_name, String email, String address, String password) {
        this.id_customer = id_customer;
        this.customer_name = customer_name;
        this.email = email;
        this.address = address;
        this.password = password;
    }

    public int getId_customer() {
        return id_customer;
    }

    public void setId_customer(int id_customer) {
        this.id_customer = id_customer;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
