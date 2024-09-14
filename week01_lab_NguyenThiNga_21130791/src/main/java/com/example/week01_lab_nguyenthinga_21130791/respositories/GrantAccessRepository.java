package com.example.week01_lab_nguyenthinga_21130791.respositories;

import com.example.week01_lab_nguyenthinga_21130791.entities.Account;
import com.example.week01_lab_nguyenthinga_21130791.entities.GrantAccess;
import com.example.week01_lab_nguyenthinga_21130791.entities.Role;
import java.util.List;

public interface GrantAccessRepository {
    public boolean addGrantAccess(GrantAccess grantAccess);
    public List<String> getRolesByAccountId(String accountId);
    public List<Account> getAccountsByRoleId(String roleId);
}
