package com.example.services;

import com.example.models.Account;

import java.util.List;

public interface AccountService {
    void save(Account account);
    void update(Account account, Long id);
    void delete(Long id);
    List<Account> findAll();
    List<Account> findAccountsByBalanceIsBetween(double from, double to);
}
