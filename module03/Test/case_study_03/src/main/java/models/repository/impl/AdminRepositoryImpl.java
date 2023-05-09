package models.repository.impl;

import models.model.Admin;
import models.repository.IAdminRepository;

import java.util.ArrayList;
import java.util.List;

public class AdminRepositoryImpl implements IAdminRepository {
    private static List<Admin> adminList = new ArrayList<>();
    static {
        adminList.add(new Admin("admin","admin2808"));
    }
    @Override
    public boolean checkAccountAdmin(String userName, String password) {
        for (int i = 0; i < adminList.size(); i++) {
            if(userName.equals(adminList.get(i).getUserName())){
                return password.equals(adminList.get(i).getPassword());
            } else {
                return false;
            }
        }
        return false;
    }
}
