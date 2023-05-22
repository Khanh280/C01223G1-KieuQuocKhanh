package com.data_binding.repository;

import com.data_binding.model.EmailSettings;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class EmailRepositoryImpl implements  IEmailRepository{
    private static List<String> languagesList = new ArrayList<>();
    static {
        languagesList.add("English");
        languagesList.add("Vietnamese");
        languagesList.add("Japanese");
        languagesList.add("Chinese");
    }
    private static List<Integer> pageSize = new ArrayList<>();
    static {
        pageSize.add(5);
        pageSize.add(10);
        pageSize.add(15);
        pageSize.add(25);
        pageSize.add(50);
        pageSize.add(100);
    }
    private static List<EmailSettings> emailList = new ArrayList<>();
    @Override
    public List<String> getLanguages() {
        return languagesList;
    }

    @Override
    public List<Integer> getPageSize() {
        return pageSize;
    }

    @Override
    public void saveSettings(EmailSettings email) {
        emailList.add(email);
    }

    @Override
    public EmailSettings getEmail() {
        if(emailList.size() >0){
            return emailList.get(emailList.size()-1);
        }
        return null;
    }
}
