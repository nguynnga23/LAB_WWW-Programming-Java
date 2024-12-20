package com.example.week01_lab_nguyenthinga_21130791.entities;

public class Account {
    private String accountId;
    private String fullName;
    private String password;
    private String email;
    private String phone;
    private Byte status;

    public Account(String accountId, Byte status, String phone, String email, String password, String fullName) {
        this.accountId = accountId;
        this.status = status;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.fullName = fullName;
    }

    public Account(String accountId) {
        this.accountId = accountId;
    }

    public Account() {

    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId='" + accountId + '\'' +
                ", fullName='" + fullName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", status=" + status +
                '}';
    }
}
