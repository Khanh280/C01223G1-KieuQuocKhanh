package com.casestudy.happy_paws.controller;

import com.casestudy.happy_paws.model.*;
import com.casestudy.happy_paws.service.IAccountService;
import com.casestudy.happy_paws.service.ICartService;
import com.casestudy.happy_paws.service.ICustomerService;
import com.casestudy.happy_paws.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class CartController {
    @Autowired
    private ICartService iCartService;
    @Autowired
    private ICustomerService iCustomerService;
    @Autowired
    private IAccountService iAccountService;
    @Autowired
    private IProductService iProductService;

    @GetMapping("/cart")
    public String displayCart(@RequestParam(value = "customerId",defaultValue = "0") Integer customerId,@RequestParam(value = "userName",defaultValue = "0")String userName,Model model) {
        if(customerId==0){
            Customer customer = iCustomerService.findCustomerByUserName(userName);
            customerId = customer.getCustomerId();
        }
        List<Cart> list = iCartService.getAll(customerId);
        model.addAttribute("cartList", list);
        model.addAttribute("customerId", customerId);
        model.addAttribute("totalItem", iCartService.countItemQuantity(customerId));
        model.addAttribute("totalBill",iCartService.countTotalPayment(customerId));
        return "cart_view/cart";
    }

    @GetMapping("/delete-product")
    public String deleteProductInCart(@RequestParam("id") Long id,@RequestParam("userName") String userName) {
        iCartService.deleteCart(id);
        return "redirect:/cart?userName=" + userName;
    }
    @GetMapping("/add/{id}")
    public String addQuantityToCart(@PathVariable("id")Long cartId,@RequestParam("customerId") Integer customerId) {
        Cart cart1 = iCartService.findById(cartId);
        cart1.setQuantity(cart1.getQuantity()+1);
        iCartService.save(cart1);
        return "redirect:/cart?customerId=" + customerId;
    }
    @GetMapping("/add-cart")
    public String addCart(@RequestParam("productId") Long productId,@RequestParam("userName") String userName,@RequestParam(value = "quantity",defaultValue = "1") Integer quantity, RedirectAttributes redirectAttributes){
       if(quantity<=0){
           redirectAttributes.addFlashAttribute("statusQuantity",true);
           return "redirect:/detail/" + productId;
       }
        Customer customer = iCustomerService.findCustomerByUserName(userName);
        Cart cart = new Cart(iProductService.findById(productId),customer,quantity);
        iCartService.save(cart);
        return "redirect:/cart?customerId=" + customer.getCustomerId() ;
    }
    @GetMapping("/reduce/{id}")
    public String reduceProductInCart(@PathVariable("id") Long cartID,@RequestParam("customerId") Integer customerId){
        Cart cart = iCartService.findById(cartID);
        cart.setQuantity(cart.getQuantity()-1);
        int newQuantity = cart.getQuantity();
        iCartService.save(cart);
        if(newQuantity ==0){
            iCartService.deleteCart(cartID);
        }
        return "redirect:/cart?customerId=" + customerId;
    }
}

