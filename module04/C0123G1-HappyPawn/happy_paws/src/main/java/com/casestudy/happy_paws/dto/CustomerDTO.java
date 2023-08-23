package com.casestudy.happy_paws.dto;


import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


public class CustomerDTO implements Validator {


    private Integer customerId;


    @Size(max = 100, message = "Name cannot be longer than 100 characters")
    @Pattern(regexp = "^\\p{Lu}\\p{Ll}*(\\s\\p{Lu}\\p{Ll}*)*$", message = "Malformed  name")
    @NotBlank(message = "Please insert value")

    private String name;

    @Size(max = 11, message = "Phone number cannot 11 number !!!")
    @Pattern(regexp = "^((\\+84)|0)[0-9]{9}$", message = "Invalid phone number")
    @NotBlank(message = "Please insert value")


    private String phone;
    @Email(message = "Email is incorrect . Please type abc@gmail.com ")
    @NotBlank(message = "Please insert value")

    private String email;

    @Size(max = 100, message = "Address cannot longer than 100 character !!")
    @NotBlank(message = "Please insert value")

    private String address;
    @Valid
    private AccountDTO accountDTO;


    private boolean isDelete ;

    public CustomerDTO()  {
    }

    public CustomerDTO(Integer customerId, String name, String phone, String email, String address, AccountDTO accountDTO, boolean isDelete) {
        this.customerId = customerId;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.accountDTO = accountDTO;

        this.isDelete = isDelete;
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

    public AccountDTO getAccountDTO() {
        return accountDTO;
    }

    public void setAccountDTO(AccountDTO accountDTO) {
        this.accountDTO = accountDTO;
    }



    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
