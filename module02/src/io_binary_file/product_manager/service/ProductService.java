package io_binary_file.product_manager.service;

import io_binary_file.product_manager.models.Product;
import io_binary_file.product_manager.repository.ProductRepositoryImpl;
import io_binary_file.product_manager.utils.ReadAndWriteDataBinaryFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductService extends Product implements IProductService {
    static List<Product> productList = new ArrayList<>();

    static ProductRepositoryImpl productRepository = new ProductRepositoryImpl();
    static Product product = new Product();
    static Scanner scanner = new Scanner(System.in);

    @Override
    public void addProduct() {
        productList = ReadAndWriteDataBinaryFile.readFileToList();
        System.out.print("Nhập mã sản phẩm: ");
        int horseProduct = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập tên sản phẩm: ");
        String nameProduct = scanner.nextLine();
        System.out.print("Nhập tên sản phẩm: ");
        String price = scanner.nextLine();
        System.out.print("Nhà sản xuất: ");
        String manufacturers = scanner.nextLine();
        System.out.print("Mô tả sản phẩm: ");
        String describe = scanner.nextLine();
        product = new Product(horseProduct, nameProduct, price, manufacturers, describe);
        productList.add(product);
        productRepository.add(productList);
    }

    @Override
    public void displayProductList() {
        productList = productRepository.display();
        for (int i = 0; i < productList.size(); i++) {
            System.out.println(productList.get(i));
        }
    }

    @Override
    public void searchProduct() {
        System.out.print("Nhập tên sản phẩm cần tìm: ");
        String nameProduct = scanner.nextLine();
        productRepository.search(nameProduct);
    }
}
