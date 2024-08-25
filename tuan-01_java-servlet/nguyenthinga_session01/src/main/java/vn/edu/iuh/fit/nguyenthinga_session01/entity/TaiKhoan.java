package vn.edu.iuh.fit.nguyenthinga_session01.entity;

import java.util.Objects;

public class TaiKhoan {
    private String userName;
    private String password;

    public TaiKhoan() {
    }

    public TaiKhoan(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaiKhoan taiKhoan = (TaiKhoan) o;
        return Objects.equals(userName, taiKhoan.userName) && Objects.equals(password, taiKhoan.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, password);
    }

    @Override
    public String toString() {
        return "TaiKhoan{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
