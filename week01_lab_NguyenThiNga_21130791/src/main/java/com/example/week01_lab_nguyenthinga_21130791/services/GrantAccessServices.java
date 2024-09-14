package com.example.week01_lab_nguyenthinga_21130791.services;

import com.example.week01_lab_nguyenthinga_21130791.entities.Account;
import com.example.week01_lab_nguyenthinga_21130791.entities.GrantAccess;
import com.example.week01_lab_nguyenthinga_21130791.entities.Role;
import com.example.week01_lab_nguyenthinga_21130791.respositories.AccountRepository;
import com.example.week01_lab_nguyenthinga_21130791.respositories.GrantAccessRepository;
import com.example.week01_lab_nguyenthinga_21130791.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GrantAccessServices implements GrantAccessRepository {
    private static final String ADD_GRANT_ACCESS = "INSERT INTO grant_access (role_id, account_id, is_grant, note) VALUES (?, ?, ?, ?)";
    private static final String GET_ROLES_BY_ACCOUNT_ID = "SELECT * FROM grant_access WHERE account_id = ?";
    private static final String GET_ACCOUNTS_BY_ROLEID = "SELECT account_id FROM grant_access WHERE role_id = ?";

    private AccountRepository accountRepository;

    @Override
    public boolean addGrantAccess(GrantAccess grantAccess) {
        int result = 0;
        try (Connection connection = JDBCUtils.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(ADD_GRANT_ACCESS)){
            preparedStatement.setString(1, grantAccess.getRole().getRoleId());
            preparedStatement.setString(2, grantAccess.getAccount().getAccountId());
            preparedStatement.setByte(3, grantAccess.getIs_grant());
            preparedStatement.setString(4, grantAccess.getNote());
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result > 0;
    }

    @Override
    public List<String> getRolesByAccountId(String accountId) {
        List<String> roles = new ArrayList<>();
        try(Connection connection = JDBCUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ROLES_BY_ACCOUNT_ID);) {
            preparedStatement.setString(1, accountId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
              String roleId = resultSet.getString("role_id");
              Role role = new Role(roleId);
              String accId = resultSet.getString("account_id");
              Account account = new Account(accId);
              Byte isGrant = resultSet.getByte("is_grant");
              String note = resultSet.getString("note");
              roles.add(new GrantAccess(role, account, isGrant, note).getRole().getRoleId());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return roles;
    }

    @Override
    public List<Account> getAccountsByRoleId(String roleId) {
        List<Account> accounts = new ArrayList<>();
        accountRepository = new AccountServices();
        try(Connection connection = JDBCUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ACCOUNTS_BY_ROLEID);) {
            preparedStatement.setString(1, roleId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String accountId = resultSet.getString("account_id");
                accounts.add(accountRepository.getAccountById(accountId));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return accounts;
    }

    public static void main(String[] args) {
        GrantAccessServices grantAccessServices = new GrantAccessServices();
        List<Account> grantAccesses = grantAccessServices.getAccountsByRoleId("user");
        for(Account account: grantAccesses){
            System.out.println(account);
        }
    }
}
