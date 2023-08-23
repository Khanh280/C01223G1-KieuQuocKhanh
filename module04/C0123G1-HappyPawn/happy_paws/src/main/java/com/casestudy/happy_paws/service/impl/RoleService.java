package com.casestudy.happy_paws.service.impl;

import com.casestudy.happy_paws.model.Role;
import com.casestudy.happy_paws.repository.IRoleRepository;
import com.casestudy.happy_paws.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService implements IRoleService {

    @Autowired
    private IRoleRepository roleRepository ;
    @Override
    public List<Role> findAll() {
        List<Role> roleList = roleRepository.findAll();
        return roleList;
    }

    @Override
    public void save(Role role) {
        roleRepository.save(role);
    }
}
