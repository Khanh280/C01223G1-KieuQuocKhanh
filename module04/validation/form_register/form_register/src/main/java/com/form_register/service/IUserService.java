package com.form_register.service;

import com.form_register.model.User;

import java.util.List;

public interface IUserService {
    boolean save(User user);
    List<User> findAll();
}
