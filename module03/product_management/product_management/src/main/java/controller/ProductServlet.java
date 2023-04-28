package controller;

import models.model.Product;
import models.service.IProductService;
import models.service.impl.ProductServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/product-servlet")
public class ProductServlet extends HttpServlet {
    IProductService iProductService = new ProductServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        IProductService iProductService = new ProductServiceImpl();
        List<Product> productList = iProductService.getAll();
        switch (action) {
            case "display":
                request.setAttribute("productList", productList);
                request.getRequestDispatcher("/list_product.jsp").forward(request,response);
                break;
            case "update":
                int id = Integer.parseInt(request.getParameter("id"));
                for (int i = 0; i < productList.size(); i++) {
                    if (id == productList.get(i).getId()) {
                        request.setAttribute("id", productList.get(i).getId());
                        request.setAttribute("productName", productList.get(i).getProductName());
                        request.setAttribute("price", productList.get(i).getPrice());
                        request.setAttribute("productDetail", productList.get(i).getProductDetail());
                        request.getRequestDispatcher("/update.jsp").forward(request,response);
                        break;
                    }
                }
                break;
            case "delete":
                int idDelete = Integer.parseInt(request.getParameter("id"));
                iProductService.deleteProduct(idDelete);
                request.setAttribute("productList", productList);
                request.getRequestDispatcher("/list_product.jsp").forward(request,response);
                break;
            case "search":
                String productName = request.getParameter("productName");
                for (int i = 0; i < productList.size(); i++) {
                    if(productName.equals(productList.get(i).getProductName())){
                        request.setAttribute("productList",productList.get(i));
                        request.getRequestDispatcher("/list_product.jsp").forward(request,response);
                        break;
                    }
                }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        Product product;
        int id;
        String productName;
        float price;
        String productDetail;
        switch (action) {
            case "create":
                id = Integer.parseInt(request.getParameter("id"));
                productName = request.getParameter("productName");
                price = Float.parseFloat(request.getParameter("price"));
                productDetail = request.getParameter("productDetail");
                product = new Product(id, productName, price, productDetail);
                iProductService.saveProduct(product);
                response.sendRedirect("/product-servlet?action=display");
                break;
            case "update":
                id = Integer.parseInt(request.getParameter("id"));
                productName = request.getParameter("productName");
                price = Float.parseFloat(request.getParameter("price"));
                productDetail = request.getParameter("productDetail");
                product = new Product(id, productName, price, productDetail);
                iProductService.upDateProduct(product);
                response.sendRedirect("/product-servlet?action=display");
        }

    }
}
