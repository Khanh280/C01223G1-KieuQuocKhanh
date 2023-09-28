package controller;

import models.model.Account;
import models.model.Customer;
import models.service.ICustomerService;
import models.service.impl.CustomerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerServlet", value = "/customer-servlet")
public class CustomerServlet extends HttpServlet {
    private final ICustomerService customerService = new CustomerServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                try {
                    request.getRequestDispatcher("/customer/create.jsp").forward(request, response);
                } catch (ServletException | IOException e) {
                    e.printStackTrace();
                }
                break;
            case "edit":
                sendCustomer(request, response);
                break;
            case "search":
                searchCustomer(request, response);
                break;
            default:
                showList(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createCustomer(request, response);
                break;
            case "delete":
                deleteCustomer(request, response);
                break;
            case "edit":
                editCustomer(request, response);
                break;
        }
    }

    public void showList(HttpServletRequest request, HttpServletResponse response) {
        List<Customer> customerList = customerService.getAllCustomer();
        request.setAttribute("customerList", customerList);
        try {
            request.getRequestDispatcher("/customer/list.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    public void createCustomer(HttpServletRequest request, HttpServletResponse response) {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String fullName = request.getParameter("fullName");
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phoneNumber");
        String address = request.getParameter("address");
        Account account = new Account(userName, password);
        Customer customer = new Customer(fullName, email, phoneNumber, address, account);
        boolean check = customerService.saveCustomer(customer);
        request.setAttribute("check",check);
        try {
            request.getRequestDispatcher("/customer/create.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("customerId"));
        int accountId = Integer.parseInt(request.getParameter("accountUserID"));
        boolean check = customerService.deleteCustomer(id, accountId);
        List<Customer> customerList = customerService.getAllCustomer();
        request.setAttribute("check",check);
        request.setAttribute("customerList", customerList);
        try {
            request.getRequestDispatcher("/customer/list.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    public void searchCustomer(HttpServletRequest request, HttpServletResponse response) {
        String nameCustomer = request.getParameter("nameCustomer");
        String addressCustomer = request.getParameter("addressCustomer");
        String phoneNumber = request.getParameter("phone");
        List<Customer> customerList = customerService.searchCustomer(nameCustomer, addressCustomer,phoneNumber);
        request.setAttribute("name", nameCustomer);
        request.setAttribute("address", addressCustomer);
        request.setAttribute("phoneNumber",phoneNumber);
            request.setAttribute("customerList", customerList);
            try {
                request.getRequestDispatcher("/customer/list.jsp").forward(request, response);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
    }

    private void sendCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("customerId"));
        Customer customer = customerService.getCustomer(id);
        request.setAttribute("customer", customer);
        try {
            request.getRequestDispatcher("/customer/edit.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    public void editCustomer(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        String fullName = request.getParameter("fullName");
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phoneNumber");
        String address = request.getParameter("address");
        Customer customer = new Customer(Integer.parseInt(id), fullName, email, phoneNumber, address);
        boolean check = customerService.editCustomer(customer);
        request.setAttribute("check",check);
        try {
            request.getRequestDispatcher("/customer/edit.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
