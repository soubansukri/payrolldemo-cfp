package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeepayrollDto;
import com.bridgelabz.employeepayrollapp.entity.Employee;
import com.bridgelabz.employeepayrollapp.repo.IEmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService{

    private final IEmployeeRepository repository;

    public EmployeeServiceImpl(IEmployeeRepository repository) {
        this.repository = repository;
    }

    private List<Employee> employeeList=new ArrayList<>();

    @Override
    public List<Employee> getEmployee() {
        return employeeList;

    }

    @Override
    public Employee getEmployeeById(int empId) {
        return employeeList.get(empId-1);
    }

    @Override
    public Employee createEmployee(EmployeepayrollDto employeepayrollDto) {
        Employee empData=null;
        empData=new Employee(1,employeepayrollDto);
        employeeList.add(empData);
        return empData;
    }



    @Override
    public Employee updateEmployee(int empId, EmployeepayrollDto employeepayrollDto) {
        Employee empData=this.getEmployeeById(empId);
        empData.setName(employeepayrollDto.name);
        empData.setSalary(employeepayrollDto.salary);
        employeeList.set(empId-1,empData);
        return empData;
    }

    @Override
    public void deleteEmployee(int empId) {
    employeeList.remove(empId-1);
    }

//    public Employee createEmployeePayrollData(EmployeepayrollDto employeepayrollDto);

}
