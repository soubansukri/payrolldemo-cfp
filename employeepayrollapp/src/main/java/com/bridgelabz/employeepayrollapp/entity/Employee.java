package com.bridgelabz.employeepayrollapp.entity;

import com.bridgelabz.employeepayrollapp.dto.EmployeepayrollDto;

import javax.persistence.*;

@Entity
@Table(name="employee_payroll")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public String name;
    public long salary;

    public Employee(long id, EmployeepayrollDto employeepayrollDto) {
        this.id=getId();
        this.name=employeepayrollDto.getName();
        this.salary=employeepayrollDto.getSalary();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public Employee(long id, String name, long salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
