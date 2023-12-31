package com.shopping_cart.controller;


import com.shopping_cart.model.Product;
import com.shopping_cart.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.HashMap;
import java.util.Map;

@Controller
@SessionAttributes("cart")
public class ShoppingCartController {
    @Autowired
    private ICartService iCartService;

    @ModelAttribute("cart")
    public Map<Product, Integer> setUpCart() {
        return new HashMap<>();
    }

    @GetMapping("/shopping-cart")
    public String showCart(@SessionAttribute("cart") Map<Product, Integer> cart, Model model) {
        model.addAttribute("totalProductInCart", iCartService.totalPriceProductCart(cart));
        model.addAttribute("countItemsInCart", iCartService.countItemsInCart(cart));
        model.addAttribute("countProductInCart", iCartService.countProductInCart(cart));
        model.addAttribute("cart", cart);
        return "cart";
    }

    @GetMapping("/deleteItem/{id}")
    public String deleteItemInCart(@PathVariable("id") Long id,@SessionAttribute("cart") Map<Product,Integer> cart) {
        iCartService.deleteItemInCart(id,cart);
        return "redirect:/shopping-cart";
    }

    @GetMapping("/pay")
    public String pay(@SessionAttribute("cart") Map<Product, Integer> cart) {
        cart.clear();
        return "cart";
    }
}