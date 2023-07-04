package com.exam05.rest_controller;

import com.exam05.model.Product;
import com.exam05.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/admin/product")
public class ProductRestController {
    @Autowired
    private IProductService iProductService;
    @GetMapping("")
    public ResponseEntity<List<Product>> getProductList(){
        List<Product> productList = iProductService.findAll();
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }
}
