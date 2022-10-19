package com.bridgelabz.employeepayroll.service;

import com.bridgelabz.employeepayroll.dto.EmployeePayrollDto;
import com.bridgelabz.employeepayroll.entity.Employee;
import com.bridgelabz.employeepayroll.exceptions.EmployeePayrollException;
import com.bridgelabz.employeepayroll.repository.IEmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class EmployeeServiceImpl implements IEmployeeService{

    @Autowired
    private final IEmployeeRepository repository;

    public EmployeeServiceImpl(IEmployeeRepository repository) {
        this.repository = repository;
    }

    public List<Employee> getEmployee(){
        return repository.findAll();
    }

    @Override
    public Employee getEmpById(int empId) {
        return repository.findById(empId).
                orElseThrow( () -> new EmployeePayrollException("Employee with employee Id"+empId+"does not exists.."));
    }


    @Override
    public Employee createEmployee(EmployeePayrollDto employeepayrollDto) {
        Employee empData=null;
        empData=new Employee(employeepayrollDto);
        log.debug("Emp Data:"+empData.toString());
        return repository.save(empData);
    }



    @Override
    public Employee updateEmployee(int empId, EmployeePayrollDto employeepayrollDto) {
        Employee empData=this.getEmpById(empId);
        empData.updateEmployee(employeepayrollDto);
        return repository.save(empData);
    }

    @Override
    public void deleteEmployee(int empId) {
        Employee empData=this.getEmpById(empId);
        repository.delete(empData);
    }
}
