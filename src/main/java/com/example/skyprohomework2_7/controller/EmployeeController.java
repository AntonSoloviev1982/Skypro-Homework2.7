package com.example.skyprohomework2_7.controller;

import com.example.skyprohomework2_7.exception.EmployeeIllegalArgumentException;
import com.example.skyprohomework2_7.model.Employee;
import com.example.skyprohomework2_7.service.EmployeeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;


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
        if(StringUtils.isAlpha(name) && StringUtils.isAlpha(patronymic) && StringUtils.isAlpha(surname)) {
            String regEx = "[A-ZА-Я]\\w*";
            if (!name.matches(regEx)) {
                name = StringUtils.replaceChars(name, name.charAt(0)
                        , Character.toUpperCase(name.charAt(0)));
            }
            if (!patronymic.matches(regEx)) {
                patronymic = StringUtils.replaceChars(patronymic, patronymic.charAt(0)
                        , Character.toUpperCase(patronymic.charAt(0)));
            }
            if (!surname.matches(regEx)) {
                surname = StringUtils.replaceChars(surname, surname.charAt(0)
                        , Character.toUpperCase(surname.charAt(0)));
            }
            return employeeService.addNewEmployee(name, patronymic, surname, salary, department);
        } else {
            throw new EmployeeIllegalArgumentException();
        }
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
