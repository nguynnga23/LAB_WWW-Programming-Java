package com.example.week01_lab_nguyenthinga_21130791.respositories;

import com.example.week01_lab_nguyenthinga_21130791.entities.Role;

import java.util.List;

public interface RoleRepository {
    public List<Role> getRoles();
    public Role getRole(String id);
    public boolean addRole(Role role);
    public boolean removeRole(String id);
    public boolean updateRole(Role role);
}
