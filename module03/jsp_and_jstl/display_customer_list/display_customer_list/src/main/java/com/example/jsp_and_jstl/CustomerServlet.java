package com.example.jsp_and_jstl;

import model.Customer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet", value = "/customer-servlet")
public class CustomerServlet extends HttpServlet {
    private static List<Customer> customerList = new ArrayList<>();
    static  {
        customerList.add(new Customer("Mai Văn Hoàn","1983-08-20","Hà Nội","https://th.bing.com/th/id/R.95e45a66c918a53280e796b44add2d66?rik=oVKQ59XBdewj8Q&pid=ImgRaw&r=0"));
        customerList.add(new Customer("Nguyễn Văn Nam","1983-08-21","Bắc Giang","https://th.bing.com/th/id/R.853468c66ffd8d0acc76ea996e282a0a?rik=iJpwHOQ4CC8xbA&riu=http%3a%2f%2fwww.publicdomainpictures.net%2fpictures%2f10000%2fvelka%2f2612-1273513357htay.jpg&ehk=H4GnSNkpifihlEglkNChj3h9uKN21ly2T%2fJloDsNYjw%3d&risl=&pid=ImgRaw&r=0"));
        customerList.add(new Customer("Nguyễn Thái Hòa","1983-08-22","Namn Định","https://news-media.stanford.edu/wp-content/uploads/sites/2/2016/10/12100116/Decker.jpg"));
        customerList.add(new Customer("Trần Đăng Khoa","1983-08-17","Hà Tây","https://th.bing.com/th/id/OIP.p3j6KeMqwuoLLhQPh0vyrgAAAA?pid=ImgDet&rs=1"));
        customerList.add(new Customer("Nguyễn Đình Thi","1983-08-19","Hà Nội","https://th.bing.com/th/id/OIP.lW8GnPQKT38F89v6OSBJrQAAAA?pid=ImgDet&w=225&h=300&rs=1"));
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("customerList",customerList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
