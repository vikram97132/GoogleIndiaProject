package com.sonu.dto;

import com.sonu.model.GoogleEmployeeDetails;

public class ResponseMessage {

	String message;
	int empId;
	GoogleEmployeeDetails empDetails;

	public ResponseMessage(String message, int empId, GoogleEmployeeDetails empDetails) {
		super();
		this.message = message;
		this.empId = empId;
		this.empDetails = empDetails;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public GoogleEmployeeDetails getEmpDetails() {
		return empDetails;
	}

	public void setEmpDetails(GoogleEmployeeDetails empDetails) {
		this.empDetails = empDetails;
	}

	@Override
	public String toString() {
		return "ResponseMessage [message=" + message + ", empId=" + empId + ", empDetails=" + empDetails + "]";
	}

}
