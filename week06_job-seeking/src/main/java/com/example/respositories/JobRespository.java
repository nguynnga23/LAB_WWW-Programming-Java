package com.example.respositories;

import com.example.entity.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class JobRespository {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void create(Job job){
        String SQL = "INSERT INTO job (description) VALUES (?)";
        jdbcTemplate.update(SQL, job.getDescription());
        System.out.println("Job created");
    }

    public Job findById(int id){
        String SQL = "SELECT * FROM job WHERE id = ?";
        Job job = jdbcTemplate.queryForObject(SQL, new Object[]{id}, new RowMapper<Job>() {
            @Override
            public Job mapRow(ResultSet rs, int rowNum) throws SQLException {
                Job job = new Job();
                job.setId(rs.getInt("id"));
                job.setDescription(rs.getString("description"));
                return job;
            }
        });
        return job;
    }

    public void update(Job job){
        String SQL = "UPDATE job SET description = ? WHERE id = ?";
        jdbcTemplate.update(SQL, job.getDescription(), job.getId());
        System.out.println("Job updated");
    }

    public void delete(int id){
        String SQL = "DELETE FROM job WHERE id = ?";
        jdbcTemplate.update(SQL, id);
        System.out.println("Job deleted");
    }
}
