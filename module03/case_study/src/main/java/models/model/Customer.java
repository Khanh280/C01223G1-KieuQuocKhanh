package models.model;

public class Customer {
    private int id;
    private String name;
    private String email;
    private String phoneNumber;
    private String address;
    private Account account;
    private String createAt;
    private String updateAt;

    public Customer() {
    }

    public Customer(int id, String name, Account account) {
        this.id = id;
        this.name = name;
        this.account = account;
    }

    public Customer(int id, String name, String email, String phoneNumber, String address, String createAt, String updateAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public Customer(String name, String email, String phoneNumber, String address, Account account) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.account = account;
    }

    public Customer(int id, String name, String email, String phoneNumber,
                    String address, Account account, String createAt, String updateAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.account = account;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public Customer(int id, String name, String email, String phoneNumber, String address) {
        this.id =id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public String getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(String updateAt) {
        this.updateAt = updateAt;
    }
}
