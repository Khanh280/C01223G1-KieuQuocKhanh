package controller;

import models.model.Products;
import models.service.IAdminService;
import models.service.IProductService;
import models.service.impl.ProductServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProductsServlet", value = "/products-servlet")
public class ProductsServlet extends HttpServlet {
    IProductService productService = new ProductServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        List<Products> productsList;
        List<Products> limitList;
        List<Products> newProductList;
        int productId;
        String productName;
        String productType;
        String describe;
        double price;
        if (action == null) {
            action="";
        }
        switch (action) {
            case "update":
                productId = Integer.parseInt(request.getParameter("productId"));
                productsList = productService.getAll();
                for (int i = 0; i < productsList.size(); i++) {
                    if (productId == productsList.get(i).getProductId()) {
                        request.setAttribute("productId", productsList.get(i).getProductId());
                        request.setAttribute("productName", productsList.get(i).getProductName());
                        request.setAttribute("productType", productsList.get(i).getProductType());
                        request.setAttribute("describe", productsList.get(i).getDescribe());
                        request.setAttribute("price", productsList.get(i).getPrice());
                        request.setAttribute("imageUrl", productsList.get(i).getImageUrl());
                        request.getRequestDispatcher("/products/update_product.jsp").forward(request, response);
                        break;
                    }
                }
                break;
            case "displayPageAdmin":
                int pageAdmin = Integer.parseInt(request.getParameter("page"));
                productsList = productService.getAll();
                for (int i = 1; i <= Math.ceil((double) productsList.size() / 10); i++) {
                    if (pageAdmin == i) {
                        displayPageAdmin(request, response, productsList, pageAdmin);
                    }
                }
                break;
            case "displayPageUser":
                int pageUser = Integer.parseInt(request.getParameter("page"));
                productsList = productService.getAll();
                for (int i = 1; i <= Math.ceil((double) productsList.size() / 12); i++) {
                    if (pageUser == i) {
                        displayPageUser(request, response, productsList, pageUser);
                        break;
                    }
                }
                break;
            case "displayUser":
                productsList = productService.getAll();
                limitList = productsList.subList(0, Math.min(10, productsList.size()));
                request.setAttribute("productList", limitList);
                request.setAttribute("productListSize", productsList.size());
                request.getRequestDispatcher("/users/user.jsp").forward(request, response);
                break;
            case "searchAdmin":
                productName = request.getParameter("productName");
                productsList = productService.getAll();
                newProductList = new ArrayList<>();
                if (!productName.equals("")) {
                    for (int i = 0; i < productsList.size(); i++) {
                        if (productName.equals(productsList.get(i).getProductName())) {
                            newProductList.add(productsList.get(i));
                        }
                    }
                    request.setAttribute("productList", newProductList);
                } else {
                    limitList = productsList.subList(0, Math.min(10, productsList.size()));
                    request.setAttribute("productList", limitList);
                    request.setAttribute("productListSize", productsList.size());
                }
                request.getRequestDispatcher("/admin/admin.jsp").forward(request, response);
                break;
            case "searchUser":
                productName = request.getParameter("productName");
                productsList = productService.getAll();
                newProductList = new ArrayList<>();
                if (!productName.equals("")) {
                    for (int i = 0; i < productsList.size(); i++) {
                        if (productName.equals(productsList.get(i).getProductName())) {
                            newProductList.add(productsList.get(i));
                        }
                    }
                    request.setAttribute("productList", newProductList);
                } else {
                    limitList = productsList.subList(0, Math.min(12, productsList.size()));
                    request.setAttribute("productList", limitList);
                    request.setAttribute("productListSize", productsList.size());
                }
                request.getRequestDispatcher("/users/user.jsp").forward(request, response);
                break;
            case "detail":
                productId = Integer.parseInt(request.getParameter("productId"));
                productsList = productService.getAll();
                for (int i = 0; i < productsList.size(); i++) {
                    if(productId == productsList.get(i).getProductId()){
                        request.setAttribute("product",productsList.get(i));
                        break;
                    }
                }
                request.getRequestDispatcher("/products/product_detail.jsp").forward(request,response);
                break;
            default:
                productsList = productService.getAll();
                limitList = productsList.subList(0, Math.min(10, productsList.size()));
                request.setAttribute("productList", limitList);
                request.setAttribute("productListSize", productsList.size());
                request.getRequestDispatcher("/admin/admin.jsp").forward(request, response);
        }
    }


    private static void displayPageAdmin(HttpServletRequest request, HttpServletResponse response, List<Products> productsList, int page) throws ServletException, IOException {
        int max = page * 10;
        int start = max - 10;
        int end = Math.min(max, productsList.size());
        List<Products> limitList = productsList.subList(start, end);
        request.setAttribute("productList", limitList);
        request.setAttribute("productListSize", productsList.size());
        request.getRequestDispatcher("/admin/admin.jsp").forward(request, response);
    }

    private static void displayPageUser(HttpServletRequest request, HttpServletResponse response, List<Products> productsList, int page) throws ServletException, IOException {
        int max = page * 12;
        int start = max - 12;
        int end = Math.min(max, productsList.size());
        List<Products> limitList = productsList.subList(start, end);
        request.setAttribute("productList", limitList);
        request.setAttribute("productListSize", productsList.size());
        request.getRequestDispatcher("/users/user.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        int productId;
        String productName;
        int productType;
        String describe;
        double price;
        String imageUrl;
        switch (action) {
            case "create":
                boolean checkSuccess = productService.addProduct(request, response);
                request.setAttribute("checkSuccess", checkSuccess);
                request.getRequestDispatcher("/products/create_product.jsp").forward(request,response);
                break;
            case "update":
                productId = Integer.parseInt(request.getParameter("productId"));
                productName = request.getParameter("productName");
                productType = Integer.parseInt(request.getParameter("productType"));
                describe = request.getParameter("describe");
                price = Double.parseDouble(request.getParameter("price"));
                imageUrl = request.getParameter("imageUrl");
                Products products = new Products(productId, productName, productType, describe, price, imageUrl);
                productService.update(products);
                response.sendRedirect("/products-servlet");
                break;
            case "delete":
                productId = Integer.parseInt(request.getParameter("productId"));
                productService.delete(productId);
                List<Products> productsList = productService.getAll();
                List<Products> limitList = productsList.subList(0, Math.min(10, productsList.size()));
                request.setAttribute("productList", limitList);
                request.setAttribute("productListSize", productsList.size());
                request.getRequestDispatcher("/admin/admin.jsp").forward(request, response);
                break;
        }
    }
}
