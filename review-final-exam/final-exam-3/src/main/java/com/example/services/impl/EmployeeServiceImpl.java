package com.example.services.impl;

import com.example.exceptions.ItemNotFoundException;
import com.example.models.Employee;
import com.example.repositories.EmployeeRepository;
import com.example.services.EmployeeService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee findById(Long id) {
        return this.employeeRepository.findById(id).orElseThrow(()-> new ItemNotFoundException("Can not find Employee with id: " + id));
    }

    @Override
    public List<Employee> findAll() {
        return this.employeeRepository.findAll();
    }

    @Override
    public Page<Employee> findAllWithPaging(int pageNo, int pageSize, String sortBy, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name())?Sort.by(sortBy).ascending():Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        return this.employeeRepository.findAll(pageable);
    }

    @Transactional
    @Override
    public Employee save(Employee employee) {
        return this.employeeRepository.save(employee);
    }

    @Override
    public Employee update(Long id, Employee employee) {
        this.findById(id);
        return this.employeeRepository.save(employee);

    }

    @Override
    public boolean delete(Long id) {
        Employee employee = this.findById(id);
        this.employeeRepository.delete(employee);
        return true;
    }

    @Override
    public List<Employee> search(String keyword) {
        return this.employeeRepository.search(keyword);
    }
}
