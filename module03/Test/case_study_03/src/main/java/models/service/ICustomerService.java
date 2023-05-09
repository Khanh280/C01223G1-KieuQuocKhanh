package models.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ICustomerService {
    void saveCustomer(HttpServletRequest request, HttpServletResponse response);
    boolean checkAccount(String userName, String password);
}
