package com.casestudy.happy_paws.model;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer accountId;

    @Column(name = "username",nullable = false,unique = true,columnDefinition = "VARCHAR(100)")
    private String username ;
    @Column(name = "password",nullable = false,columnDefinition = "VARCHAR(100)")
    private String password ;

    @NotNull
    private int code ;
    @NotNull
    private boolean enable ;

    private boolean isDelete;

   @ManyToOne
    private Role role;

    @Column(name = "create_time",nullable = false,updatable = false,columnDefinition = "TIMESTAMP DEFAULT now()")
    @CreationTimestamp
    private LocalDateTime createTime ;

    @Column(name = "update_time",nullable = false,updatable = false,columnDefinition = "TIMESTAMP DEFAULT now()")
    @UpdateTimestamp
    private LocalDateTime updateTime ;

    public Account() {
    }

    public Account(Integer accountId, String username, String password, int code, boolean enable, Role role,boolean  isDelete) {
        this.accountId = accountId;
        this.username = username;
        this.password = password;
        this.code = code;
        this.enable = enable;
        this.role = role;
        this.isDelete = isDelete;
    }

    public Account(Integer accountId, String username, String password, int code, boolean enable, Role role, LocalDateTime createTime, LocalDateTime updateTime,boolean isDelete) {
        this.accountId = accountId;
        this.username = username;
        this.password = password;
        this.code = code;
        this.enable = enable;
        this.role = role;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.isDelete = isDelete;
    }

    public Account(String username, String password, Role admin) {
        this.username = username;
        this.password = password;
        this.role=admin;
    }

    public Account(Integer accountId, String username, String password, int code, boolean enable, Role role) {
        this.accountId = accountId;
        this.username = username;
        this.password = password;
        this.code = code;
        this.enable = enable;
        this.role = role;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
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

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }
}
