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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDateTime getDob() {
        return dob;
    }

    public void setDob(LocalDateTime dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public EmployeeStatus getStatus() {
        return status;
    }

    public void setStatus(EmployeeStatus status) {
        this.status = status;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}