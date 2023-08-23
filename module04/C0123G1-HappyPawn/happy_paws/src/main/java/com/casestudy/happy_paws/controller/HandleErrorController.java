package com.casestudy.happy_paws.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.NoHandlerFoundException;

@Controller
public class HandleErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request) throws NoHandlerFoundException {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        if (status != null) {
            Integer statusCode = Integer.valueOf(status.toString());
            if (statusCode == HttpStatus.NOT_FOUND.value()) {
                throw new NoHandlerFoundException(request.getMethod(), request.getRequestURI(), null);
            }
        }
        return "/customers/500";
    }
}