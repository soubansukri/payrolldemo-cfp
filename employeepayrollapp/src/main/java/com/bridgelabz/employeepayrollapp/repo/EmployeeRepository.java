package com.bridgelabz.employeepayrollapp.repo;

import com.bridgelabz.employeepayrollapp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
