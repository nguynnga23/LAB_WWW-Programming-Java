package com.example.services;

import com.example.models.Account;
import com.example.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccountService {
    List<Account> findByBalanceGreaterThan(double balance, Pageable pageable);
    Account findById(Long id);
    void addAccount();
    void deleteAccount();

}
