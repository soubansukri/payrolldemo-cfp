package com.bridgelabz.employeepayroll.entity;

import com.bridgelabz.employeepayroll.dto.EmployeePayrollDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@NoArgsConstructor
public @Data class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    public String name;
    public long salary;
    public String gender;
    public LocalDate startDate;
    public String note;
    public String profilePic;
    @Column()
    @ElementCollection
    public List<String> departments;


    public Employee(int id, EmployeePayrollDto employeepayrollDto) {
        this.id=id;
        this.updateEmployee(employeepayrollDto);
    }

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
