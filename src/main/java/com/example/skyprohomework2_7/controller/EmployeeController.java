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
    public Employee addNewEmployee(@RequestParam("name") String name,
                                   @RequestParam("patronymic") String patronymic,
                                   @RequestParam("surname") String surname,
                                   @RequestParam("salary") int salary,
                                   @RequestParam("department") int department) {
        return employeeService.addNewEmployee(name, patronymic, surname, salary, department);
    }

    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam("name") String name,
                                   @RequestParam("patronymic") String patronymic,
                                   @RequestParam("surname") String surname,
                                   @RequestParam("salary") int salary,
                                   @RequestParam("department") int department) {
        return employeeService.removeEmployee(name, patronymic, surname, salary, department);
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam("name") String name,
                                 @RequestParam("patronymic") String patronymic,
                                 @RequestParam("surname") String surname,
                                 @RequestParam("salary") int salary,
                                 @RequestParam("department") int department) {
        return employeeService.findEmployee(name, patronymic, surname, salary, department);
    }

    @GetMapping("/getAll")
    public Map<String, Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

}
