package controller;

import models.model.Customer;
import models.model.ProductDAO;
import models.service.IOrderDetailSevice;
import models.service.impl.OrderDetailServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "OrderDetailServlet", value = "/order-detail-servlet")
public class OrderDetailServlet extends HttpServlet {
    IOrderDetailSevice orderDetailSevice = new OrderDetailServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        int customerId;
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "orderDetail":
                orderDetail(request, response);
                break;
            case "delete":
                deleteOrderDetail(request, response);
                break;
            case "update":
                int orderDetailId = Integer.parseInt(request.getParameter("orderDetailId"));
                ProductDAO productDAO = orderDetailSevice.getOrderDetailById(orderDetailId);
                request.setAttribute("productDAOName", productDAO.getName());
                request.setAttribute("productDAOImage", productDAO.getProductImage());
                request.setAttribute("productDAODescribe", productDAO.getDescribe());
                request.setAttribute("productDAOPrice", productDAO.getPrice());
                request.setAttribute("productDAOQuantity", productDAO.getQuantity());
                request.setAttribute("productDAOOrderDetailId", productDAO.getOrderDetailId());
                request.getRequestDispatcher("/users/update_order_detail.jsp").forward(request, response);
                break;
            case "orderDetailPage":
                int pageUser = Integer.parseInt(request.getParameter("page"));
                customerId = Integer.parseInt(request.getParameter("customerId"));
                List<ProductDAO> productDAOList = orderDetailSevice.getOrderDetailProduct(customerId);
                for (int i = 1; i <= Math.ceil((double) productDAOList.size() / 6); i++) {
                    if (pageUser == i) {
                        orderDetailPage(request, response, pageUser, productDAOList,customerId);
                        break;
                    }
                }
                break;
        }
    }

    private static void orderDetailPage(HttpServletRequest request, HttpServletResponse response, int pageUser, List<ProductDAO> productDAOList, int customerId) throws ServletException, IOException {
        int max = pageUser * 6;
        int start = max - 6;
        int end = Math.min(max, productDAOList.size());
        List<ProductDAO> limitList = productDAOList.subList(start, end);
        request.setAttribute("customerId",customerId);
        request.setAttribute("limitDAOList", limitList);
        request.setAttribute("productDAOListSize", productDAOList.size());
        request.getRequestDispatcher("/admin/order_detail.jsp").forward(request, response);
    }

    private void deleteOrderDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int productOrderDetailId = Integer.parseInt(request.getParameter("productOrderDetailId"));
        boolean statusDeleteOrderDetail = orderDetailSevice.deleteOrderDetail(productOrderDetailId);
        int customerId = Integer.parseInt(request.getParameter("customerId"));
        List<ProductDAO> productDAOList = orderDetailSevice.getOrderDetailProduct(customerId);
        List<ProductDAO> limitDAOList = productDAOList.subList(0, Math.min(6, productDAOList.size()));
        request.setAttribute("statusDeleteOrderDetail", statusDeleteOrderDetail);
        request.setAttribute("customerId", customerId);
        request.setAttribute("limitDAOList", limitDAOList);
        request.setAttribute("productDAOListSize", productDAOList.size());
        request.getRequestDispatcher("/admin/order_detail.jsp").forward(request, response);
    }

    private void orderDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int customerId = Integer.parseInt(request.getParameter("customerId"));
        List<ProductDAO> productDAOList = orderDetailSevice.getOrderDetailProduct(customerId);
        List<ProductDAO> limitDAOList = productDAOList.subList(0, Math.min(6, productDAOList.size()));
        request.setAttribute("customerId", customerId);
        request.setAttribute("limitDAOList", limitDAOList);
        request.setAttribute("productDAOListSize", productDAOList.size());
        request.getRequestDispatcher("/admin/order_detail.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "update":
                update(request, response);
                break;
            case "search":
                search(request, response);
                break;
            case "searchProductOrderDetail":
                String productName = request.getParameter("productName");
                int customerId = Integer.parseInt(request.getParameter("customerId"));
                List<ProductDAO> productDAOList = orderDetailSevice.searchOrderDetailProduct(customerId, productName);
                List<ProductDAO> limitDAOList = productDAOList.subList(0, Math.min(6, productDAOList.size()));
                request.setAttribute("customerId",customerId);
                request.setAttribute("productName", productName);
                request.setAttribute("limitDAOList", limitDAOList);
                request.setAttribute("productDAOListSize", productDAOList.size());
                request.getRequestDispatcher("/admin/order_detail.jsp").forward(request, response);
                break;
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Customer customer = (Customer) session.getAttribute("userSession");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        int orderDetailId = Integer.parseInt(request.getParameter("orderDetailId"));
        boolean statusUpdate = orderDetailSevice.updateOrderDetail(quantity, orderDetailId);
        int customerId = customer.getId();
        List<ProductDAO> productDAOList = orderDetailSevice.getOrderDetailProduct(customerId);
        List<ProductDAO> limitDAOList = productDAOList.subList(0, Math.min(6, productDAOList.size()));
        long totalPrice =0;
        for (int i = 0; i < productDAOList.size(); i++) {
            totalPrice +=productDAOList.get(i).getPrice()* productDAOList.get(i).getQuantity();
        }
        request.setAttribute("totalPrice", totalPrice);
        request.setAttribute("statusUpdate", statusUpdate);
        request.setAttribute("limitDAOList", limitDAOList);
        request.setAttribute("productDAOListSize", productDAOList.size());
        request.getRequestDispatcher("/users/order_detail.jsp").forward(request, response);
    }

    private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int customerId;
        String productName = request.getParameter("productName");
        customerId = Integer.parseInt(request.getParameter("customerId"));
        List<ProductDAO> productDAOList = orderDetailSevice.searchOrderDetailProduct(customerId, productName);
        List<ProductDAO> limitDAOList = productDAOList.subList(0, Math.min(6, productDAOList.size()));
        List<ProductDAO> productDAOListPrice = orderDetailSevice.getOrderDetailProduct(customerId);
        long totalPrice =0;
        for (int i = 0; i < productDAOListPrice.size(); i++) {
            totalPrice +=productDAOListPrice.get(i).getPrice()* productDAOListPrice.get(i).getQuantity();
        }
        request.setAttribute("totalPrice", totalPrice);
        request.setAttribute("productName", productName);
        request.setAttribute("limitDAOList", limitDAOList);
        request.setAttribute("productDAOListSize", productDAOList.size());
        request.getRequestDispatcher("/users/order_detail.jsp").forward(request, response);
    }
}
