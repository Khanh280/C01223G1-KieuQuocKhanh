package com.casestudy.happy_paws.dto;

import com.casestudy.happy_paws.model.Account;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

public class EmployeeDTO {
    private Long employeeId;
    @Pattern(regexp = "^\\p{Lu}\\p{Ll}*(\\s\\p{Lu}\\p{Ll}*)*$", message = "Invalid Name")
    private String name;
    @Size(max = 10, message = "Phone number cannot over 10 number !!!")
    @Pattern(regexp = "^0[1-9][0-9]{8}$", message = "Invalid phone number")
    private String phone;
    @NotBlank(message = "Please input value!")
    @Email(message = "Invalid Email")
    private String email;
    @NotBlank(message = "Please insert value!")
    private String address;

    private Account account;

    private LocalDateTime dateCreate;

    private LocalDateTime dateUpdate;
    private boolean isDelete;

    public EmployeeDTO(Long employeeId, String name, String phone, String email, String address, Account account, LocalDateTime dateCreate, LocalDateTime dateUpdate, boolean isDelete) {
        this.employeeId = employeeId;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.account = account;
        this.dateCreate = dateCreate;
        this.dateUpdate = dateUpdate;
        this.isDelete = isDelete;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public EmployeeDTO() {
    }



    public EmployeeDTO(String name, String phone, String email, String address, Account account) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.account = account;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
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

    public LocalDateTime getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(LocalDateTime dateCreate) {
        this.dateCreate = dateCreate;
    }

    public LocalDateTime getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(LocalDateTime dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

}
