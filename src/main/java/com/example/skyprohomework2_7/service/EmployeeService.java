package com.example.skyprohomework2_7.service;

import com.example.skyprohomework2_7.exception.EmployeeAlreadyAddedException;
import com.example.skyprohomework2_7.exception.EmployeeNotFoundException;
import com.example.skyprohomework2_7.model.Employee;
import org.springframework.stereotype.Service;


import java.util.HashMap;
import java.util.Map;


@Service
public class EmployeeService {
    private Map<String, Employee> employees = new HashMap<>();

    public Employee addNewEmployee(String fullName, int salary) {
        Employee employee = new Employee(fullName, salary);
        if (!employees.containsKey(employee.getFullName())) {
            employees.put(employee.getFullName(), employee);
        } else {
            throw new EmployeeAlreadyAddedException("EmployeeAlreadyAdded");
        }
        return employee;
    }

    public Employee removeEmployee(String fullName, int salary) {
        Employee employee = new Employee(fullName, salary);
        if (employees.containsKey(employee.getFullName())) {
            employees.remove(employee.getFullName());
        } else {
            throw new EmployeeNotFoundException("EmployeeNotFound");
        }
        return employee;
    }

    public Employee findEmployee(String fullName, int salary) {
        Employee employee = new Employee(fullName, salary);
        if (!employees.containsKey(fullName)) {
            throw new EmployeeNotFoundException("EmployeeNotFound");
        }
        return employee;
    }

    public Map<String, Employee> getAllEmployees() {
        return employees;
    }

}
