package com.example.services.impl;

import com.example.models.Account;
import com.example.repositories.AccountRepository;
import com.example.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void save(Account account) {
        accountRepository.save(account);
    }

    @Override
    public void update(Account account, Long id) {
        if(accountRepository.existsById(id)) {
            accountRepository.save(account);
        }
    }

    @Override
    public void delete(Long id) {
        accountRepository.deleteById(id);
    }

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public List<Account> findAccountsByBalanceIsBetween(double from, double to) {
        return accountRepository.findAccountsByBalanceIsBetween(from, to);
    }
}
