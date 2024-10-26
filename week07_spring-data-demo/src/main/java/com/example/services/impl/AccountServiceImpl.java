package com.example.services.impl;

import com.example.models.Account;
import com.example.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.example.repositories.AccountRepository;
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountRepository accountRepository;
    @Override
    public List<Account> findByBalanceGreaterThan(double balance, Pageable pageable) {
        return accountRepository.findByBalanceGreaterThan(balance, pageable);
    }
    @Override
    public Account findById(Long id) {
        Optional<Account> account = accountRepository.findById(id);
        if(account.isPresent()){
            return account.get();
        }else
            return null;
    }
    @Override
    public void addAccount() {

    }
    @Override
    public void deleteAccount() {
        accountRepository.deleteAll();
    }
}
