package com.data_binding.repository;

import com.data_binding.model.EmailSettings;

import java.util.List;

public interface IEmailRepository {
    List<String> getLanguages();
    List<Integer> getPageSize();
    void saveSettings(EmailSettings email);
    EmailSettings getEmail();
}
