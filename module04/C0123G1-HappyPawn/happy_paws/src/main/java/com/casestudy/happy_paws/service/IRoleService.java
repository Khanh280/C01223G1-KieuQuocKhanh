package com.casestudy.happy_paws.service;

import com.casestudy.happy_paws.model.Role;

import java.util.List;

public interface IRoleService {
    List<Role> findAll();

    void save(Role role);
}
