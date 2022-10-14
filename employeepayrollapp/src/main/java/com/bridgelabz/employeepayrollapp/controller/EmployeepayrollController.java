package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmployeepayrollDto;
import com.bridgelabz.employeepayrollapp.dto.ResponseDTO;
import com.bridgelabz.employeepayrollapp.entity.Employee;
import com.bridgelabz.employeepayrollapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class EmployeepayrollController {

    @Autowired
    private EmployeeService service;

    @RequestMapping(value ={"", "/","/get"})
    public ResponseEntity<ResponseDTO>getEmployeePayrollData(){
        Employee empdata=null;
        empdata=new Employee(1, new EmployeepayrollDto("abhishek",909887));
        ResponseDTO responseDTO=new ResponseDTO("Get Call For ID Successful",empdata);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }



    @GetMapping ("/get/{empId}")
    public ResponseEntity<String> getEmployeePayrollData(@PathVariable("empId") int empId) {
        return new ResponseEntity<String>("Get Call Success for id:" + empId, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<String> addEmployeePayrollData(@RequestBody EmployeepayrollDto empPayrollDTO) {
        return new ResponseEntity<String>("Created Employee Payroll Data for : " + empPayrollDTO, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateEmployeePayrollData(@RequestBody EmployeepayrollDto empPayrollDTO){
        return new ResponseEntity<String>("Updated Employee Payroll Data for:"+ empPayrollDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<String> deleteEmployeePayrollData(@PathVariable("empId") int empId){
        return new ResponseEntity<String>("Delete call success for id:"+ empId, HttpStatus.OK);
    }



}
