package com.sandwich.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SandwichController {
    @GetMapping("/")
    public String home(){
        return "/home";
    }
    @GetMapping("/home")
    public String homeRult(){
        return "/home";
    }
    @PostMapping("/save")
    public String saveSpice(@RequestParam(value = "spice",defaultValue = "")String[] spice, RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("spice",spice);
        return "redirect:/home";
    }
}
