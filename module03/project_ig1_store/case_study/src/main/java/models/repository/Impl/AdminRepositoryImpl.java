package models.repository.Impl;

import models.model.Account;
import models.repository.IAdminRepository;

import java.util.ArrayList;
import java.util.List;

public class AdminRepositoryImpl implements IAdminRepository {
    private static List<Account> accountList = new ArrayList<>();
    static {
        accountList.add(new Account("admin","admin2808"));
    }
    @Override
    public boolean checkAccountAdmin(String userName, String password) {
        for (int i = 0; i < accountList.size(); i++) {
            if(userName.equals(accountList.get(i).getUserName())){
                return password.equals(accountList.get(i).getPassword());
            } else {
                return false;
            }
        }
        return false;
    }
}
