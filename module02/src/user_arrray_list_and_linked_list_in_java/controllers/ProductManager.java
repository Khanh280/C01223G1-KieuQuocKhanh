package user_arrray_list_and_linked_list_in_java.controllers;

import user_arrray_list_and_linked_list_in_java.service.ProductService;

import java.util.Scanner;

public class ProductManager {
    static Scanner scanner = new Scanner(System.in);
    static ProductService productService = new ProductService();
    public static void displayMenu() {
        boolean flag;
        do {
            flag = true;
            try{
                System.out.println("------Công Ty TNHH MMT------" +
                        "\n1. Thêm sản phẩm." +
                        "\n2. Sửa thông tin sản phẩm." +
                        "\n3. Xoá sản phẩm." +
                        "\n4. Hiển thị danh sách sản phẩm." +
                        "\n5. Tìm kiếm sản phẩm." +
                        "\n6. Sắp xếp sản phẩm tăng dần, giảm dần theo giá." +
                        "\n7. Thoat.");
                int choose = Integer.parseInt(scanner.nextLine());
                switch (choose) {
                    case 1:
                        productService.addProduct();
                        break;
                    case 2:
                        productService.editProduct();
                        break;
                    case 3:
                        productService.deleteProduct();
                        break;
                    case 4:
                        System.out.println("----------DANH SÁCH SẢN PHẨM----------");
                        productService.displayProduct();
                        break;
                    case 5:
                        System.out.println("----------DANH SÁCH SẢN PHẨM----------");
                        productService.searchProductName();
                        break;
                    case 6:
                        productService.sortProduct();
                        break;
                    case 7:
                        flag = false;
                        break;
                }
            } catch (Exception e){
                System.out.println("Vui lòng chọn đúng chức năng.");
            }
        } while (flag);
    }
}
