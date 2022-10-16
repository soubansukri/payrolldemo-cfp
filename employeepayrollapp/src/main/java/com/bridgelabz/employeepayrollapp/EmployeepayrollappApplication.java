package com.bridgelabz.employeepayrollapp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class EmployeepayrollappApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeepayrollappApplication.class, args);
		log.info("Employee payroll app started");
	}

}
