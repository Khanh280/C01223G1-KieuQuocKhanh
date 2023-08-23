package com.casestudy.happy_paws.controller;

import com.casestudy.happy_paws.dto.OrderDetailDAO;
import com.casestudy.happy_paws.model.*;
import com.casestudy.happy_paws.repository.ICartRepo;
import com.casestudy.happy_paws.service.ICartService;
import com.casestudy.happy_paws.service.IOrderDetailService;
import com.casestudy.happy_paws.service.IOrderService;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/order-detail")
public class OrderDetailController {
    @Autowired
    private IOrderDetailService iOrderDetailService;
    @Autowired
    private IOrderService iOrderService;
    @Autowired
    private ICartService iCartService;

    @GetMapping("")
    public String showOrderDetail(@RequestParam("orderId") Long orderId, @RequestParam(value = "page", defaultValue = "0") Integer page,
                                  Model model, HttpServletRequest httpServletRequest) {
        HttpSession session = httpServletRequest.getSession();
        if(session.getAttribute("cart") != null){
            session.removeAttribute("cart");
        }
        Pageable pageable = PageRequest.of(page, 8);
        Page<OrderDetail> orderDetailPage = iOrderDetailService.findAllOrderDetailByOrderId(pageable, orderId);
        Double totalPrice = iOrderDetailService.getTotalPriceOrder(orderId);
        model.addAttribute("orderDetailPage", orderDetailPage);
        model.addAttribute("totalPrice", totalPrice);
        model.addAttribute("orderId", orderId);
        model.addAttribute("pageList", true);
        return "orders/order_detail";
    }

    @GetMapping("/create")
    public String create(@RequestParam("customerId") Integer customerId, @RequestParam(value = "orderId", defaultValue = "0") Long orderId, @RequestParam(value = "now", defaultValue = "noCart") String now, @RequestParam(value = "page", defaultValue = "0") Integer page,
                         Model model, HttpServletRequest httpServletRequest) {
        HttpSession session = httpServletRequest.getSession();
        Pageable pageable = PageRequest.of(page, 8);
        Customer customer = iOrderDetailService.findCustomerById(customerId);
        List<OrderDetail> cart = new ArrayList<>();
        if (now.equals("cart")) {
            if (session.getAttribute("cart") != null) {
                cart = (List<OrderDetail>) session.getAttribute("cart");
            }
            double totalPriceCart = 0.0;
            for (OrderDetail c : cart) {
                totalPriceCart += c.getProducts().getPrice() * c.getQuantity();
            }
            model.addAttribute("totalPriceCart", totalPriceCart);
            model.addAttribute("now", "cart");
        }else{
            model.addAttribute("now", "noCart");
            session.setAttribute("cart", cart);
        }
        model.addAttribute("session", session);
        model.addAttribute("customer", customer);
        model.addAttribute("pageList", true);
        model.addAttribute("productPage", iOrderDetailService.findAllProduct(pageable));
        return "orders/product_list";
    }

    @PostMapping("/add-product")
    public String addCart(@RequestParam("productId") Long productId, @RequestParam("customerId") Integer customerId,
                          @RequestParam(value = "orderId", defaultValue = "0") Long orderId, @RequestParam("quantity") Integer quantity,
                          Model model, HttpServletRequest httpServletRequest, RedirectAttributes redirectAttributes) {
        HttpSession session = httpServletRequest.getSession();
        Customer customer = iOrderDetailService.findCustomerById(customerId);
        Orders orders;
        if (orderId == 0) {
            orders = new Orders(customer);
        } else {
            orders = new Orders(orderId, customer);
        }
        List<OrderDetail> cart = (List<OrderDetail>) session.getAttribute("cart");
        Product product = iOrderDetailService.findProductById(productId);
        OrderDetail orderDetail = new OrderDetail(product, orders, quantity, product.getPrice());
        int count = 0;
        for (OrderDetail c : cart) {
            if (orderDetail.getProducts().getId().equals(c.getProducts().getId())) {
                c.setQuantity(orderDetail.getQuantity() + c.getQuantity());
                break;
            } else {
                count++;
            }
        }
        if (count == cart.size()) {
            cart.add(orderDetail);
        }
        session.setAttribute("cart", cart);
        redirectAttributes.addFlashAttribute("statusAddCart",true);
        return "redirect:/order-detail/create?customerId=" + customer.getCustomerId() + "&now=cart";
    }



    @GetMapping("/payment/{customerId}")
    @Transactional(rollbackFor = Throwable.class)
    public String payment(@PathVariable("customerId") Integer customerId, HttpServletRequest httpServletRequest, RedirectAttributes redirectAttributes) {
        HttpSession session = httpServletRequest.getSession();
        List<OrderDetail> cart = (List<OrderDetail>) session.getAttribute("cart");
        Customer customer = iOrderDetailService.findCustomerById(customerId);
        Orders orders = new Orders(customer);
        boolean statusSave = iOrderService.saveOrder(orders);
        boolean statusSaveOrderDetail = iOrderDetailService.saveOrderDetail(cart, orders);
        session.invalidate();
        redirectAttributes.addFlashAttribute("statusSaveOrderDetail", statusSaveOrderDetail);
        return "redirect:/orders/";
    }

    @GetMapping("/search")
    public String search(@RequestParam("orderId") Long orderId, @RequestParam("name") String name, @RequestParam(value = "page", defaultValue = "0") Integer page, Model model) {
        Pageable pageable = PageRequest.of(page, 8);
        model.addAttribute("orderDetailPage", iOrderDetailService.searchProductOrderDetail(name, orderId, pageable));
        if(iOrderDetailService.searchProductOrderDetail(name, orderId, pageable).getTotalElements() ==0){
            model.addAttribute("notFound", true);
        }
        Double totalPrice = iOrderDetailService.getTotalPriceOrder(orderId);
        model.addAttribute("totalPrice", totalPrice);
        model.addAttribute("name", name);
        model.addAttribute("orderId", orderId);
        model.addAttribute("pageSearch", true);
        return "orders/order_detail";
    }

    @PostMapping("/delete")
    public String updateInfo(@RequestParam("orderId") Long orderId, @RequestParam("orderDetailId") Long orderDetailId, RedirectAttributes redirectAttributes) {
        boolean statusDelete = iOrderDetailService.delete(orderDetailId);
        redirectAttributes.addFlashAttribute("statusDelete", statusDelete);
        return "redirect:/order-detail?orderId=" + orderId;
    }

    @GetMapping("/delete-cart")
    public String deleteCart(@RequestParam("index") Integer index, HttpServletRequest httpServletRequest) {
        HttpSession session = httpServletRequest.getSession();
        List<OrderDetail> cart = (List<OrderDetail>) session.getAttribute("cart");
        Integer customerId = cart.get(0).getOrder().getCustomer().getCustomerId();
        for (int i = 0; i < cart.size(); i++) {
            if (index == i) {
                cart.remove(i);
                break;
            }
        }
        return "redirect:/order-detail/create?customerId=" + customerId + "&now=cart";
    }

    @GetMapping("/edit-quantity-cart")
    public ResponseEntity<Integer> editQuantityCart(@RequestParam("index") Integer index,@RequestParam("action") String action, Model model,HttpServletRequest httpServletRequest){
        HttpSession session = httpServletRequest.getSession();
        List<OrderDetail> cart = (List<OrderDetail>) session.getAttribute("cart");
        Integer customerId = cart.get(0).getOrder().getCustomer().getCustomerId();
        Integer quantity = 0;
        for (int i = 0; i < cart.size(); i++) {
            if (index == i) {
               if(action.equals("delete")){
                   cart.get(i).setQuantity(cart.get(i).getQuantity()-1);
               }else{
                   cart.get(i).setQuantity(cart.get(i).getQuantity()+1);
               }
                quantity = cart.get(i).getQuantity();
                if(quantity == 0){
                    cart.remove(i);
                }
                break;
            }
        }
//        return "redirect:/order-detail/create?customerId=" + customerId + "&now=cart";
        return new ResponseEntity<>(quantity, HttpStatus.OK) ;
    }

    @GetMapping("/payment-cart/{customerId}")
    @Transactional(rollbackFor = Throwable.class)
    public String paymentCart(@PathVariable("customerId") Integer customerId,RedirectAttributes redirectAttributes) {
        List<Cart> cartList = iOrderDetailService.findAllCart(customerId);
        if(cartList.size()>0){
            List<OrderDetail> orderDetailList = new ArrayList<>();
            Orders orders = new Orders(iOrderDetailService.findCustomerById(customerId));
            boolean statusSave = iOrderService.saveOrder(orders);
            for (Cart c: cartList){
                OrderDetail orderDetail = new OrderDetail(c.getProduct(),orders,c.getQuantity(),c.getQuantity()*c.getProduct().getPrice());
                orderDetailList.add(orderDetail);
            }
            boolean statusSaveOrderDetail = iOrderDetailService.saveOrderDetail(orderDetailList, orders);
            if(statusSaveOrderDetail){
                boolean statusPayment =  iCartService.payMentCart(customerId);
                redirectAttributes.addFlashAttribute("statusPayment",statusPayment);
            }
        }
        return "redirect:/cart?customerId=" + customerId ;
    }
}
