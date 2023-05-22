package com.data_binding.service;

import com.data_binding.model.EmailSettings;

import java.util.List;

public interface IEmailService {
    List<String> getLanguages();
    List<Integer> getPageSize();
    void saveSettings(EmailSettings email);
    EmailSettings getEmail();
}
