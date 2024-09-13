package com.example.week01_lab_nguyenthinga_21130791.services;

import com.example.week01_lab_nguyenthinga_21130791.entities.Account;
import com.example.week01_lab_nguyenthinga_21130791.entities.Log;
import com.example.week01_lab_nguyenthinga_21130791.entities.Role;
import com.example.week01_lab_nguyenthinga_21130791.respositories.LogRepository;
import com.example.week01_lab_nguyenthinga_21130791.utils.JDBCUtils;

import java.sql.*;
import java.time.Instant;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

public class LogServices  implements LogRepository {
    private static final String SELECT_ALL_LOGS = "SELECT * FROM log";
    private static final String SELECT_LOG_BY_ID = "SELECT * FROM log WHERE id = ?";
    private static final String ADD_LOG = "INSERT INTO log (account_id, login_time, logout_time, notes) VALUES (?, ?, ?, ?)";
    private static final String DELETE_LOG = "DELETE FROM log WHERE id = ?";
    private static final String UPDATE_LOG = "UPDATE log SET account_id = ?, login_time = ?, logout_time = ?, notes = ? WHERE id = ?";
    @Override
    public List<Log> getLogs() {
        List<Log> logs = new ArrayList<>();
        try(Connection connection = JDBCUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_LOGS);){
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String accountId = resultSet.getString("account_id");
                Account account = new Account(accountId);
                Date loginTime = resultSet.getDate("login_time");
                Date logoutTime = resultSet.getDate("logout_time");
                String note = resultSet.getString("notes");

                logs.add(new Log(id, account, loginTime, logoutTime, note));
            }
        }catch (SQLException e){
            JDBCUtils.printSQLException(e);
        }
        return logs;
    }

    @Override
    public Log getLog(int id) {
        Log log = null;
        try(Connection connection = JDBCUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_LOGS);){
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                int logId = resultSet.getInt("id");
                String accountId = resultSet.getString("account_id");
                Account account = new Account(accountId);
                Date loginTime = resultSet.getDate("login_time");
                Date logoutTime = resultSet.getDate("logout_time");
                String note = resultSet.getString("notes");
                log = new Log(logId, account, loginTime, logoutTime, note);
            }
        }catch (SQLException e){
            JDBCUtils.printSQLException(e);
        }
        return log;
    }

    @Override
    public boolean addLog(Log log) {
        int result = 0;
        try (Connection connection = JDBCUtils.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(ADD_LOG)){
           preparedStatement.setString(1, log.getAccount().getAccountId());
           preparedStatement.setDate(2, log.getLoginTime());
           preparedStatement.setDate(3, log.getLogoutTime());
           preparedStatement.setString(4, log.getNote());
           result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result > 0;
    }

    @Override
    public boolean removeLog(int id) {
        boolean rowDeleted = false;
        try (Connection connection = JDBCUtils.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(DELETE_LOG)){
            preparedStatement.setInt(1, id);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDeleted;
    }

    @Override
    public boolean updateLog(int id, Log log) {
        int result = 0;
        try (Connection connection = JDBCUtils.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_LOG)){
            preparedStatement.setInt(1, log.getId());
            preparedStatement.setString(2, log.getAccount().getAccountId());
            preparedStatement.setDate(3, log.getLoginTime());
            preparedStatement.setDate(4, log.getLogoutTime());
            preparedStatement.setString(5, log.getNote());
            preparedStatement.setInt(6, id);
            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result > 0;
    }

    public static void main(String[] args) {
        LogServices logServices = new LogServices();
        Log log = new Log(new Account("Met"), Date.valueOf(Instant.now().atZone(ZoneId.systemDefault()).toLocalDate()), Date.valueOf(Instant.now().atZone(ZoneId.systemDefault()).toLocalDate()), "haha" );
        System.out.println(logServices.addLog(log));

        List<Log> logs = logServices.getLogs();
        for(Log log2 : logs){
            System.err.println(log2.getAccount().getAccountId());
        }

    }
}
