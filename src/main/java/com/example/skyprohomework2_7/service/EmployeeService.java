package com.example.skyprohomework2_7.service;

import com.example.skyprohomework2_7.exception.EmployeeAlreadyAddedException;
import com.example.skyprohomework2_7.exception.EmployeeNotFoundException;
import com.example.skyprohomework2_7.model.Employee;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;


import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


@Service
public class EmployeeService {
    private final Map<String, Employee> employees = new HashMap<>();

    public Map<String, Employee> getEmployees() {
        return employees;
    }


    public Employee addNewEmployee(String name, String patronymic, String surname, int salary, int department) {
        Employee employee = new Employee(name, patronymic, surname, salary, department);
        if (!employees.containsKey(employee.getFullName(employee))) {
            employees.put(employee.getFullName(employee), employee);
        } else {
            throw new EmployeeAlreadyAddedException("EmployeeAlreadyAdded");
        }
        return employee;
    }

    public Employee removeEmployee(String name, String patronymic, String surname, int salary, int department) {
        Employee employee = new Employee(name, patronymic, surname, salary, department);
        if (employees.containsKey(employee.getFullName(employee))) {
            employees.remove(employee.getFullName(employee));
        } else {
            throw new EmployeeNotFoundException("EmployeeNotFound");
        }
        return employee;
    }

    public Employee findEmployee(String name, String patronymic, String surname, int salary, int department) {
        Employee employee = new Employee(name, patronymic, surname, salary, department);
        if (!employees.containsKey(employee.getFullName(employee))) {
            throw new EmployeeNotFoundException("EmployeeNotFound");
        }
        return employee;
    }

    public Map<String, Employee> getAllEmployees() {
        return Collections.unmodifiableMap(employees);
    }



}
