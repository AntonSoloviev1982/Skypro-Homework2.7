package com.example.skyprohomework2_7.service;

import com.example.skyprohomework2_7.model.Employee;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;

@Service
public class EmployeeServiceByDepartment {

    private final EmployeeService employeeService;

    public EmployeeServiceByDepartment(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public void increaseSalaryOnPercent(int percent) {
        System.out.println();
        employeeService.getEmployees().values().stream()
                .forEach(e -> e.setSalary(e.getSalary() * percent / 100 + e.getSalary()));
    }

    public Employee getEmployeeWithMinSalaryFromDepartment(int departmentId) {
        Optional<Employee> employee = employeeService.getEmployees().values().stream()
                .filter(e -> e.getDepartment() == departmentId)
                .min((x, y) -> x.getSalary() - y.getSalary());
        return employee;
    }

    public void getEmployeeWithMaxSalaryFromDepartment(int departmentId) {
        Optional<Employee> employee = employeeService.getEmployees().values().stream()
                .filter(e -> e.getDepartment() == departmentId)
                .max((x, y) -> x.getSalary() - y.getSalary());
        System.out.println("\nСотрудник - " + employee.get().getSurname() + " " + employee.get().getName() +
                " из отдела " + employee.get().getDepartment() + ", получает самую большую зарплату: "
                + employee.get().getSalary());
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

    public void getAllEmployeesByDepartment(int departmentId) {
        System.out.println();
        System.out.println("\nОтдел: " + departmentId);
        employeeService.getEmployees().values().stream()
                .filter(e -> e.getDepartment() == departmentId)
                .forEach(e ->
                        System.out.println("ФИО: " + e.getSurname() + " " + e.getName() + " "
                                + e.getPatronymic() + ", зарплата: " + e.getSalary()));
    }

    public void getSalaryLessThenNumber(double number) {
        System.out.println();
        employeeService.getEmployees().values().stream()
                .filter(e -> e.getSalary() < number)
                .forEach(e ->
                        System.out.println("ФИО: " + e.getSurname() + " " + e.getName() + " " + e.getPatronymic() +
                                ", зарплата: " + e.getSalary()));
    }

    public void getSalaryMoreOrEquallyThenNumber(double number) {
        System.out.println();
        employeeService.getEmployees().values().stream()
                .filter(e -> e.getSalary() >= number)
                .forEach(e ->
                        System.out.println("ФИО: " + e.getSurname() + " " + e.getName() + " " + e.getPatronymic() +
                                ", зарплата: " + e.getSalary()));
    }

    public void getAllEmployeesByAllDepartment() {
        int[] allDepartments = new int[10];
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                allDepartments[i] = employees[i].getDepartment();
            }
        }
//
        int[] uniqueDepartments = Arrays.stream(allDepartments).distinct().toArray();
        Arrays.sort(uniqueDepartments);

        for (int i = 0; i < uniqueDepartments.length; i++) {
            if (uniqueDepartments[i] != 0) {
                System.out.println("\nОтдел " + uniqueDepartments[i]);
                for (Employee emp : employees) {
                    if (emp != null) {
                        if (uniqueDepartments[i] == emp.getDepartment()) {
                            System.out.println("ФИО: " + emp.getSurname() + " " + emp.getName() + " " + emp.getPatronymic());
                        }
                    }
                }
            }
        }
    }
}
