package com.example.caculator;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CaculatorServlet", value = "/caculator-servlet")
public class CaculatorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        float firstOperator = Float.parseFloat(request.getParameter("firstOperator"));
        float secondOperator = Float.parseFloat(request.getParameter("secondOperator"));
        String operator = request.getParameter("operator");
        String result = null;

        switch (operator){
            case "+":
                result = String.valueOf(firstOperator + secondOperator);
                break;
            case "-":
                result = String.valueOf(firstOperator - secondOperator);
                break;
            case "*":
                result = String.valueOf(firstOperator * secondOperator);
                break;
            case "/":
                if(secondOperator == 0){
                    result = "ERROR";
                }else {
                    result = String.valueOf(firstOperator / secondOperator);
                }
                break;
        }
        request.setAttribute("firstOperator",firstOperator);
        request.setAttribute("secondOperator",secondOperator);
        request.setAttribute("result",result);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/caculator.jsp");
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
