package io_binary_file.product_manager.controllers;

import io_binary_file.product_manager.service.ProductService;

import java.util.Scanner;

public class ProductManager {
    static ProductService productService = new ProductService();
    static Scanner scanner = new Scanner(System.in);

    public static void displayMenu() {
        boolean flag;
        do {
            flag = true;
            System.out.println("Product Manager" +
                    "\n1. Thêm sản phẩm." +
                    "\n2. Hiển thị sản phẩm." +
                    "\n3. Tìm sản phẩm." +
                    "\n4. Thoát.");
            String choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    productService.addProduct();
                    break;
                case "2":
                    productService.displayProductList();
                    break;
                case "3":
                    productService.searchProduct();
                    break;
                case "4":
                    flag = false;
                    break;
            }
        } while (flag);
    }
}
