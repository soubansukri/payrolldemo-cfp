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
        empdata=new Employee(2, new EmployeepayrollDto("abhishek",909887));
        ResponseDTO responseDTO=new ResponseDTO("Get Call For ID Successful",empdata);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @GetMapping ("/get/{empId}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable("empId") int empId) {
        Employee empData=null;
        empData=new Employee(empId,new EmployeepayrollDto("Pankaj",30000));
        ResponseDTO responseDTO=new ResponseDTO("Created Employee payroll data successfully",empData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addEmployeePayrollData(@RequestBody EmployeepayrollDto empPayrollDTO) {
        Employee empData=null;
        empData=new Employee(1,empPayrollDTO);
        ResponseDTO responseDTO=new ResponseDTO("Created Employee payroll data successfully",empData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@RequestBody EmployeepayrollDto empPayrollDTO){
        Employee empData=null;
        empData=new Employee(1,empPayrollDTO);
        ResponseDTO responseDTO=new ResponseDTO("Updated Employee payroll data successfully",empData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable("empId") int empId){
        ResponseDTO responseDTO=new ResponseDTO("Deleted successfully","Deleted Id:"+empId);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }



}
