package com.shopping_cart.service.impl;

import com.shopping_cart.model.Product;
import com.shopping_cart.service.ICartService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Map;
@Service
public class CartServiceImpl implements ICartService {
    @Override
    public void addProductCart(Product product, Map<Product, Integer> cart) {
            if (!checkItemInCart(product,cart)) {
                cart.put(product, 1);
            } else {
                Map.Entry<Product, Integer> newProduct = selectItemInCart(product,cart);
                Integer newQuantity = newProduct.getValue() + 1;
                cart.replace(newProduct.getKey(), newQuantity);
            }
    }

    @Override
    public boolean checkItemInCart(Product product, Map<Product, Integer> cart) {
            for (Map.Entry<Product, Integer> entry : cart.entrySet()) {
                if (entry.getKey().getId().equals(product.getId())) {
                    return true;
                }
            }
            return false;
    }

    @Override
    public Map.Entry<Product, Integer> selectItemInCart(Product product, Map<Product, Integer> cart) {
            for (Map.Entry<Product, Integer> entry : cart.entrySet()) {
                if (entry.getKey().getId().equals(product.getId())) {
                    return entry;
                }
            }
            return null;
    }

    @Override
    public void deleteProductCart(Product product, Map<Product, Integer> cart) {
        Map.Entry<Product, Integer> productEntry = selectItemInCart(product,cart);
        if (productEntry.getValue() > 0) {
            Integer quantity = productEntry.getValue() - 1;
            cart.replace(productEntry.getKey(), quantity);
            if (quantity == 0) {
                cart.remove(productEntry.getKey());
            }
        }
    }

    @Override
    public Double totalPriceProductCart(Map<Product, Integer> cart) {
        double total = 0D;
        for (Map.Entry<Product, Integer> entry : cart.entrySet()) {
            total += entry.getKey().getPrice() * (double) entry.getValue();
        }
        return total;
    }

    @Override
    public Integer countItemsInCart(Map<Product, Integer> cart) {
        int quantiry = 0;
        for (Map.Entry<Product,Integer> entry : cart.entrySet()){
            quantiry += entry.getValue();
        }
        return quantiry;
    }

    @Override
    public Integer countProductInCart(Map<Product, Integer> cart) {
        return cart.size();
    }

    @Override
    public void deleteItemInCart(Long id,Map<Product,Integer> cart) {
        for (Map.Entry<Product,Integer> entry : cart.entrySet()){
            if(entry.getKey().getId().equals(id)){
                cart.remove(entry.getKey());
                return;
            }
        }
    }
}
