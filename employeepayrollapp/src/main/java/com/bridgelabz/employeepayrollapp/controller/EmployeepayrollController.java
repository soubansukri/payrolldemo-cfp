package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmployeepayrollDto;
import com.bridgelabz.employeepayrollapp.dto.ResponseDTO;
import com.bridgelabz.employeepayrollapp.entity.Employee;
import com.bridgelabz.employeepayrollapp.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class EmployeepayrollController {

    @Autowired
    private IEmployeeService service;

    @RequestMapping(value ={"", "/","/get"})
    public ResponseEntity<ResponseDTO>getEmployeePayrollData(){
        List<Employee>empdatalist=null;
        empdatalist=service.getEmployee();
        ResponseDTO responseDTO=new ResponseDTO("Get Call Successful",empdatalist);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @GetMapping ("/get/{empId}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable("empId") int empId) {
        Employee empData=service.getEmployeeById(empId);
        ResponseDTO responseDTO=new ResponseDTO("Get Call For ID Successful",empData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addEmployeePayrollData(@RequestBody EmployeepayrollDto empPayrollDTO) {
        Employee empData=service.createEmployee(empPayrollDTO);
        ResponseDTO responseDTO=new ResponseDTO("Created Employee payroll data successfully",empData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @PutMapping("/update/{empId}")
    public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@PathVariable("empId") int empId ,@RequestBody EmployeepayrollDto empPayrollDTO){
        Employee empData=service.updateEmployee(empId,empPayrollDTO);
        ResponseDTO responseDTO=new ResponseDTO("Updated Employee payroll data successfully",empData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable("empId") int empId){
        service.deleteEmployee(empId);
        ResponseDTO responseDTO=new ResponseDTO("Deleted successfully","Deleted Id:"+empId);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }



}
