package com.example.week01_lab_nguyenthinga_21130791.entities;
public class GrantAccess {
    private Role role;
    private Account account;
    private Byte is_grant;
    private String note;

    public GrantAccess(Role role, Account account, Byte is_grant, String note) {
        this.role = role;
        this.account = account;
        this.is_grant = is_grant;
        this.note = note;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Byte getIs_grant() {
        return is_grant;
    }

    public void setIs_grant(Byte is_grant) {
        this.is_grant = is_grant;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "GrantAccess{" +
                "role=" + role +
                ", account=" + account +
                ", is_grant=" + is_grant +
                ", note='" + note + '\'' +
                '}';
    }
}
