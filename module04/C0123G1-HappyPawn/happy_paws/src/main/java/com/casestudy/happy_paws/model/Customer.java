package com.casestudy.happy_paws.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;

    @Column(name = "name", nullable = false, columnDefinition = "VARCHAR(100)")
    private String name;
    @Column(name = "phone", nullable = false,unique = true, columnDefinition = "VARCHAR(10)")

    private String phone;
    @Column(name = "email", nullable = false,unique = true, columnDefinition = "VARCHAR(100)")
    private String email;
    @Column(name = "address", nullable = false, columnDefinition = "VARCHAR(100)")
    private String address;

    private boolean idDelete ;

    @ManyToOne
    @JoinColumn
    private Account account;


    @Column(name = "create_time" ,updatable = false,nullable = false,columnDefinition ="TIMESTAMP DEFAULT now()" )
    @CreationTimestamp
    private LocalDateTime createTime ;
    @Column(name = "update_time",nullable = false,updatable = false,columnDefinition = "TIMESTAMP DEFAULT now()")
    @UpdateTimestamp
    private  LocalDateTime updateTime ;

    public Customer(Integer customerId, String name, String phone, String email, String address, Account account, LocalDateTime createTime, LocalDateTime updateTime,boolean idDelete) {
        this.customerId = customerId;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.account = account;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.idDelete=idDelete;
    }

    public Customer() {
    }

    public Customer(String name, String phone, String email, String address, Account account, LocalDateTime createTime, LocalDateTime updateTime,boolean idDelete) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.account = account;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.idDelete = idDelete;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public boolean isIdDelete() {
        return idDelete;
    }

    public void setIdDelete(boolean idDelete) {
        this.idDelete = idDelete;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

}
