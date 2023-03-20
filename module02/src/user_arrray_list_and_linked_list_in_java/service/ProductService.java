package user_arrray_list_and_linked_list_in_java.service;

import user_arrray_list_and_linked_list_in_java.models.Product;

import java.util.*;

public class ProductService extends Product implements IServiceProduct {

    static List<Product> products = new ArrayList<>();

    {
        products.add(new Product(1, "Iphone 13Pro Max 512 Gb", "23 củ", "Apple", 1));
        products.add(new Product(2, "Iphone 12Pro Max 512 Gb", "20 củ", "Apple", 1));
        products.add(new Product(3, "Iphone 11Pro Max 512 Gb", "15 củ", "Apple", 1));
    }

    static Product product = new Product();
    static Scanner scanner = new Scanner(System.in);
    int numberOfProducts;

    @Override
    public void addProduct() {
        try {
            System.out.print("Nhập Id sản phẩm: ");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.print("Nhập tên sản phẩm: ");
            String nameProduct = scanner.nextLine();
            System.out.print("Nhập giá sản phẩm: ");
            String price = scanner.nextLine();
            System.out.print("Nhà sản xuất: ");
            String manuFacturers = scanner.nextLine();
            numberOfProducts = 1;
            for (int i = 0; i < products.size(); i++) {
                if (id == products.get(i).getId() && nameProduct.equals(products.get(i).getNameProduct())) {
                    if (price.equals(products.get(i).getPrice()) && manuFacturers.equals(products.get(i).getManuFacturers())) {
                        numberOfProducts = products.get(i).getNumberOfProducts() + 1;
                        product = new Product(id, nameProduct, price, manuFacturers, numberOfProducts);
                        products.set(i, product);
                        return;
                    }
                } else if (id == products.get(i).getId()) {
                    System.out.println("Id sản phẩm đã tồn tại.");
                    return;
                }
            }
            product = new Product(id, nameProduct, price, manuFacturers, numberOfProducts);
            products.add(product);
        } catch (Exception e) {
            System.out.println("Thông tin không hợp lệ.");
        }
    }

    @Override
    public void editProduct() {
        try {
            int count = 0;
            System.out.print("Nhập Id sản phẩm: ");
            int id = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < products.size(); i++) {
                if (id == products.get(i).getId()) {
                    System.out.print("Nhập tên sản phẩm: ");
                    String nameProduct = scanner.nextLine();
                    System.out.print("Nhập giá sản phẩm: ");
                    String price = scanner.nextLine();
                    System.out.print("Nhà sản xuất: ");
                    String manuFacturers = scanner.nextLine();
                    System.out.println("Số lượng sản phẩm hiện tại");
                    numberOfProducts = Integer.parseInt(scanner.nextLine());
                    product = new Product(id, nameProduct, price, manuFacturers, numberOfProducts);
                    products.set(i, product);
                    return;
                } else {
                    count++;
                }
                if (count == products.size()) {
                    System.out.println("Sản phẩm có Id " + id + " không tồn tại.");
                }
            }
        } catch (Exception e) {
            System.out.println("Sản phẩm không tồn tại.");
        }
    }

    @Override
    public void deleteProduct() {
        try {
            int count = 0;
            System.out.print("Nhập Id sản phẩm muốn xóa: ");
            int id = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < products.size(); i++) {
                if (id == products.get(i).getId()) {
                    System.out.println("Nhập số lượng sản phẩm cần xóa: ");
                    int numberDelete = Integer.parseInt(scanner.nextLine());
                    confirmDelete(i, numberDelete);
                    return;
                } else {
                    count++;
                }
                if (count == products.size()) {
                    System.out.println("Id sản phẩm không tồn tại.");
                }
            }
        } catch (Exception e) {
            System.out.println("Id sản phẩm không tồn tại.");
        }
    }

    public void confirmDelete(int i, int numberDelete) {
        boolean flag;
        do {
            flag = true;
            System.out.println("Bạn xác nhận xóa " + products.get(i).getNameProduct() +
                    "\n1. Yes" +
                    "\n2. No");
            try {
                int choose = Integer.parseInt(scanner.nextLine());
                switch (choose) {
                    case 1:
                        if (products.get(i).getNumberOfProducts() == numberDelete || products.get(i).getNumberOfProducts() == 1) {
                            products.remove(i);
                            System.out.println("Bạn đã xóa thành công sản phẩm.");
                            return;
                        } else if (numberDelete < products.get(i).getNumberOfProducts()) {
                            products.get(i).setNumberOfProducts(products.get(i).getNumberOfProducts() - numberDelete);
                            System.out.println("Bạn đã xóa thành công" + numberDelete + "sản phẩm.");
                        }
                        if (products.get(i).getNumberOfProducts() == 0) {
                            products.remove(i);
                        }
                        break;
                    case 2:
                        System.out.println("Bạn đã không xóa sản phẩm.");
                        break;
                }
                flag = false;
            } catch (Exception e) {
                System.out.println("Vui loòng xác nhận.");
            }
        } while (flag);
    }

    @Override
    public void displayProduct() {
        for (int i = 0; i < products.size(); i++) {
            System.out.println(products.get(i));
        }
    }

    @Override
    public void searchProductName() {
        System.out.print("Nhập tên sản phẩm muốn tìm: ");
        String nameProduct = scanner.nextLine();
        int count = 0;
        for (int i = 0; i < products.size(); i++) {
            if (nameProduct.equals(products.get(i).getNameProduct())) {
                System.out.println(products.get(i));
                return;
            } else {
                count++;
            }
//            if (count == products.size()) {
//                System.out.println("Sản phẩm " + nameProduct + " hiện không tồn tại.");
//                return;
//            }
        }
        if (count == products.size()) {
            System.out.println("Không có sản phẩm nào trong cửa hàng.");
        }
    }

    @Override
    public void sortProduct() {
        try {
            System.out.println("1. Tăng dần.\n2. Giảm dần.");
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    System.out.println("----------DANH SÁCH SẢN PHẨM----------");
                    Collections.sort(products, new Product());
                    for (int i = 0; i < products.size(); i++) {
                        System.out.println(products.get(i));
                    }
                    break;
                case 2:
                    System.out.println("----------DANH SÁCH SẢN PHẨM----------");
                    Collections.reverse(products);
                    for (int i = 0; i < products.size(); i++) {
                        System.out.println(products.get(i));
                    }
                    break;
            }
        } catch (Exception e) {
            System.out.println("Hãy lựa chọn chức năng.");
        }
    }
}
