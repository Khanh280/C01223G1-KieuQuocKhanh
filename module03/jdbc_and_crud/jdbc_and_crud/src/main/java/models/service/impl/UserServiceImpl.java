package models.service.impl;

import models.model.User;
import models.repository.IUserRepository;
import models.repository.impl.UserRepositoryImpl;
import models.service.IUserService;

import java.util.List;

public class UserServiceImpl implements IUserService {
    IUserRepository userRepository = new UserRepositoryImpl();

    @Override
    public List<User> getAll() {
        return userRepository.getAll();
    }

    @Override
    public boolean createUser(User user) {
        return userRepository.createUser(user);
    }

    @Override
    public boolean deleteUser(int id) {
        return userRepository.deleteUser(id);
    }

    @Override
    public boolean updateUser(User user) {
        return userRepository.updateUser(user);
    }

    @Override
    public List<User> searchCountry(String country) {
        return userRepository.searchCountry(country);
    }

    @Override
    public List<User> sortByName() {
        return userRepository.sortByName();
    }
}
