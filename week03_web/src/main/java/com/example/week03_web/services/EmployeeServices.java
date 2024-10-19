package com.example.week03_web_sale.services;

import com.example.week03_web_sale.enums.EmployeeStatus;
import com.example.week03_web_sale.models.Employee;
import com.example.week03_web_sale.repositories.EmployeeRepository;

import java.util.List;
import java.util.Optional;

public class EmployeeServices {
    private EmployeeRepository employeeRepository;
    public EmployeeServices() {
        employeeRepository = new EmployeeRepository();
    }

    public void insertEmployee(Employee employee) {
        employeeRepository.insertEmployee(employee);
    }

    public Optional<Employee> getEmployeeById(long id) {
        return employeeRepository.findById(id);
    }

    public boolean delete(long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            Employee employeeToDelete = employee.get();
//            employeeToDelete.setStatus(EmployeeStatus.TERMINATED);
            return true;
        }
        return false;
    }

    public boolean activeEmp(long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            Employee employeeToActivate = employee.get();
//            employeeToActivate.setStatus(EmployeeStatus.ACTIVE);
            return true;
        }
        return false;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

}
