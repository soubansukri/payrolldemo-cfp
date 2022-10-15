package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeepayrollDto;
import com.bridgelabz.employeepayrollapp.entity.Employee;
import org.hibernate.validator.constraints.ModCheck;

import java.util.List;

public interface IEmployeeService {
List<Employee>getEmployee();

Employee getEmployeeById(long empId);

Employee createEmployee(EmployeepayrollDto employeepayrollDto);

Employee updateEmployee(long empId,EmployeepayrollDto employeepayrollDto);

void deleteEmployee(long empId);
}
