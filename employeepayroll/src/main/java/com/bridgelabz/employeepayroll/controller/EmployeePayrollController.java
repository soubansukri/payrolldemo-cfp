package com.bridgelabz.employeepayroll.controller;

import com.bridgelabz.employeepayroll.dto.EmployeePayrollDto;
import com.bridgelabz.employeepayroll.dto.ResponseDTO;
import com.bridgelabz.employeepayroll.entity.Employee;
import com.bridgelabz.employeepayroll.service.IEmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
public class EmployeePayrollController {
    @Autowired
    private IEmployeeService service;

    @RequestMapping(value ={"", "/","/get"})
    public ResponseEntity<ResponseDTO> getEmployeePayrollData(){
        List<Employee> empdatalist=null;
        empdatalist=service.getEmployee();
        ResponseDTO responseDTO=new ResponseDTO("Get Call Successful",empdatalist);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/get/{empId}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable("empId") int empId) {
        Employee empData=service.getEmpById(empId);
        ResponseDTO responseDTO=new ResponseDTO("Get Call For ID Successful",empData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/department/{department}")
    public  ResponseEntity<ResponseDTO>getEmployee(@PathVariable ("department") String department){
        List<Employee> employeeList=null;
        employeeList=service.getEmployeesByDepartment(department);
        ResponseDTO responseDTO=new ResponseDTO("Get call for Id successful",employeeList);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);

    }
    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addEmployeePayrollData(@Valid @RequestBody EmployeePayrollDto empPayrollDTO) {
        log.debug("Employee DTO:"+empPayrollDTO.toString());
        Employee empData=service.createEmployee(empPayrollDTO);
        ResponseDTO responseDTO=new ResponseDTO("Created Employee payroll data successfully",empData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @PutMapping("/update/{empId}")
    public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@Valid @PathVariable("empId") int empId ,@RequestBody EmployeePayrollDto empPayrollDTO){
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
