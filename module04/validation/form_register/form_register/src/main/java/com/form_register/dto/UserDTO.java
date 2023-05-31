package com.form_register.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;

public class UserDTO  {
    private Long id;
    @NotEmpty(message = "Not Empty")
    @Size(min = 5, max = 45, message = "Names at least 5 in length, up to 45 characters")
    private String firstName;
    @NotEmpty(message = "Not Empty")
    @Size(min = 5, max = 45, message = "Names at least 5 in length, up to 45 characters")
    private String lastName;
    @NotEmpty(message = "Not Empty")
    @Pattern(regexp = "^0[0-9]{9,10}$",message = "Phone numbers start at 0 and have 10 – 11 numbers")
    private String phoneNumber;
    @Min(value = 18, message = "Age must be from 18")
    @NotNull(message = "Not Empty")
    private Integer age;
    @NotEmpty(message = "Email can't be blank")
    @Email(message = "Improperly formatted email . VD: khanhkieu123@gmail.com")
    private String email;

    public UserDTO() {
    }

    public UserDTO(Long id, String firstName, String lastName, String phoneNumber, Integer age, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

