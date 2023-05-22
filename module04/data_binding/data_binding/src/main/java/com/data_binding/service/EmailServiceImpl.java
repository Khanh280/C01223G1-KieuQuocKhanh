package com.data_binding.service;

import com.data_binding.model.EmailSettings;
import com.data_binding.repository.IEmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmailServiceImpl implements  IEmailService{
    @Autowired
    private IEmailRepository emailRepository;
    @Override
    public List<String> getLanguages() {
        return emailRepository.getLanguages();
    }

    @Override
    public List<Integer> getPageSize() {
        return emailRepository.getPageSize();
    }

    @Override
    public void saveSettings(EmailSettings email) {
        emailRepository.saveSettings(email);
    }

    @Override
    public EmailSettings getEmail() {
        return emailRepository.getEmail();
    }
}
