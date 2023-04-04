package com.example.skyprohomework2_7.service;

import com.example.skyprohomework2_7.exception.EmployeeAlreadyAddedException;
import com.example.skyprohomework2_7.exception.EmployeeNotFoundException;
import com.example.skyprohomework2_7.model.Employee;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;



@Service
public class EmployeeService {
    private List<Employee> employees = new ArrayList<>(List.of(
            new Employee("Иван", "Иванов"),
            new Employee("Сергей", "Сергеев"),
            new Employee("Петр", "Петров")));

    public Employee addNewEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        isEmployeeAdded(employee);
        employees.add(employee);
        return employee;
    }

    public Employee removeEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        checkEmployee(employee);
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).equals(employee)) {
                employees.remove(employee);
            }
        }
        return employee;
    }

    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        checkEmployee(employee);
        return employee;
    }

    public List<Employee> getAllEmployees() {
        return employees;
    }


    public void isEmployeeAdded(Employee employee) {
            if (employees.contains(employee)) {
                throw new EmployeeAlreadyAddedException("EmployeeAlreadyAdded");
        }
    }

    public void checkEmployee(Employee employee) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).equals(employee)) {
                return;
            }
            throw new EmployeeNotFoundException("EmployeeNotFound");
        }
    }

}
