package com.exam05.rest_controller;

import com.exam05.dto.OrderDTO;
import com.exam05.model.Orders;
import com.exam05.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.ResultSetSupportingSqlParameter;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/admin/order")
public class OrdersRestController {
    @Autowired
    private IOrderService iOrderService;

    @GetMapping("")
    public ResponseEntity<List<Orders>> getOrderList() {
        List<Orders> ordersList = iOrderService.findAll();
        return new ResponseEntity<>(ordersList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Orders> getOrder(@PathVariable("id") Long id) {
        return new ResponseEntity<>(iOrderService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    public boolean saveOrder(@RequestBody @Validated OrderDTO orderDTO) {
//        iOrderService.saveOrder(orders);
        return true;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<List<Orders>> deleteOrders(@PathVariable("id") Long id) {
        iOrderService.deleteOrder(id);
        List<Orders> ordersList = iOrderService.findAll();
        return new ResponseEntity<>(ordersList, HttpStatus.OK);
    }

    @PutMapping("/update")
    public void updateOrder(@RequestBody Orders orders) {
        iOrderService.updateOrder(orders);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Orders>> searchOrder(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate,
                                                    @RequestParam("productName") String productName) {
        List<Orders> ordersList = iOrderService.searchOrder(startDate,endDate,productName);
        System.out.println(ordersList);
         return new ResponseEntity<>(ordersList, HttpStatus.OK);
    }
}
