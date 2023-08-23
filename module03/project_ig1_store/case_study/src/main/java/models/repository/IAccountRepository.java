package models.repository;

import models.model.Account;

import java.util.List;

public interface IAccountRepository {
    String checkRole(int id);
    List<Account> getAllAccount();
}
