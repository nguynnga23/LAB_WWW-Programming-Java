package com.example.week01_lab_nguyenthinga_21130791.respositories;
import com.example.week01_lab_nguyenthinga_21130791.entities.Account;

import java.util.List;


public interface AccountRepository {
    public List<Account> listAccount();
    public Account getAccountById(String id);
    public boolean addAccount(Account account);
    public boolean updateAccount(Account account);
    public boolean removeAccount(String id);
    public boolean validateAccount(Account account);
}

