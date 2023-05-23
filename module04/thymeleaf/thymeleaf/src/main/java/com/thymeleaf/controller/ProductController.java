package com.thymeleaf.controller;

import com.thymeleaf.model.Product;
import com.thymeleaf.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private IProductService productService;
    @GetMapping("/")
    public String home(Model model){
        List<Product> productList = productService.getAll();
        model.addAttribute("productList",productList);
        return "/home";
    }
    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("product",new Product());
        return "/create";
    }
    @PostMapping("/create")
    public String save(@ModelAttribute("product") Product product){
        productService.create(product);
        return "redirect:/";
    }

    @GetMapping("/update/{codeProduct}")
    public String updateInfo(@PathVariable("codeProduct") String codeProduct, Model model){
        Product product = productService.getProductByCode(codeProduct) ;
        model.addAttribute("product",product);
        return "/update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("product") Product product){
        productService.update(product);
        return "redirect:/";
    }

    @GetMapping("/delete/{codeProduct}")
    public String delete(@PathVariable("codeProduct") String codeProduct){
        productService.delete(codeProduct);
        return "redirect:/";
    }

    @GetMapping("/detail/{codeProduct}")
    public String detail(@PathVariable("codeProduct") String codeProduct, RedirectAttributes redirectAttributes){
        Product product = productService.getProductByCode(codeProduct);
        redirectAttributes.addFlashAttribute("productDetail",product);
        return "redirect:/";
    }

    @GetMapping("/search")
    public String search(@RequestParam("name") String name,Model model){
        List<Product> productList = productService.search(name);
        model.addAttribute("name",name);
        model.addAttribute("productList",productList);
        return "/home";
    }
}
