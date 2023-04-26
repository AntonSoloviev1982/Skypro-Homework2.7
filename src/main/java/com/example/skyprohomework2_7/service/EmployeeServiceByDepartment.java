package com.example.skyprohomework2_7.service;

import com.example.skyprohomework2_7.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceByDepartment {

    private final EmployeeService employeeService;

    public EmployeeServiceByDepartment(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public void increaseSalaryOnPercent(int percent) {
        employeeService.getEmployees().values().stream()
                .forEach(e -> e.setSalary(e.getSalary() * percent / 100 + e.getSalary()));
    }

    public Employee getEmployeeWithMinSalaryFromDepartment(int departmentId) {
        return employeeService.getEmployees().values().stream()
                .filter(e -> e.getDepartment() == departmentId)
                .min((x, y) -> x.getSalary() - y.getSalary()).get();
    }

    public Employee getEmployeeWithMaxSalaryFromDepartment(int departmentId) {
        return employeeService.getEmployees().values().stream()
                .filter(e -> e.getDepartment() == departmentId)
                .max((x, y) -> x.getSalary() - y.getSalary()).get();
    }

    public double getAmountOfSalaryByDepartment(int departmentId) {
        double sumSalary = employeeService.getEmployees().values().stream()
                .filter(e -> e.getDepartment() == departmentId)
                .mapToDouble(e -> e.getSalary()).sum();

        System.out.println("\nСумма затрат в отделе " + departmentId + " на зарплаты: " + sumSalary + " в месяц");
        return sumSalary;
    }

    public void getAverageSalaryByDepartment(int departmentId) {
        long countSalary = employeeService.getEmployees().values().stream()
                .filter(e -> e.getDepartment() == departmentId)
                .count();
        double sumSalary = getAmountOfSalaryByDepartment(departmentId);
        double averageSumOfSalaryByDepartment = sumSalary / countSalary;

        System.out.println("\nСредняя сумма затрат в отделе " + departmentId +
                " на зарплаты: " + averageSumOfSalaryByDepartment + " в месяц");
    }

    public void increaseSalaryOnPercentByDepartment(int departmentId, int percent) {
        employeeService.getEmployees().values().stream()
                .filter(e -> e.getDepartment() == departmentId)
                .forEach(e -> e.setSalary(e.getSalary() * percent / 100 + e.getSalary()));
    }

    public List<Employee> getAllEmployeesByDepartment(int departmentId) {
        return employeeService.getEmployees().values().stream()
                .filter(e -> e.getDepartment() == departmentId)
                .collect(Collectors.toList());
    }

    public void getSalaryLessThenNumber(double number) {
        employeeService.getEmployees().values().stream()
                .filter(e -> e.getSalary() < number)
                .forEach(e ->
                        System.out.println("ФИО: " + e.getSurname() + " " + e.getName() + " " + e.getPatronymic() +
                                ", зарплата: " + e.getSalary()));
    }

    public void getSalaryMoreOrEquallyThenNumber(double number) {
        employeeService.getEmployees().values().stream()
                .filter(e -> e.getSalary() >= number)
                .forEach(e ->
                        System.out.println("ФИО: " + e.getSurname() + " " + e.getName() + " " + e.getPatronymic() +
                                ", зарплата: " + e.getSalary()));
    }

    public Map<Integer, List<Employee>> getAllEmployeesByAllDepartment() {
        return employeeService.getEmployees().values().stream()
                .collect(Collectors.groupingBy(e -> e.getDepartment()));
    }
}
