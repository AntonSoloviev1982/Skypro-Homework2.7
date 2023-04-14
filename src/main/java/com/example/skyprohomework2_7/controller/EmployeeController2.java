package com.example.skyprohomework2_7.controller;

import com.example.skyprohomework2_7.model.Employee;
import com.example.skyprohomework2_7.service.EmployeeServiceByDepartment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employee/departments")
public class EmployeeController2 {

    private final EmployeeServiceByDepartment serviceByDepartment;

    public EmployeeController2(EmployeeServiceByDepartment serviceByDepartment) {
        this.serviceByDepartment = serviceByDepartment;
    }

    @GetMapping("max-salary")
    public Employee getEmployeeWithMaxSalaryFromDepartment(@RequestParam("departmentId") int departmentId) {

    }

    @GetMapping("min-salary")
    public Employee getEmployeeWithMinSalaryFromDepartment(@RequestParam("departmentId") int departmentId) {

    }

    @GetMapping("all")
    public List<Employee> getAllEmployeesByDepartment(@RequestParam("departmentId") int departmentId) {

    }

    @GetMapping("all")
    public Map<Integer, List<Employee>> getAllEmployeesByAllDepartment() {

    }


}
