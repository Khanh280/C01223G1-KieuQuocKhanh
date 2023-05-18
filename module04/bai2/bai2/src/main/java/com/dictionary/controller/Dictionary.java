package com.dictionary.controller;

import com.dictionary.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Dictionary {
    @Autowired
    private IDictionaryService dictionaryService;
    @GetMapping("/")
    public String dictionary(){
        return "/dictionary";
    }

    @PostMapping("/dictionary")
    public String searchDictionary(Model model, @RequestParam("english")String english){
        String vietnamese = dictionaryService.searchDictionary(english);
        if (vietnamese == null){
            vietnamese = "Không tìm thấy " + english + " trong từ điển";
        }
        model.addAttribute("english",english);
        model.addAttribute("vietnamese",vietnamese);
        return "/dictionary";
    }
}
