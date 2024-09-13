package com.example.week01_lab_nguyenthinga_21130791.entities;

import java.sql.Date;

public class Log {
    private int id;
    private Account account;
    private Date loginTime;
    private Date logoutTime;
    private String note;

    public Log(int id, Account account, Date loginTime, Date logoutTime, String note) {
        this.id = id;
        this.account = account;
        this.loginTime = loginTime;
        this.logoutTime = logoutTime;
        this.note = note;
    }

    public Log(Account account, Date loginTime, Date logoutTime, String note) {
        this.account = account;
        this.loginTime = loginTime;
        this.logoutTime = logoutTime;
        this.note = note;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public Date getLogoutTime() {
        return logoutTime;
    }

    public void setLogoutTime(Date logoutTime) {
        this.logoutTime = logoutTime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Log{" +
                "id=" + id +
                ", account=" + account +
                ", loginTime=" + loginTime +
                ", logoutTime=" + logoutTime +
                ", note='" + note + '\'' +
                '}';
    }
}

