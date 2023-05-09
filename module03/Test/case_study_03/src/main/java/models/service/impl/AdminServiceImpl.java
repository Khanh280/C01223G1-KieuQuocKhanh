package models.service.impl;

import models.repository.IAdminRepository;
import models.repository.impl.AdminRepositoryImpl;
import models.service.IAdminService;

public class AdminServiceImpl implements IAdminService {
    IAdminRepository adminRepository = new AdminRepositoryImpl();
    @Override
    public boolean checkAccountAdmin(String userName, String password) {
        return adminRepository.checkAccountAdmin(userName,password);
    }
}
