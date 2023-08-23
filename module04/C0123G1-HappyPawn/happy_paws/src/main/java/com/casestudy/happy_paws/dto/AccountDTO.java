package com.casestudy.happy_paws.dto;

import com.casestudy.happy_paws.model.Role;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AccountDTO {

    private Integer accountId;


    @Size(max = 100, message = "Username cannot longer than 100 character !!!")
    @NotBlank(message = "Please insert value")


    private String username;
    @Size( min=8 ,max = 300, message = "Password star 8 end 300 character !! ")
    @NotBlank(message = "Please insert value")

    private String password;


    private Role role;


    @NotNull
    private int code;
    @NotNull
    private boolean enable;


    public AccountDTO() {
    }

    public AccountDTO(Integer accountId, String username, String password, Role role, int code, boolean enable) {
        this.accountId = accountId;
        this.username = username;
        this.password = password;
        this.role = role;

        this.code = code;
        this.enable = enable;
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

    public Role getRole() {
        return role;
    }


    public void setRole(Role role) {
        this.role = role;
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

}
