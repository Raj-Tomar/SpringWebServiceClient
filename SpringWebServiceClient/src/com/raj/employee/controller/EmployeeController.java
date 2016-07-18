package com.raj.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.raj.employee.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService empService;
}
