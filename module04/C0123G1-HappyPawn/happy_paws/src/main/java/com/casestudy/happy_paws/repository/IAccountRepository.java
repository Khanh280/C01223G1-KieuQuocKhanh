package com.casestudy.happy_paws.repository;

import com.casestudy.happy_paws.model.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.method.P;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface IAccountRepository extends JpaRepository<Account,Integer> {
    @Query(value = "SELECT  c FROM  Account c WHERE c.accountId = :userId ")
    Account findAccount(Integer userId);

    @Query(value = "SELECT u FROM Account u WHERE u.username = :username ")
    Account findUser(String username);

@Query(value = "SELECT c FROM Account c WHERE c.isDelete=false")
    Page<Account> findAllAccount(PageRequest page);

@Query(value = "UPDATE Account  SET  isDelete = true  where accountId = :accountId")
@Modifying
@Transactional
    void deleteByIdAccount(@Param("accountId") Integer accountId);

@Query(value = "SELECT a FROM Account a")
    List<Account> findAllAccounts();
}


