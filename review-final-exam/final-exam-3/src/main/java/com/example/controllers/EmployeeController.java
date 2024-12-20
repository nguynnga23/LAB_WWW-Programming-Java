package com.example.controllers;

import com.example.models.Employee;
import com.example.services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Map<String, Object> response = new LinkedHashMap<String, Object>();
        response.put("status", HttpStatus.OK.value());
        response.put("data", employeeService.findById(id));
        return ResponseEntity.status(HttpStatus.OK).body((Employee) response);
    }

    @PostMapping("/employees")
    public ResponseEntity<Map<String, Object>> saveEmployee(@Valid @RequestBody Employee employee, BindingResult bindingResult) {
        Map<String, Object> response = new LinkedHashMap<String, Object>();
        if (bindingResult.hasErrors()) {
            Map<String, Object> errors = new LinkedHashMap<String, Object>();
            bindingResult.getFieldErrors().forEach(result -> {
                errors.put(result.getField(), result.getDefaultMessage());
            });
            System.out.println(bindingResult);
            response.put("status", HttpStatus.BAD_REQUEST.value());
            response.put("errors", errors);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        } else {
            response.put("status", HttpStatus.OK.value());
            response.put("data", employeeService.save(employee));
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
    }

    public ResponseEntity<Map<String, Object>> updateEmployee(@PathVariable Long id, @Valid @RequestBody Employee
            employee, BindingResult bindingResult) {
        Map<String, Object> response = new LinkedHashMap<String, Object>();
        if (bindingResult.hasErrors()) {
            Map<String, Object> errors = new LinkedHashMap<String, Object>();
            bindingResult.getFieldErrors().stream().forEach(result -> {
                errors.put(result.getField(), result.getDefaultMessage());
            });
            response.put("status", HttpStatus.BAD_REQUEST.value());
            response.put("errors", errors);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        } else {
            response.put("status", HttpStatus.OK.value());
            response.put("data", employeeService.update(id, employee));
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Map<String, Object>> deleteEmployee(@PathVariable Long id) {
        Map<String, Object> response = new LinkedHashMap<String, Object>();
        response.put("status", HttpStatus.OK.value());
        response.put("data", employeeService.delete(id));
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/employees")
    public ResponseEntity<Map<String, Object>> getEmployees(@RequestParam(required = false) String keyword) {
        Map<String, Object> response = new LinkedHashMap<String, Object>();
        response.put("status", HttpStatus.OK.value());
        if (keyword == null || keyword.isEmpty()) {
            response.put("data", employeeService.findAll());
        } else {
            response.put("data", employeeService.search(keyword));
        }
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}

