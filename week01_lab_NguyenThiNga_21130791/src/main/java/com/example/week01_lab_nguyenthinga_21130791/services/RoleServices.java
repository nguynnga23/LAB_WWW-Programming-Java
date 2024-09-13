package com.example.week01_lab_nguyenthinga_21130791.services;

import com.example.week01_lab_nguyenthinga_21130791.entities.Account;
import com.example.week01_lab_nguyenthinga_21130791.entities.Role;
import com.example.week01_lab_nguyenthinga_21130791.respositories.RoleRepository;
import com.example.week01_lab_nguyenthinga_21130791.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoleServices implements RoleRepository {
    private static final String SELECT_ALL_ROLES = "SELECT * FROM role";
    private static final String SELECT_ROLE_BY_ID = "SELECT * FROM role WHERE id = ?";
    private static final String ADD_ROLE = "INSERT INTO role (role_id, role_name, description, status) VALUES (?, ?, ?, ?)";
    private static final String DELETE_ROLE = "DELETE FROM role WHERE role_id = ?";
    private static final String UPDATE_ROLE = "UPDATE role SET role_id = ?, role_name = ?, description = ?, status = ? WHERE role_id = ?";
    @Override
    public List<Role> getRoles() {
        List<Role> roles = new ArrayList<>();
        try(Connection connection = JDBCUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ROLES);){
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                String roleId = resultSet.getString("role_id");
                String roleName = resultSet.getString("role_name");
                String description = resultSet.getString("description");
                Byte status = resultSet.getByte("status");
                roles.add(new Role(roleId, status, roleName, description));
            }
        }catch (SQLException e){
            JDBCUtils.printSQLException(e);
        }
        return roles;
    }

    @Override
    public Role getRole(String id) {
        Role role = null;
        try(Connection connection = JDBCUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ROLE_BY_ID);) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                String roleId = resultSet.getString("role_id");
                String roleName = resultSet.getString("role_name");
                String description = resultSet.getString("description");
                Byte status = resultSet.getByte("status");
                role = new Role(roleId, status, roleName, description);
            }
        } catch (SQLException e) {
            JDBCUtils.printSQLException(e);
        }
        return role;
    }

    @Override
    public boolean addRole(Role role) {
        int result = 0;
        try (Connection connection = JDBCUtils.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(ADD_ROLE)){
            preparedStatement.setString(1, role.getRoleId());
            preparedStatement.setString(2, role.getRoleName());
            preparedStatement.setString(3, role.getDescription());
            preparedStatement.setByte(4, role.getStatus());
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result > 0;
    }

    @Override
    public boolean removeRole(String id) {
        boolean rowDeleted = false;

        try (Connection connection = JDBCUtils.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ROLE)){

            preparedStatement.setString(1, id);

            rowDeleted = preparedStatement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rowDeleted;
    }

    @Override
    public boolean updateRole(Role role) {
        int result = 0;
        try (Connection connection = JDBCUtils.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ROLE)){
            preparedStatement.setString(1, role.getRoleId());
            preparedStatement.setString(2, role.getRoleName());
            preparedStatement.setString(3, role.getDescription());
            preparedStatement.setByte(4, role.getStatus());
            preparedStatement.setString(5, role.getRoleId());
            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result > 0;
    }

    public static void main(String[] args) {
        RoleServices roleService = new RoleServices();
        List<Role> roles = roleService.getRoles();
        Role role = new Role("other", Byte.parseByte("1"), "other role", "other");
        System.out.println(roleService.removeRole("other"));
    }
}


