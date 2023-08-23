package com.casestudy.happy_paws.service.impl;

import com.casestudy.happy_paws.model.Account;
import com.casestudy.happy_paws.repository.IAccountRepository;
import com.casestudy.happy_paws.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService implements IAccountService, UserDetailsService {
    @Autowired
    private IAccountRepository accountRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void save(Account account) {
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        accountRepository.save(account);
    }

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

//    @Override
//    public Account findUser(String username) {
//        return null;
//    }

    @Override
    public Account findAccount(Integer accountId) {
        return accountRepository.findAccount(accountId);
    }

    @Override
    public Account findById(Integer id) {
        return accountRepository.findById(id).get();
    }

    @Override
    public void update(Account account) {
        accountRepository.save(account);
    }

    @Override
    public void delete(Integer accountId) {
        accountRepository.deleteByIdAccount(accountId);
    }

    @Override
    public Page<Account> getAllPage(int page) {
        return accountRepository.findAllAccount(PageRequest.of(page, 5, Sort.by("createTime").descending()));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //Tìm đối tượng đang đăng nhập trong DB
        Account account = this.accountRepository.findUser(username);

        if (account == null) {
            System.out.println("Account not found! " + username);
            throw new UsernameNotFoundException("Account " + username + " was not found in the database");
        }

        List<GrantedAuthority> grantList = new ArrayList<>();
        GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + account.getRole().getNameRole());
        grantList.add(authority);
        System.out.println(grantList);
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(account.getUsername(),
                account.getPassword(), grantList);

        return userDetails;

    }

//    @Override
//    public void save(Account user) {
//
//        accountRepository.save(user);
//    }


//    @Override
//    public List<Account> findAll() {
//        return accountRepository.findAll();
//    }


    //    @Override
//    public Account findAccount() {
//        return accountRepository.findAccount();
//    }
// laf
//    @Override
//    public Account findAccount(Integer userId) {
//        return accountRepository.findAccount(userId);
//    }

//    @Override
//    public Account findUser(String username) {
//        return accountRepository.findUser(username);
//    }


}
