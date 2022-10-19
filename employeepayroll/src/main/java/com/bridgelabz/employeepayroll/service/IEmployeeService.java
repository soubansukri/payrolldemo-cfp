package com.bridgelabz.employeepayroll.service;

import com.bridgelabz.employeepayroll.dto.EmployeePayrollDto;
import com.bridgelabz.employeepayroll.entity.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> getEmployee();

    Employee getEmpById(int empId);

    List<Employee>getEmployeesByDepartment(String department);

    Employee createEmployee(EmployeePayrollDto employeepayrollDto);

    Employee updateEmployee(int empId, EmployeePayrollDto employeepayrollDto);

    void deleteEmployee(int empId);
}
