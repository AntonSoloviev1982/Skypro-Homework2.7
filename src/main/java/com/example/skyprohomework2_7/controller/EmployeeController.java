package com.example.skyprohomework2_7.controller;

import com.example.skyprohomework2_7.model.Employee;
import com.example.skyprohomework2_7.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee addNewEmployee(@RequestParam("fullName") String fullName,
                                   @RequestParam("salary") int salary) {
        return employeeService.addNewEmployee(fullName, salary);
    }

    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam("fullName") String fullName,
                                   @RequestParam("salary") int salary) {
        return employeeService.removeEmployee(fullName, salary);
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam("fullName") String fullName,
                                 @RequestParam("salary") int salary) {
        return employeeService.findEmployee(fullName, salary);
    }

    @GetMapping("/getAll")
    public Map<String, Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

}
