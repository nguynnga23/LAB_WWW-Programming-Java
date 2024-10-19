package com.example.week03_web_sale.models;

import com.example.week03_web_sale.enums.EmployeeStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
@Table(name = "employee")
@NamedQueries({
        @NamedQuery(name = "Employee.findAll", query = "select e from Employee e")
})
public class Employee {
    @Id
    @Column(name = "employee_id", nullable = false)
    private Long id;
    @Column(name = "address", columnDefinition = "varchar(250)")
    private String address;
    @Column(name = "dob")
    private LocalDateTime dob;
    @Column(name = "email", columnDefinition = "varchar(150)")
    private String email;
    @Enumerated(EnumType.STRING)
    private EmployeeStatus status;
    @Column(name = "phone", columnDefinition = "varchar(15)")
    private String phone;
    @Column(name = "full_name", columnDefinition = "varchar(150)")
    private String fullname;
    @OneToMany(mappedBy = "employee")
    private List<Order> orders;
}