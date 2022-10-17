package com.bridgelabz.employeepayroll.repository;

import com.bridgelabz.employeepayroll.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepository extends JpaRepository<Employee,Long> {
}
