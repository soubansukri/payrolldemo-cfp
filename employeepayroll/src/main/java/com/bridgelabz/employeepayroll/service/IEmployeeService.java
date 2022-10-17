package com.bridgelabz.employeepayroll.service;

import com.bridgelabz.employeepayroll.dto.EmployeePayrollDto;
import com.bridgelabz.employeepayroll.entity.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> getEmployee();

    Employee getEmployeeById(int empId);

    Employee createEmployee(EmployeePayrollDto employeepayrollDto);

    Employee updateEmployee(int empId,EmployeePayrollDto employeepayrollDto);

    void deleteEmployee(int empId);
}
