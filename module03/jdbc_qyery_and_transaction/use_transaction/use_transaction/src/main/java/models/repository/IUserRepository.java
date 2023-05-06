package models.repository;

import models.model.User;

import java.util.List;

public interface IUserRepository {
    List<User> getAll();
    boolean createUser(User user);
    boolean deleteUser(int id);
    boolean updateUser(User user);
    List<User> searchCountry(String country);
    List<User> sortByName();
    boolean addUserTransaction(User user);
}
