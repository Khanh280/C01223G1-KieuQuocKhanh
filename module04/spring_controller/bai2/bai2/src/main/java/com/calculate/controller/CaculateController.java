package com.calculate.controller;

import com.calculate.service.ICaculateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CaculateController {
    @Autowired
    private ICaculateService caculateService;
    @GetMapping("/")
    public String home(){
        return "/home";
    }

    @PostMapping("/caculate")
    public String caculate(Model model, @RequestParam("firstValue")float firstValue,
                           @RequestParam("operator")String operator,
                           @RequestParam("secondValue")float secondValue){
        float result = caculateService.caculate(firstValue,secondValue,operator);
        model.addAttribute("firstValue",firstValue);
        model.addAttribute("secondValue",secondValue);
        model.addAttribute("result",result);
        return "/home";
    }
}
