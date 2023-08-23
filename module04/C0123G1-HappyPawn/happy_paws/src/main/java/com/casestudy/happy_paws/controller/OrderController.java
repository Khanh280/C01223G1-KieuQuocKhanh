package com.casestudy.happy_paws.controller;

import com.casestudy.happy_paws.dto.OrderDTO;
import com.casestudy.happy_paws.model.Customer;
import com.casestudy.happy_paws.model.OrderDetail;
import com.casestudy.happy_paws.model.Orders;
import com.casestudy.happy_paws.model.Product;
import com.casestudy.happy_paws.service.IOrderDetailService;
import com.casestudy.happy_paws.service.IOrderService;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private IOrderService iOrderService;
    @Autowired
    private IOrderDetailService iOrderDetailService;

    @GetMapping("")
    public String showList(@RequestParam(value = "page", defaultValue = "0") Integer page, Model model) {
        Pageable pageable = PageRequest.of(page, 8, Sort.by("buyDate").descending());
        Page<Orders> ordersPage = iOrderService.findAll(pageable);
        List<OrderDTO> orderDTOList = new ArrayList<>();
        for (Orders o : ordersPage) {
            OrderDTO orderDTO = new OrderDTO(o.getId(), o.getCustomer(), o.getBuyDate(), iOrderDetailService.getTotalPriceOrder(o.getId()));
            orderDTOList.add(orderDTO);
        }
        Page<OrderDTO> orderDTOPage = new PageImpl<>(orderDTOList, pageable, ordersPage.getTotalElements());
        Double totalPriceOrderDetail = iOrderDetailService.findTotalPriceOrderDetail();
        model.addAttribute("totalPriceOrderDetail", totalPriceOrderDetail);
        model.addAttribute("orderDTOPage", orderDTOPage);
        model.addAttribute("pageList", true);
        return "orders/orders_list";
    }

    @GetMapping("/search")
    public String search(@RequestParam("name") String name, @RequestParam("phone") String phone, @RequestParam(value = "page", defaultValue = "0") Integer page, Model model) {
        Pageable pageable = PageRequest.of(page, 8);
        Page<Orders> ordersPage = iOrderService.searchByNameAndPhone(name, phone, pageable);
        List<OrderDTO> orderDTOList = new ArrayList<>();
        for (Orders o : ordersPage) {
            OrderDTO orderDTO = new OrderDTO(o.getId(), o.getCustomer(), o.getBuyDate(), iOrderDetailService.getTotalPriceOrder(o.getId()));
            orderDTOList.add(orderDTO);
        }
        Page<OrderDTO> orderDTOPage = new PageImpl<>(orderDTOList, pageable, ordersPage.getTotalElements());
        Double totalPriceOrderDetail = iOrderDetailService.findTotalPriceOrderDetail();
        if(orderDTOPage.getTotalElements() ==0){
            model.addAttribute("notFound", true);
        }
        model.addAttribute("totalPriceOrderDetail", totalPriceOrderDetail);
        model.addAttribute("orderDTOPage", orderDTOPage);
        model.addAttribute("name", name);
        model.addAttribute("phone", phone);
        model.addAttribute("pageSearch", true);
        return "orders/orders_list";
    }

    @GetMapping("/create")
    private String create(@RequestParam(value = "page", defaultValue = "0") Integer page, Model model) {
        Pageable pageable = PageRequest.of(page, 8);
        model.addAttribute("customerPage", iOrderService.findAllCustomer(pageable));
        model.addAttribute("customer", new Customer());
        model.addAttribute("pageList", true);
        return "orders/customer_list";
    }

    @GetMapping("/search-customer")
    public String searchCustomer(@RequestParam("name") String name, @RequestParam("phone") String phone,
                                 @RequestParam(value = "page", defaultValue = "0") Integer page, Model model) {
        Pageable pageable = PageRequest.of(page, 8);
        model.addAttribute("customerPage", iOrderService.searchCustomerByNameAndPhone(name, phone, pageable));
        if(iOrderService.searchCustomerByNameAndPhone(name, phone, pageable).getTotalElements() ==0){
            model.addAttribute("notFound", true);
        }
        model.addAttribute("name", name);
        model.addAttribute("phone", phone);
        model.addAttribute("pageSearch", true);
        return "orders/customer_list";
    }

    @GetMapping("/search-product")
    public String searchProduct(@RequestParam("customerId") Integer customerId, @RequestParam("chosePrice") Integer chosePrice,
                                @RequestParam("name") String name, @RequestParam(value = "page", defaultValue = "0") Integer page,
                                @RequestParam(value = "now",defaultValue = "noCart") String now,
                                Model model, HttpServletRequest httpServletRequest) {
        HttpSession session = httpServletRequest.getSession();
        Pageable pageable = PageRequest.of(page, 8);
        Page<Product> productPage = iOrderService.searchProductByNameAndPrice(name, chosePrice, pageable);
        List<OrderDetail> productList = new ArrayList<>();
        if (session.getAttribute("cart") != null) {
            productList = (List<OrderDetail>) session.getAttribute("cart");
        }
        if(productPage.getTotalElements() ==0){
            model.addAttribute("notFound", true);
        }
        session.setAttribute("cart", productList);
        model.addAttribute("session", session);
        model.addAttribute("now", now);
        model.addAttribute("customer", iOrderDetailService.findCustomerById(customerId));
        model.addAttribute("productPage", productPage);
        model.addAttribute("name", name);
        model.addAttribute("chosePrice", chosePrice);
        model.addAttribute("pageSearch", true);
        return "orders/product_list";
    }

    @GetMapping("/add-customer")
    public String addCustomerOrder() {
        return "orders/add_customer";
    }
}
