package com.sonu.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sonu.dto.LoginRequest;
import com.sonu.dto.ResponseMessage;
import com.sonu.model.GoogleEmployeeDetails;
import com.sonu.service.EmployeeInfoService;

@RestController
@Validated
@RequestMapping("/googleEmpDetails")
public class GoogleController {

	@Autowired
	private EmployeeInfoService googleEmployeeService;

	@PostMapping("/save")
	public GoogleEmployeeDetails saveNewEmp(@Valid @RequestBody GoogleEmployeeDetails googleEmployeeDetails) {

		return googleEmployeeService.saveNewEmp(googleEmployeeDetails);
	}

	@GetMapping("/getAll")
	public List<GoogleEmployeeDetails> getAllEmployees() {
		return googleEmployeeService.getAllEmployees();
	}

	@GetMapping("/getById/{empId}")
	public Optional<GoogleEmployeeDetails> getEmployeeById(@PathVariable int empId) {
		return googleEmployeeService.getEmployeeById(empId);
	}

	@GetMapping("/getByCriteria")
	public List<GoogleEmployeeDetails> getEmployeesByCriteria(@RequestParam(required = false) Long empId,
			@RequestParam(required = false) String name, @RequestParam(required = false) String deptartment) {
		List<GoogleEmployeeDetails> employees = googleEmployeeService.getEmployeesByCriteria(empId, name, deptartment);
		return employees;
	}

	@PutMapping("/update/{empId}")
	public GoogleEmployeeDetails updateEmp(@PathVariable int empId,
			@RequestBody GoogleEmployeeDetails googleEmployeeDetails) {

		googleEmployeeDetails.setEmpId(empId);
		return googleEmployeeService.updateEmp(googleEmployeeDetails);
	}

	@PostMapping("/login")
	public Optional<ResponseMessage> login(@RequestBody LoginRequest loginRequest) {
		return googleEmployeeService.login(loginRequest.getId(), loginRequest.getName(), loginRequest.getPassword());
	}

}
