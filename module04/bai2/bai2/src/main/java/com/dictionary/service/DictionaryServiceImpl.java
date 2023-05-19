package com.dictionary.service;

import com.dictionary.repository.DictionaryRepositoryImpl;
import com.dictionary.repository.IDictionaryRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Service
public class DictionaryServiceImpl implements IDictionaryService{
    IDictionaryRepository dictionaryRepository = new DictionaryRepositoryImpl();
    @Override
    public String searchDictionary(String english) {
        Map<String,String> dictionaryList = dictionaryRepository.searchDictionary();
        Set<String> key = dictionaryList.keySet();
        for (String k: key) {
            if(english.toLowerCase().equals(k)){
                return dictionaryList.get(k);
            }
        }
        return null;
    }
}
