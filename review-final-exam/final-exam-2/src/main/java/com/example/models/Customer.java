package com.example.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cust_id", nullable = false)
    private Long id;
    @Column(name = "cust_dob")
    private LocalDate dob;
    @Column(name = "cust_name")
    private String name;
    @Column(name = "cust_add")
    private String address;
    @Column(name = "cust_email")
    private String email;

    @OneToMany(mappedBy = "customer")
    private List<Account> accounts;

}
