package com.example.week03_web_sale.models;

import com.example.week03_web_sale.enums.EmployeeStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @Column(name = "cust_id", nullable = false)
    private Long id;

    @Column(name = "address", columnDefinition = "varchar(250)")
    private String address;
    @Column(name = "email", columnDefinition = "varchar(150)")
    private String email;
    @Column(name = "phone", columnDefinition = "varchar(15)")
    private String phone;
    @Column(name = "cust_name", columnDefinition = "varchar(150)")
    private String name;
    @OneToMany(mappedBy = "customer")
    private List<Order> orders;
}