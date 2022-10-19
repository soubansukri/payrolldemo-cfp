package com.bridgelabz.employeepayroll.entity;

import com.bridgelabz.employeepayroll.dto.EmployeePayrollDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="employee_payroll")
@NoArgsConstructor
public @Data class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employee_id")
    private int empId;

    public String name;
    public long salary;
    public String gender;
    public LocalDate startDate;
    public String note;
    public String profilePic;
    @ElementCollection
    @CollectionTable(name = "employee_department",joinColumns = @JoinColumn(name="id"))
    @Column(name = "department")
    public List<String> departments;


    public Employee(EmployeePayrollDto employeepayrollDto) {
        this.updateEmployee(employeepayrollDto);
    }

//    public Employee(int empId, EmployeePayrollDto employeepayrollDto) {
//        this.empId=empId;
//    }

    public void updateEmployee(EmployeePayrollDto empPayrollDto){
        this.name=empPayrollDto.name;
        this.salary= empPayrollDto.salary;
        this.gender=empPayrollDto.gender;
        this.note= empPayrollDto.note;
        this.startDate=empPayrollDto.startDate;
        this.profilePic= empPayrollDto.profilePic;
        this.departments=empPayrollDto.departments;
    }

}
