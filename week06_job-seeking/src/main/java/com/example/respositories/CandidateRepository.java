package com.example.respositories;

import com.example.entity.Candidate;
import com.example.entity.Job;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class CandidateRepository {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void create(Candidate candidate){
        String SQL = "INSERT INTO candidate (last_name, middle_name, first_name, dob, email, address, phone) VALUES (?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(SQL, candidate.getLastName(), candidate.getMiddleName(), candidate.getFirstName(), candidate.getDob(), candidate.getEmail(), candidate.getAddress(), candidate.getPhone());
        System.out.println("Candidate created");
    }

    public Candidate findById(int id){
        String SQL = "SELECT * FROM candidate WHERE id = ?";
        Candidate candidate = jdbcTemplate.queryForObject(SQL, new Object[]{id}, new RowMapper<Candidate>() {
            @Override
            public Candidate mapRow(ResultSet rs, int rowNum) throws SQLException {
                Candidate candidate = new Candidate();
                candidate.setId(rs.getInt("id"));
                candidate.setLastName(rs.getString("last_name"));
                candidate.setMiddleName(rs.getString("middle_name"));
                candidate.setFirstName(rs.getString("first_name"));
                candidate.setDob(rs.getDate("dob"));
                candidate.setEmail(rs.getString("email"));
                candidate.setAddress(rs.getString("address"));
                candidate.setPhone(rs.getString("phone"));
                return candidate;
            }
        });
        return candidate;
    }

    public void update(Candidate candidate){
        String SQL = "UPDATE candidate SET last_name = ?, middle_name = ?, first_name = ?, dob = ?, email = ?, address = ?, phone = ? WHERE id = ?";
        jdbcTemplate.update(SQL, candidate.getLastName(), candidate.getMiddleName(), candidate.getFirstName(), candidate.getDob(), candidate.getEmail(), candidate.getAddress(), candidate.getPhone(), candidate.getId());
        System.out.println("Candidate updated");
    }

    public void delete(int id){
        String SQL = "DELETE FROM candidate WHERE id = ?";
        jdbcTemplate.update(SQL, id);
        System.out.println("Candidate deleted");
    }

}
