package com.example.entities;

import com.example.dtos.UserLoginDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")

//public boolean login(UserLoginDTO userLoginDTO);
//public boolean register(User user);
//public User selectUser(int id);
//public boolean updateUser(User user);
//public boolean deleteUser(int id);
@NamedQueries({
        @NamedQuery(name = "User.login", query = "select user from User user where user.username=:username and user.password=:password"),
        @NamedQuery(name = "User.deleteUser", query = "delete from User user where user.id = :id"),
})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, columnDefinition = "INT(3)")
    private int id;
    @Column(name = "first_name", nullable = false, columnDefinition = "VARCHAR(20)")
    private String firstname;
    @Column(name = "last_name", nullable = false, columnDefinition = "VARCHAR(20)")
    private String lastname;
    @Column(name = "username", nullable = false, columnDefinition = "VARCHAR(255)")
    private String username;
    @Column(name = "password", nullable = false, columnDefinition = "VARCHAR(20)")
    private String password;

    public User() {
    }

    public User(int id, String firstname, String lastname, String username, String password) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
