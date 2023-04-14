package com.example.skyprohomework2_7.model;


import java.util.Objects;

public class Employee {

    private String name;
    private String patronymic;
    private String surname;
    private int salary;
    private int department;

    public Employee() {
    }

    public Employee(String name, String patronymic, String surname, int salary, int department) {
        this.name = name;
        this.patronymic = patronymic;
        this.surname = surname;
        this.salary = salary;
        this.department = department;
    }

    public String getFullName(Employee employee) {
        return employee.getSurname() + " " + employee.getName() + " " + employee.getPatronymic();
    }

    public int getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getSurname() {
        return surname;
    }

    public int getDepartment() {
        return department;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return salary == employee.salary && department == employee.department && Objects.equals(name, employee.name) && Objects.equals(patronymic, employee.patronymic) && Objects.equals(surname, employee.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, patronymic, surname, salary, department);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", surname='" + surname + '\'' +
                ", salary=" + salary +
                ", department=" + department +
                '}';
    }
}
