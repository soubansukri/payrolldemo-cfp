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

    @Override
    public List<Employee> getEmployee() {
        List<Employee> employeePayRollList=new ArrayList<>();
        employeePayRollList.add(new Employee(1,new EmployeepayrollDto("Afzal",20000)));
        return employeePayRollList;

    }

    @Override
    public Employee getEmployeeById(long empId) {
        Employee empData=null;
        empData=new Employee(empId,new EmployeepayrollDto("Pankaj",30000));
        return empData;
    }

    @Override
    public Employee createEmployee(EmployeepayrollDto employeepayrollDto) {
        Employee empData=null;
        empData=new Employee(1,employeepayrollDto);
        return empData;
    }

    @Override
    public Employee updateEmployee(long empId, EmployeepayrollDto employeepayrollDto) {
        Employee empData=null;
        empData=new Employee(empId,employeepayrollDto);
        return null;
    }

    @Override
    public void deleteEmployee(long empId) {

    }

//    public Employee createEmployeePayrollData(EmployeepayrollDto employeepayrollDto);

}
