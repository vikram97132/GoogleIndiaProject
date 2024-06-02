package com.sonu.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sonu.dto.ResponseMessage;
import com.sonu.model.GoogleEmployeeDetails;
import com.sonu.repository.GoogleEmployeeInfoRepository;
import com.sonu.repository.GoogleEmployeeRepository;

@Service
public class EmployeeInfoService {

	@Autowired
	private GoogleEmployeeRepository googleEmployeeRepository;

	@Autowired
	private GoogleEmployeeInfoRepository googleEmployeeInfoRepository;

	public GoogleEmployeeDetails saveNewEmp(GoogleEmployeeDetails googleEmployeeDetails) {

		List<GoogleEmployeeDetails> allEmployees = googleEmployeeRepository.findAll();

		boolean isDuplicateEmpId = allEmployees.stream()
				.anyMatch(employee -> employee.getEmpId() == googleEmployeeDetails.getEmpId());
		if (isDuplicateEmpId) {
			throw new IllegalArgumentException("Employee ID Already Exists :" + googleEmployeeDetails.getEmpId());
		}

		boolean isDuplicateMobile = allEmployees.stream()
				.anyMatch(employee -> employee.getMobile() == googleEmployeeDetails.getMobile());
		if (isDuplicateMobile) {
			throw new IllegalArgumentException(
					"Employee Mobile No. Already Exists :" + googleEmployeeDetails.getMobile());
		}

		boolean isDuplicateEmail = allEmployees.stream()
				.anyMatch(employee -> employee.getEmail().equals(googleEmployeeDetails.getEmail()));
		if (isDuplicateEmail) {
			throw new IllegalArgumentException("Employee E-mail Already Exists : " + googleEmployeeDetails.getEmail());
		}

		return googleEmployeeRepository.save(googleEmployeeDetails);
	}

//	public Optional<GoogleEmployeeDetails> getEmployeeDetailsWithInfo(int empId) {
//		Optional<GoogleEmployeeDetails> employeeDetails = googleEmployeeRepository.findById(empId);
//		if (employeeDetails.isPresent()) {
//			GoogleEmployeeDetails details = employeeDetails.get();
//			List<GoogleEmpInfo> infos = googleEmployeeInfoRepository.findByGoogleEmployeeDetails(details);
//			details.setEmployeeInfos(new LinkedHashSet<>(infos));
//		}
//		return employeeDetails;
//	}

	public List<GoogleEmployeeDetails> getAllEmployees() {

		return googleEmployeeRepository.findAll();

	}

	public Optional<GoogleEmployeeDetails> getEmployeeById(int empId) {
		return googleEmployeeRepository.findById(empId);
	}

	public List<GoogleEmployeeDetails> getEmployeesByCriteria(Long empId, String name, String department) {
		return googleEmployeeRepository.findByCriteria(empId, name, department);
	}

	public GoogleEmployeeDetails updateEmp(GoogleEmployeeDetails googleEmployeeDetails) {
		Optional<GoogleEmployeeDetails> existingEmpOpt = googleEmployeeRepository
				.findById(googleEmployeeDetails.getEmpId());

		if (existingEmpOpt.isPresent()) {
			GoogleEmployeeDetails existingEmp = existingEmpOpt.get();

			existingEmp.setEmpName(googleEmployeeDetails.getEmpName());
			existingEmp.setAddress(googleEmployeeDetails.getAddress());
			existingEmp.setGender(googleEmployeeDetails.getGender());
			existingEmp.setDeptartment(googleEmployeeDetails.getDeptartment());
			existingEmp.setJoiningYear(googleEmployeeDetails.getJoiningYear());
			existingEmp.setEmail(googleEmployeeDetails.getEmail());
			existingEmp.setPassword(googleEmployeeDetails.getPassword());
			existingEmp.setMobile(googleEmployeeDetails.getMobile());
			existingEmp.setSalary(googleEmployeeDetails.getSalary());

			return googleEmployeeRepository.save(existingEmp);
		} else {
			throw new IllegalArgumentException("Employee not found.");
		}

	}

	public Optional<ResponseMessage> login(int id, String name, String password) {
        Optional<GoogleEmployeeDetails> empData = googleEmployeeRepository.findById(id);
        System.out.println("empdata " + empData);
        if (empData.isPresent()) {
            GoogleEmployeeDetails employee = empData.get();
            if (employee.getEmpName().equals(name) && employee.getPassword().equals(password)) {
                String successMessage = "Login successful!";
                ResponseMessage loginResponse = new ResponseMessage(successMessage, id, employee);
                return Optional.of(loginResponse);
            }
        }
        return Optional.empty();
	    }
	
	
	
	
}