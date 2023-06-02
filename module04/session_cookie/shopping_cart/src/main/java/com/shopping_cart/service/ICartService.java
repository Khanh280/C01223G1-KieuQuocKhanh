package com.shopping_cart.service;

import com.shopping_cart.model.Product;

import java.util.Map;

public interface ICartService {
    void addProductCart(Product product, Map<Product, Integer> cart);

    boolean checkItemInCart(Product product, Map<Product, Integer> cart);

    Map.Entry<Product, Integer> selectItemInCart(Product product, Map<Product, Integer> cart);

    void deleteProductCart(Product product, Map<Product, Integer> cart);

    Double totalPriceProductCart(Map<Product, Integer> cart);

    Integer countItemsInCart(Map<Product, Integer> cart);

    Integer countProductInCart(Map<Product, Integer> cart);
    void deleteItemInCart(Long id, Map<Product,Integer> cart);
}
