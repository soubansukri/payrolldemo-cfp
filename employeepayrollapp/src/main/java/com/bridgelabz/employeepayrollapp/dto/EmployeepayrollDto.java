package com.bridgelabz.employeepayrollapp.dto;

public class EmployeepayrollDto {
    public String name;
    public long salary;

    public EmployeepayrollDto(String name, long salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "name=" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
