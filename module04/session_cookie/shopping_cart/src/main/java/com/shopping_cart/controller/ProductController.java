package com.shopping_cart.controller;

import com.shopping_cart.model.Product;
import com.shopping_cart.service.ICartService;
import com.shopping_cart.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {

    @ModelAttribute("cart")
    public Map<Product,Integer> setUpCart() {
        return new LinkedHashMap<>();
    }

    @Autowired
    private IProductService iProductService;
    @Autowired
    private ICartService iCartService;

    @GetMapping("/")
    public String showShop(Model model) {
        model.addAttribute("products", iProductService.findAll());
        return "shop";
    }
    @GetMapping("/add/{id}")
    public String addProductToCart(@PathVariable("id") Long id, @ModelAttribute("cart") Map<Product,Integer> cart, @RequestParam("action") String action){
        Optional<Product> productOptional = iProductService.findById(id);
        if(!productOptional.isPresent()){
            return "error.404";
        }
        if(action.equals("show")){
            iCartService.addProductCart(productOptional.get(),cart);
            return "redirect:/shopping-cart";
        }
        iCartService.addProductCart(productOptional.get(),cart);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteToCart(@PathVariable("id") Long id, @ModelAttribute("cart") Map<Product,Integer> cart, @RequestParam("action") String action){
            Optional<Product> productOptional = iProductService.findById(id);
            if(!productOptional.isPresent()){
                return "error.404";
            }
            if(action.equals("show")){
                iCartService.deleteProductCart(productOptional.get(),cart);
                return "redirect:/shopping-cart";
            }
        iCartService.deleteProductCart(productOptional.get(),cart);
            return "cart";
    }
    @GetMapping("/detail/{id}")
    public  String detail(@PathVariable("id")Long id, Model model){
        Product product = iProductService.findById(id).get();
        model.addAttribute("product",product);
        return "detail";
    }
}