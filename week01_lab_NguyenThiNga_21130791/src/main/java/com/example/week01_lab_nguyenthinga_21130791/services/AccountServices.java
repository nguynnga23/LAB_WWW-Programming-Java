package com.example.week01_lab_nguyenthinga_21130791.services;

import com.example.week01_lab_nguyenthinga_21130791.entities.Account;
import com.example.week01_lab_nguyenthinga_21130791.respositories.AccountRepository;
import com.example.week01_lab_nguyenthinga_21130791.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountServices implements AccountRepository {

    private static final String SELECT_ALL_ACCOUNTS = "SELECT * FROM account";
    private static final String SELECT_ACCOUNT_BY_ID = "SELECT * FROM account WHERE account_id = ?";
    private static final String ADD_ACCOUNT = "INSERT INTO account (account_id, full_name, password, email, phone, status) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String REMOVE_ACCOUNT = "DELETE FROM account WHERE account_id = ?";
    private static final String UPDATE_ACCOUNT = "UPDATE account SET account_id = ?, full_name = ?, password = ?, email = ?, phone = ?, status = ? WHERE account_id = ?";
    private static final String VALIDATE_ACCOUNT = "SELECT * FROM account WHERE account_id = ? and password = ?";


    @Override
    public List<Account> listAccount() {
        List<Account> accounts = new ArrayList<>();
        try(Connection connection = JDBCUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ACCOUNTS);){
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                String accountId = resultSet.getString("account_id");
                String fullName = resultSet.getString("full_name");
                String password = resultSet.getString("password");
                String email = resultSet.getString("email");
                String phoneNumber = resultSet.getString("phone");
                Byte status = resultSet.getByte("status");
                accounts.add(new Account(accountId, status, password, email, phoneNumber, fullName));
            }
        }catch (SQLException e){
            JDBCUtils.printSQLException(e);
        }
        return accounts;
    }

    @Override
    public Account getAccountById(String id) {
        Account account = null;
        try(Connection connection = JDBCUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ACCOUNT_BY_ID);) {
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String accountId = resultSet.getString("account_id");
                String fullName = resultSet.getString("full_name");
                String password = resultSet.getString("password");
                String email = resultSet.getString("email");
                String phoneNumber = resultSet.getString("phone");
                Byte status = resultSet.getByte("status");
                account = new Account(accountId, status, password, email, phoneNumber, fullName);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return account;
    }

    @Override
    public boolean addAccount(Account account) {
        int result = 0;
        try (Connection connection = JDBCUtils.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(ADD_ACCOUNT)){
            preparedStatement.setString(1, account.getAccountId());
            preparedStatement.setString(2, account.getFullName());
            preparedStatement.setString(3, account.getPassword());
            preparedStatement.setString(4, account.getEmail());
            preparedStatement.setString(5, account.getPhone());
            preparedStatement.setByte(6, account.getStatus());

            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result > 0;
    }

    @Override
    public boolean updateAccount(Account account) {
        int result = 0;
        try (Connection connection = JDBCUtils.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ACCOUNT)){
            preparedStatement.setString(1, account.getAccountId());
            preparedStatement.setString(2, account.getFullName());
            preparedStatement.setString(3, account.getPassword());
            preparedStatement.setString(4, account.getEmail());
            preparedStatement.setString(5, account.getPhone());
            preparedStatement.setByte(6, account.getStatus());
            preparedStatement.setString(7, account.getAccountId());


            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result > 0;
    }

    @Override
    public boolean removeAccount(String id) {
        boolean rowDeleted = false;

        try (Connection connection = JDBCUtils.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(REMOVE_ACCOUNT)){

            preparedStatement.setString(1, id);

            rowDeleted = preparedStatement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rowDeleted;
    }

    @Override
    public boolean validateAccount(Account account) {
        boolean status = false;
        try(Connection connection = JDBCUtils.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(VALIDATE_ACCOUNT);){
            preparedStatement.setString(1, account.getAccountId());
            preparedStatement.setString(2, account.getPassword());
            ResultSet resultSet = preparedStatement.executeQuery();
            status = (resultSet.next());
        }catch (SQLException e){
            JDBCUtils.printSQLException(e);
        }
        return status;
    }


    public static void main(String[] args) {
        AccountRepository account = new AccountServices();
        List<Account> list = account.listAccount();
        Account account1 = new Account();
        account1.setAccountId("teo");
        account1.setPassword("1234");
        System.out.println(account.validateAccount(account1));
    }
}
