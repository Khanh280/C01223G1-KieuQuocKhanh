package controller;

import models.model.*;
import models.service.ICustomerService;
import models.service.IOrderDetailSevice;
import models.service.IOrderService;
import models.service.IProductService;
import models.service.impl.CustomerServiceImpl;
import models.service.impl.OrderDetailServiceImpl;
import models.service.impl.OrderServiceImpl;
import models.service.impl.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "OrderServlet", value = "/order-servlet")
public class OrderServlet extends HttpServlet {
    IOrderService orderService = new OrderServiceImpl();
    ICustomerService customerService = new CustomerServiceImpl();
    IProductService productService = new ProductService();
    IOrderDetailSevice orderDetailSevice = new OrderDetailServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        List<Product> productList;
        List<CustomerDAO> customerDAOList;
        int pageUser;
        int customerId;
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                customerId = Integer.parseInt(request.getParameter("customerId"));
                orderService.addOrder(customerId);
                Customer customer = customerService.getCustomerById(customerId);
                productList = productService.getList();
                request.setAttribute("customerId", customer.getId());
                request.setAttribute("productList", productList);
                request.getRequestDispatcher("/users/product.jsp").forward(request, response);
                break;
            case "delete":
                delete(request, response);
                break;
            case "buy":
                buyOrderDetail(request, response);
                break;
            case "displayProducts":
                productList = productService.getList();
                request.setAttribute("productList", productList);
                request.getRequestDispatcher("/users/product.jsp").forward(request, response);
                break;
            case "orderDetail":
                orderDetail(request, response);
                break;
            case "orderDetailPage":
                pageUser = Integer.parseInt(request.getParameter("page"));
                customerId = Integer.parseInt(request.getParameter("customerId"));
                List<ProductDAO> productDAOList = orderDetailSevice.getOrderDetailProduct(customerId);
                for (int i = 1; i <= Math.ceil((double) productDAOList.size() / 6); i++) {
                    if (pageUser == i) {
                        orderDetailPage(request, response, pageUser, productDAOList);
                        break;
                    }
                }
                break;
            case "searchCustomerOrder":
                searchCustomerOrder(request, response);
                break;
            case "orderPage":
                pageUser = Integer.parseInt(request.getParameter("page"));
                customerDAOList = orderDetailSevice.getCustomerOrder();
                for (int i = 1; i <= Math.ceil((double) customerDAOList.size() / 10); i++) {
                    if (pageUser == i) {
                        orderPage(request, response, pageUser, customerDAOList);
                        break;
                    }
                }
                break;
            default:
                customerDAOList = orderDetailSevice.getCustomerOrder();
                List<CustomerDAO> limitDAOList = customerDAOList.subList(0, Math.min(10, customerDAOList.size()));
                request.setAttribute("limitDAOList", limitDAOList);
                request.setAttribute("customerDAOListSize", customerDAOList.size());
                request.getRequestDispatcher("/admin/order.jsp").forward(request, response);
        }
    }

    private static void orderPage(HttpServletRequest request, HttpServletResponse response, int pageUser, List<CustomerDAO> customerDAOList) throws ServletException, IOException {
        int max = pageUser * 6;
        int start = max - 6;
        int end = Math.min(max, customerDAOList.size());
        List<CustomerDAO> limitDAOList = customerDAOList.subList(start, end);
        request.setAttribute("limitDAOList", limitDAOList);
        request.setAttribute("customerDAOListSize", customerDAOList.size());
        request.getRequestDispatcher("/admin/order.jsp").forward(request, response);
    }

    private void searchCustomerOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String customerName = request.getParameter("customerName");
        String phoneNumber = request.getParameter("phoneNumber");
        List<CustomerDAO> customerDAOList = orderDetailSevice.searchCustomerOrder(customerName,phoneNumber);
        List<CustomerDAO> limitDAOList = customerDAOList.subList(0, Math.min(10, customerDAOList.size()));
        request.setAttribute("customerName", customerName);
        request.setAttribute("phoneNumber", phoneNumber);
        request.setAttribute("limitDAOList", limitDAOList);
        request.setAttribute("customerDAOListSize", customerDAOList.size());
        request.getRequestDispatcher("/admin/order.jsp").forward(request, response);
    }

    private static void orderDetailPage(HttpServletRequest request, HttpServletResponse response, int pageUser, List<ProductDAO> productDAOList) throws ServletException, IOException {
        int max = pageUser * 6;
        int start = max - 6;
        int end = Math.min(max, productDAOList.size());
        List<ProductDAO> limitList = productDAOList.subList(start, end);
        long totalPrice =0;
        for (int i = 0; i < productDAOList.size(); i++) {
            totalPrice +=productDAOList.get(i).getPrice()* productDAOList.get(i).getQuantity();
        }
        request.setAttribute("totalPrice", totalPrice);
        request.setAttribute("limitDAOList", limitList);
        request.setAttribute("productDAOListSize", productDAOList.size());
        request.getRequestDispatcher("/users/order_detail.jsp").forward(request, response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int customerId;
        customerId = Integer.parseInt(request.getParameter("customerId"));
        int productOrderDetailId = Integer.parseInt(request.getParameter("productOrderDetailId"));
        boolean statusOrderDetail = orderDetailSevice.deleteOrderDetail(productOrderDetailId);
        List<ProductDAO> productDAOList = orderDetailSevice.getOrderDetailProduct(customerId);
        List<ProductDAO> limitDAOList = productDAOList.subList(0, Math.min(6, productDAOList.size()));
        long totalPrice =0;
        for (int i = 0; i < productDAOList.size(); i++) {
            totalPrice +=productDAOList.get(i).getPrice()* productDAOList.get(i).getQuantity();
        }
        request.setAttribute("totalPrice", totalPrice);
        request.setAttribute("statusOrderDetail", statusOrderDetail);
        request.setAttribute("limitDAOList", limitDAOList);
        request.setAttribute("productDAOListSize", productDAOList.size());
        request.getRequestDispatcher("/users/order_detail.jsp").forward(request, response);
    }

    private void orderDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int customerId = Integer.parseInt(request.getParameter("customerId"));
        List<ProductDAO> productDAOList = orderDetailSevice.getOrderDetailProduct(customerId);
        List<ProductDAO> limitDAOList = productDAOList.subList(0, Math.min(6, productDAOList.size()));
        long totalPrice =0;
        for (int i = 0; i < productDAOList.size(); i++) {
            totalPrice +=productDAOList.get(i).getPrice()* productDAOList.get(i).getQuantity();
        }
        request.setAttribute("totalPrice", totalPrice);
        request.setAttribute("limitDAOList", limitDAOList);
        request.setAttribute("productDAOListSize", productDAOList.size());
        request.getRequestDispatcher("/users/order_detail.jsp").forward(request, response);
    }

    private void buyOrderDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int customerId;
        int productId = Integer.parseInt(request.getParameter("productId"));
        customerId = Integer.parseInt(request.getParameter("customerId"));
        orderService.addOrder(customerId);
        int orderId = orderService.getOrderId(customerId);
        Product product = productService.findById(productId);
        request.setAttribute("orderId", orderId);
        request.setAttribute("customerId", customerId);
        request.setAttribute("productId", productId);
        request.setAttribute("productName", product.getName());
        request.setAttribute("productType", product.getProductType());
        request.setAttribute("productImage", product.getProductImage());
        request.setAttribute("productDescribe", product.getDescribe());
        request.setAttribute("price", product.getPrice());
        request.getRequestDispatcher("/users/create.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "createOrderDetail":
                int orderId = Integer.parseInt(request.getParameter("orderId"));
                int customerId = Integer.parseInt(request.getParameter("customerId"));
                int productId = Integer.parseInt(request.getParameter("productId"));
                int productType = Integer.parseInt(request.getParameter("productType"));
                double price = Double.parseDouble(request.getParameter("price"));
                int quantity = Integer.parseInt(request.getParameter("quantity"));
                OrderDetail orderDetail = new OrderDetail(orderId, customerId, productId, productType, price, quantity);
                boolean statusOrderDetail = orderDetailSevice.addOrderDetail(orderDetail);
                List<ProductDAO> productDAOList = orderDetailSevice.getOrderDetailProduct(customerId);
                List<ProductDAO> limitDAOList = productDAOList.subList(0, Math.min(6, productDAOList.size()));
                long totalPrice =0;
                for (int i = 0; i < productDAOList.size(); i++) {
                    totalPrice +=productDAOList.get(i).getPrice()* productDAOList.get(i).getQuantity();
                }
                request.setAttribute("totalPrice", totalPrice);
                request.setAttribute("statusCreateOrderDetail", statusOrderDetail);
                request.setAttribute("limitDAOList", limitDAOList);
                request.setAttribute("productDAOListSize", productDAOList.size());
                request.getRequestDispatcher("/users/order_detail.jsp").forward(request, response);
                break;

        }
    }
}
