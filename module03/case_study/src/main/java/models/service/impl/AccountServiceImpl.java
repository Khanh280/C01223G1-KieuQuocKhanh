package models.service.impl;

import models.model.Account;
import models.repository.IAccountRepository;
import models.repository.Impl.AccountRepositoryImpl;
import models.service.IAccountService;

import java.util.List;

public class AccountServiceImpl implements IAccountService {
    IAccountRepository accountRepository = new AccountRepositoryImpl();
    @Override
    public String checkRole(int id) {
        return accountRepository.checkRole(id);
    }

    @Override
    public List<Account> getAllAccount() {
        return accountRepository.getAllAccount();
    }
}
