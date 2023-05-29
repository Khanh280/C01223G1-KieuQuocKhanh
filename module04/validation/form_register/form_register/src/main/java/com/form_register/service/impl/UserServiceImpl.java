package com.form_register.service.impl;

import com.form_register.model.User;
import com.form_register.repository.IUserRepository;
import com.form_register.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserRepository iUserRepository;
    @Override
    public boolean save(User user) {
        try{
            iUserRepository.save(user);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public List<User> findAll() {
        return iUserRepository.findAll();
    }
}
