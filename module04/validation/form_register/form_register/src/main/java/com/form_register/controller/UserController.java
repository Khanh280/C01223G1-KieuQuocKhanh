package com.form_register.controller;

import com.form_register.dto.UserDTO;
import com.form_register.model.User;
import com.form_register.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {
    @Autowired
    private IUserService iUserService;

    @GetMapping("/")
    public String register(Model model) {
        model.addAttribute("userDTO", new UserDTO());
        return "/register";
    }
    @GetMapping("/home")
    public String home(Model model){
        model.addAttribute("userList", iUserService.findAll());
        return "/home";
    }


    @PostMapping("/create")
    public String create(@Validated @ModelAttribute("userDTO") UserDTO userDTO, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            return "/register";
        }else{
            User user = new User();
            BeanUtils.copyProperties(userDTO, user);
            boolean statusRegister = iUserService.save(user);
            redirectAttributes.addFlashAttribute("statusRegister", statusRegister);
            return "redirect:/home";
        }
    }
}
