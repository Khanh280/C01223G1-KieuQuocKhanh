package controller;

import models.model.User;
import models.service.IUserService;
import models.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@WebServlet(name = "UserServlet", value = "/user-servlet")
public class UserServlet extends HttpServlet {
    IUserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        List<User> userList;
        int id;
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "delete":
                id = Integer.parseInt(request.getParameter("id"));
                userService.deleteUser(id);
                request.getRequestDispatcher("/user-servlet?action=displayList").forward(request, response);
                break;
            case "update":
                update(request, response);
                break;
            case  "search":
                String country = request.getParameter("country");
                userList = userService.searchCountry(country);
                if(userList != null){
                    request.setAttribute("userList",userList);
                }
                request.getRequestDispatcher("/list.jsp").forward(request,response);
                break;
            case "displayByName":
                showListByName(request,response);
                break;
            default:
                showList(request,response);
        }
    }

    private void showListByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> userList;
        userList = userService.sortByName();
        request.setAttribute("userList", userList);
        request.getRequestDispatcher("/list.jsp").forward(request, response);
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id;
        List<User> userList;
        id = Integer.parseInt(request.getParameter("id"));
        userList = userService.getAll();
        for (int i = 0; i < userList.size(); i++) {
            if(id == userList.get(i).getId()){
                request.setAttribute("id",userList.get(i).getId());
                request.setAttribute("name",userList.get(i).getName());
                request.setAttribute("email",userList.get(i).getEmail());
                request.setAttribute("country",userList.get(i).getCountry());
                request.getRequestDispatcher("/update_user.jsp").forward(request, response);
                break;
            }
        }
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> userList;
        userList = userService.getAll();
        request.setAttribute("userList", userList);
        request.getRequestDispatcher("/list.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        User user;
        int id;
        String name;
        String email;
        String country;
        switch (action) {
            case "create":
                name = request.getParameter("name");
                email = request.getParameter("email");
                country = request.getParameter("country");
                user = new User(name, email, country);
                boolean checkCreate = userService.createUser(user);
                request.setAttribute("checkCreate", checkCreate);
                request.getRequestDispatcher("create_user.jsp").forward(request, response);
                break;
            case "update":
                id = Integer.parseInt(request.getParameter("id"));
                name = request.getParameter("name");
                email = request.getParameter("email");
                country = request.getParameter("country");
                user = new User(id,name,email,country);
                userService.updateUser(user);
                response.sendRedirect("/user-servlet");
                break;
            case  "createTransaction":
                name = request.getParameter("name");
                email = request.getParameter("email");
                country = request.getParameter("country");
                user = new User(name, email, country);
                boolean checkCreateTransaction = userService.addUserTransaction(user);
                request.setAttribute("checkCreateTransaction", checkCreateTransaction);
                request.getRequestDispatcher("create_user_transaction.jsp").forward(request, response);
                break;
        }
    }
}
