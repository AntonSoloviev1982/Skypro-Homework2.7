package com.example.skyprohomework2_7.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.skyprohomework25.service.Employee;
import pro.sky.skyprohomework25.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee addNewEmployee(@RequestParam("firstName") String firstName,
                                   @RequestParam("lastName") String lastName) {
        return employeeService.addNewEmployee(firstName, lastName);
    }

    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam("firstName") String firstName,
                                   @RequestParam("lastName") String lastName) {
        return employeeService.removeEmployee(firstName, lastName);
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam("firstName") String firstName,
                                   @RequestParam("lastName") String lastName) {
        return employeeService.findEmployee(firstName, lastName);
    }

    @GetMapping("/getAll")
    public List<Employee> getAllEmployees() {
        List<Employee> allEmployees = employeeService.getAllEmployees();
        return allEmployees;
    }


}
