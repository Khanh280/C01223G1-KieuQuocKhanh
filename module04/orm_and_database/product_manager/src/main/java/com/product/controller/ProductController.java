package com.product.controller;

import com.product.model.Product;
import com.product.service.IProductService;
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

    @GetMapping("/update/{id}")
    public String updateInfo(@PathVariable("id") Integer id, Model model){
        Product product = productService.getProductByCode(id) ;
        model.addAttribute("product",product);
        return "/update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("product") Product product){
        productService.update(product);
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Integer id){
        productService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes){
        Product product = productService.getProductByCode(id);
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
