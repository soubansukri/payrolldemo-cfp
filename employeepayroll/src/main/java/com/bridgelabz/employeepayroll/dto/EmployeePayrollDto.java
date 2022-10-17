package com.bridgelabz.employeepayroll.dto;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public @Data class EmployeePayrollDto {

    @NotEmpty
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$")
    public String name;
    @Min(value=500,message = "Employee name invalid")
    public long salary;

    public EmployeePayrollDto(String name, long salary) {
        this.name = name;
        this.salary = salary;
    }
}