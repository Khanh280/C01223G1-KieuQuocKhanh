package io_binary_file.product_manager.repository;

import io_binary_file.product_manager.models.Product;
import io_binary_file.product_manager.utils.ReadAndWriteDataBinaryFile;

import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements IProductRepository {
    List<Product> productList = new ArrayList<>();

    @Override
    public void add(List<Product> productList) {
        ReadAndWriteDataBinaryFile.writeProductToFile(productList, false);
    }

    @Override
    public List<Product> display() {
        productList = ReadAndWriteDataBinaryFile.readFileToList();
        return productList;
    }


    @Override
    public void search(String nameProduct) {
        productList = ReadAndWriteDataBinaryFile.readFileToList();
        int count = 0;
        for (int i = 0; i < productList.size(); i++) {
            if (nameProduct.equals(productList.get(i).getNameProduct())) {
                System.out.println(productList.get(i));
            } else {
                count++;
            }
        }
        if (count == productList.size()) {
            System.out.println("Sản phẩm không tồn tại.");
        }
    }
}
