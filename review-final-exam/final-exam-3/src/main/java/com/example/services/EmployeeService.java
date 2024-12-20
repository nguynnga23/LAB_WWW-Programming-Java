package com.example.services;

import com.example.models.Employee;
import org.springframework.data.domain.Page;

import java.util.List;

public interface EmployeeService {
    public Employee findById(Long id);
    public List<Employee> findAll();
    public Page<Employee> findAllWithPaging(int pageNo, int pageSize, String sortBy, String sortDirection);
    public Employee save(Employee employee);
    public Employee update(Long id, Employee employee);
    public boolean delete(Long id);
    public List<Employee> search(String keyword);
}
