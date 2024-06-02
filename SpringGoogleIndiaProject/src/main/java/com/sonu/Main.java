package com.sonu;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.sonu.model.GoogleEmployeeDetails;

import javax.validation.ConstraintViolation;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		GoogleEmployeeDetails employee = new GoogleEmployeeDetails();
		
		employee.setEmpId(1);
		employee.setEmpName("John Doe");
		employee.setAddress("123 Main St");
		employee.setGender("Male");
		employee.setDeptartment("Engineering");
		employee.setJoiningYear(2021);
		employee.setEmail("john.doe@example.com");
		employee.setPassword("password123");
		employee.setMobile(1234567890L);
		employee.setSalary(50000.00);

		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();

		Set<ConstraintViolation<GoogleEmployeeDetails>> violations = validator.validate(employee);

		if (!violations.isEmpty()) {
			for (ConstraintViolation<GoogleEmployeeDetails> violation : violations) {
				System.out.println(violation.getMessage());
			}
		} else {
			System.out.println("All validations passed.");
		}
	}
}
