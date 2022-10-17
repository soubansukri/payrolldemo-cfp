package com.bridgelabz.employeepayroll.service;

import com.bridgelabz.employeepayroll.EmployeepayrollApplication;
import com.bridgelabz.employeepayroll.dto.EmployeePayrollDto;
import com.bridgelabz.employeepayroll.entity.Employee;
import com.bridgelabz.employeepayroll.exceptions.EmployeePayrollException;
import com.bridgelabz.employeepayroll.repository.IEmployeeRepository;
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
        return employeeList.stream().filter(empData -> empData.getId()==empId)
                .findFirst().orElseThrow(()->new EmployeePayrollException("Employee not found"));
    }

    @Override
    public Employee createEmployee(EmployeePayrollDto employeepayrollDto) {
        Employee empData=null;
        empData=new Employee(1,employeepayrollDto);
        employeeList.add(empData);
        return empData;
    }



    @Override
    public Employee updateEmployee(int empId, EmployeePayrollDto employeepayrollDto) {
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
}
