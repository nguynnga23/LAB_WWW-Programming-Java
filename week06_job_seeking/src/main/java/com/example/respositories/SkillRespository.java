package com.example.respositories;

import com.example.entity.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class SkillRespository {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void create(String skillName, String description, String field ){
        String SQL = "INSERT INTO skill (skill_name, description, field) VALUES (?, ?, ?)";
        jdbcTemplate.update(SQL, skillName, description, field);
        System.out.println("Skill created");
    }

    public Skill findById(int id) {
        String SQL = "SELECT * FROM skill WHERE id = ?";
        Skill skill = jdbcTemplate.queryForObject(SQL, new Object[]{id},
                (rs, rowNum) -> new Skill(rs.getInt("id"), rs.getString("skill_name"), rs.getString("description"), rs.getString("field")));
        return skill;
    }

    public void update(int id, String skillName, String description, String field) {
        String SQL = "UPDATE skill SET skill_name = ? description = ?, field = ? WHERE id = ?";
        jdbcTemplate.update(SQL, skillName, description, field, id);
        System.out.println("Updated Record with ID = " + id);
    }

    public void delete(int id) {
        String SQL = "DELETE FROM skill WHERE id = ?";
        jdbcTemplate.update(SQL, id);
        System.out.println("Deleted Record with ID = " + id);
    }
}
