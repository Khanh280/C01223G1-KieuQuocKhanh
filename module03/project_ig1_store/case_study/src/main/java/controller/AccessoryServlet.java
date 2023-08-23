package controller;

import models.model.Product;
import models.service.IAccessoryService;
import models.service.impl.AccessoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AccessoryServlet",urlPatterns = "/accessory")
public class AccessoryServlet extends HttpServlet {
    private IAccessoryService accessoryService = new AccessoryService();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        List<Product> productList;
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "displayPageUser":
                int pageUser = Integer.parseInt(request.getParameter("page"));
                productList = accessoryService.getList();
                for (int i = 1; i <= Math.ceil((double) productList.size() / 15); i++) {
                    if (pageUser == i) {
                        displayPageUser(request, response, productList, pageUser);
                        break;
                    }
                }
                break;
            default:
                showList(request, response);
        }
    }

    private static void displayPageUser(HttpServletRequest request, HttpServletResponse response, List<Product> productsList, int page) throws ServletException, IOException {
        int max = page * 15;
        int start = max - 15;
        int end = Math.min(max, productsList.size());
        List<Product> limitList = productsList.subList(start, end);
        request.setAttribute("productList", limitList);
        request.setAttribute("productListSize", productsList.size());
        request.getRequestDispatcher("/users/home.jsp").forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = accessoryService.findById(id);
        request.setAttribute("product", product);
        try {
            request.getRequestDispatcher("view/accessorys/edit.jsp").forward(request, response);

        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("view/accessorys/create.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) {
        List<Product> productList = accessoryService.getList();
        request.setAttribute("productList", productList);
        try {
            request.getRequestDispatcher("view/accessorys/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createProduct(request, response);
                break;
            case "delete":
                removeProduct(request, response);
                break;
            case "edit":
                editProduct(request, response);
                break;
            case "search":
                seachProduct(request, response);
                break;
            case "searchUser":
                String productName = request.getParameter("productName");
                if (productName.equals("")) {
                    List<Product> productList = accessoryService.getList();
                    List<Product> limitList = productList.subList(0, Math.min(15, productList.size()));
                    request.setAttribute("productList", limitList);
                    request.setAttribute("productListSize", productList.size());
                } else {
                    List<Product> productList = accessoryService.searchUser(productName);
                    request.setAttribute("productList", productList);
                }
                request.getRequestDispatcher("/users/home.jsp").forward(request, response);
                break;

        }
    }

    private void seachProduct(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price"));
        List<Product> searchProductList = null;
        switch (price) {
            case 6:
                searchProductList = accessoryService.search(name, 0, 1000000000);
            case 1:
                searchProductList = accessoryService.search(name, 0, 100000);
                break;
            case 2:
                searchProductList = accessoryService.search(name, 100001, 500000);
                break;
            case 3:
                searchProductList = accessoryService.search(name, 500001, 1000000);
                break;
            case 4:
                searchProductList = accessoryService.search(name, 1000001, 5000000);
                break;
            case 5:
                searchProductList = accessoryService.search(name, 5000001, 1000000000);
                break;
        }
        request.setAttribute("productList", searchProductList);
        try {
            request.getRequestDispatcher("view/accessorys/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void editProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int productType = Integer.parseInt(request.getParameter("productType"));
        String describe = request.getParameter("describe");
        double price = Double.parseDouble(((request.getParameter("price"))));
        String productImage = request.getParameter("productImage");
        Product product = new Product(id, name, productType, describe, price, productImage);
        boolean checkEdit = accessoryService.edit(product);
        List<Product> productList = accessoryService.getList();
        request.setAttribute("productList", productList);
        request.setAttribute("checkEdit", checkEdit);
        try {
            request.getRequestDispatcher("view/accessorys/list.jsp").forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void removeProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        boolean checkRemove = accessoryService.remove(id);
       request.setAttribute("checkRemove",checkRemove);
        showList(request, response);
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        int productType = Integer.parseInt(request.getParameter("productType"));
        String describe = request.getParameter("describe");
        double price = Double.parseDouble(((request.getParameter("price"))));
        String productImage = request.getParameter("productImage");
        Product product = new Product(name, productType, describe, price, productImage);
        boolean checkCreate = accessoryService.createAt(product);
        List<Product> productList = accessoryService.getList();
        request.setAttribute("productList",productList);
        request.setAttribute("checkCreate",checkCreate);
        try {
            request.getRequestDispatcher("/view/accessorys/list.jsp").forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
