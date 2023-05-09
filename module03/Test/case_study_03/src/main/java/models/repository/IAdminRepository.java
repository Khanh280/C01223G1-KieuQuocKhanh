package models.repository;

public interface IAdminRepository {
    boolean checkAccountAdmin(String userName, String password);
}
