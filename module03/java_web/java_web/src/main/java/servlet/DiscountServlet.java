package servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DiscountServlet" , urlPatterns = "/display-discount")
public class DiscountServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String description = req.getParameter("description");
        int price = Integer.parseInt(req.getParameter("price"));
        int discount = Integer.parseInt(req.getParameter("discount"));
        double discountAmount = price * discount * 0.01;
        req.setAttribute("price",price);
        req.setAttribute("discount",discount);
        req.setAttribute("description",description);
        req.setAttribute("discountAmount",discountAmount);
        req.setAttribute("discountPrice",discount-discountAmount);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/index.jsp");
        requestDispatcher.forward(req,resp);
    }
}
