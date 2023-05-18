package com.dictionary.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DictionaryRepositoryImpl implements IDictionaryRepository{
    static Map<String,String> dictionaryList = new HashMap<>();
    static {
        dictionaryList.put("hello","Xin Chào");
        dictionaryList.put("hi","Xin Chào");
        dictionaryList.put("tree","Cây");
        dictionaryList.put("table","bảng");
        dictionaryList.put("apple","Quả táo");
        dictionaryList.put("banana","Quả chuối");
        dictionaryList.put("water","Nước");
        dictionaryList.put("pen","Cây bút");
        dictionaryList.put("coffe","Cà phê");
        dictionaryList.put("key","Khóa");
    }
    @Override
    public String searchDictionary(String english) {
        Set<String> key = dictionaryList.keySet();
        for (String k: key) {
            if(english.toLowerCase().equals(k)){
                return dictionaryList.get(k);
            }
        }
        return null;
    }
}
