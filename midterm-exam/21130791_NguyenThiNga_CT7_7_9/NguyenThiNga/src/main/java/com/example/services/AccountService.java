package com.example.services;

import com.example.entities.Account;
import java.util.List;
public interface AccountService {
    public boolean create(Account account);
    public List<Account> getAllAccounts();
    public List<Account> getAccountByRangeOfBalance(double amount, double amountEnd);
    public List<Account> getAccountOwnerAddress(String address);


    public List<Account> getAccountByOwnerName(String name);
    public List<Account> getAccountByAmount(Double amount);
}
