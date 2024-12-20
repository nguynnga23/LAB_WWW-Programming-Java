package com.example.services;

import com.example.models.Customer;

import java.util.List;

public interface CustomerService {
    void save(Customer customer);
    void update(Customer customer, Long id);
    void delete(Long id);
    Customer findById(Long id);
    List<Customer> findAll();
    List<Customer> findByYear(int year);
}
