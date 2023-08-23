package models.service;

import models.model.Account;

import java.util.List;

public interface IAccountService {
    String checkRole(int id);
    List<Account> getAllAccount();
}
