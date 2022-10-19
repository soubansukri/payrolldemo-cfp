package com.bridgelabz.employeepayroll.repository;

import com.bridgelabz.employeepayroll.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IEmployeeRepository extends JpaRepository<Employee,Integer> {
    @Query(value = "select * from employee_payroll,employee_department where employee_id=id and department=:department",nativeQuery = true)
    List<Employee> findEmployeesByDepartment(String department);
}
