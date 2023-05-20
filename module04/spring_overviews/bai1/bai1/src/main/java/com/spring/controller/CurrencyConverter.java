package com.spring.controller;

import com.spring.service.ICurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CurrencyConverter {
    @Autowired
    private ICurrencyService currencyService;
    @PostMapping("/currency")
    public String currency(Model model, @RequestParam("usd")Integer usd, @RequestParam("rate")Integer rate){
        int vnd = currencyService.currencyVnd(usd,rate);
        model.addAttribute("rate",rate);
        model.addAttribute("usd",usd);
        model.addAttribute("vnd",vnd);
        return "/currency";
    }

    @GetMapping("/")
    public String pageCurrency(){
        return "/currency";
    }
}
