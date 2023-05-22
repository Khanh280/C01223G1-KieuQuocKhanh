package com.data_binding.controller;

import com.data_binding.model.EmailSettings;
import com.data_binding.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EmailController {
    @Autowired
    private IEmailService emailService;
    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("emailSettings",emailService.getEmail());
        return "/index";
    }
    @GetMapping("/home")
    public String home(Model model){
        model.addAttribute("emailSettings",new EmailSettings());
        model.addAttribute("languages",emailService.getLanguages());
        model.addAttribute("pageSize",emailService.getPageSize());
        return "/home";
    }
    @PostMapping("/saveSettings")
    public String saveSetting(Model model,@ModelAttribute("emailSettings") EmailSettings emailSettings){
        emailService.saveSettings(emailSettings);
        List<String> languages = emailService.getLanguages();
        List<Integer> pageSize = emailService.getPageSize();
        model.addAttribute("languages",languages);
        model.addAttribute("pageSize",pageSize);
        model.addAttribute("emailSettings",emailService.getEmail());
        return "/index";
    }
    @GetMapping("/currentConfiguration")
    public String currentConfiguration(Model model){
        List<String> languages = emailService.getLanguages();
        List<Integer> pageSize = emailService.getPageSize();
        EmailSettings emailSettings = emailService.getEmail();
        model.addAttribute("emailSettings",emailSettings);
        model.addAttribute("languages",languages);
        model.addAttribute("pageSize",pageSize);
        return "/home";
    }
}
