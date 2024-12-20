package com.example.services;

import com.example.dtos.UserLoginDTO;
import com.example.entities.User;

public interface UserService {
    public boolean login(UserLoginDTO userLoginDTO);
    public boolean register(User user);
    public User selectUser(int id);
    public boolean updateUser(User user);
    public boolean deleteUser(int id);
}
