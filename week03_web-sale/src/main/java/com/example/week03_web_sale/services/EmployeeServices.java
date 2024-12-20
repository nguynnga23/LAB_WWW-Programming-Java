package com.example.week03_web_sale.services;

import com.example.week03_web_sale.enums.EmployeeStatus;
import com.example.week03_web_sale.models.Employee;
import com.example.week03_web_sale.repositories.EmployeeRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class EmployeeServices {
    private static EmployeeRepository employeeRepository;
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
            employeeToDelete.setStatus(EmployeeStatus.TERMINATED);
            return true;
        }
        return false;
    }

    public boolean activeEmp(long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            Employee employeeToActivate = employee.get();
            employeeToActivate.setStatus(EmployeeStatus.ACTIVE);
            return true;
        }
        return false;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public static void main(String[] args) {
        employeeRepository = new EmployeeRepository();
        Employee employee = new Employee();
        employee.setId(2L);
        employee.setDob(LocalDateTime.now());
        employee.setStatus(EmployeeStatus.ACTIVE);
        employee.setAddress("Viet Nam");
        employee.setEmail("email@email.com");
        employee.setFullname("Nguyen Thi Nga");
        employee.setPhone("0774554515");
//        employeeRepository.insertEmployee(employee);
        System.err.println(employeeRepository.findById(1L));
    }
}
