package controller;

import models.model.Products;
import models.service.IAdminService;
import models.service.ICustomerService;
import models.service.IProductService;
import models.service.impl.AdminServiceImpl;
import models.service.impl.CustomerServiceImpl;
import models.service.impl.ProductServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "AccountServlet", value = "/account-servlet")
public class AccountServlet extends HttpServlet {
    ICustomerService customerService = new CustomerServiceImpl();
    IAdminService adminService = new AdminServiceImpl();
    IProductService productService = new ProductServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "register":
                customerService.saveCustomer(request, response);
                request.getRequestDispatcher("/register_form.jsp").forward(request, response);
                break;
            case "login":
                String userName = request.getParameter("userName");
                String password = request.getParameter("password");
                if (userName.equals("admin")) {
                    boolean result = adminService.checkAccountAdmin(userName, password);
                    if (result) {
                        List<Products> productList = productService.getAll();
                        List<Products> limitList = productList.subList(0, Math.min(10,productList.size()));
                        request.setAttribute("productList", limitList);
                        request.setAttribute("productListSize", productList.size());
                        request.getRequestDispatcher("/admin/admin.jsp").forward(request, response);
                    } else {
                        request.setAttribute("userName", userName);
                        request.setAttribute("action", "fail");
                        request.getRequestDispatcher("/index.jsp").forward(request, response);
                    }
                } else {
                    boolean result = customerService.checkAccount(userName, password);
                    if (result) {
                        List<Products> productList = productService.getAll();
                        List<Products> limitList = productList.subList(0, Math.min(12,productList.size()));
                        request.setAttribute("productList", limitList);
                        request.setAttribute("productListSize",productList.size());
                        request.getRequestDispatcher("/users/user.jsp").forward(request, response);
                    } else {
                        request.setAttribute("userName", userName);
                        request.setAttribute("status", "fail");
                        request.getRequestDispatcher("/index.jsp").forward(request, response);
                    }
                }
        }
    }
}
