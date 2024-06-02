package com.sonu.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Google_Emp_Details")
public class GoogleEmployeeDetails {
	@Id
	private int empId;

	private String empName;
	private String address;
	private String gender;
	private String deptartment; 
	private long joiningYear;
	private String email;
	private String password;
	private long mobile;
	private double salary;

	@JsonManagedReference
	@OneToMany(mappedBy = "googleEmployeeDetails", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<GoogleEmpInfo> employeeInfos;

	public GoogleEmployeeDetails() {
	}

	public GoogleEmployeeDetails(int empId, String empName, String address, String gender, String deptartment,
			long joiningYear, String email, String password, long mobile, double salary,
			Set<GoogleEmpInfo> employeeInfos) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.address = address;
		this.gender = gender;
		this.deptartment = deptartment;
		this.joiningYear = joiningYear;
		this.email = email;
		this.password = password;
		this.mobile = mobile;
		this.salary = salary;
		this.employeeInfos = employeeInfos;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDeptartment() {
		return deptartment;
	}

	public void setDeptartment(String deptartment) {
		this.deptartment = deptartment;
	}

	public long getJoiningYear() {
		return joiningYear;
	}

	public void setJoiningYear(long joiningYear) {
		this.joiningYear = joiningYear;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Set<GoogleEmpInfo> getEmployeeInfos() {
		return employeeInfos;
	}

	public void setEmployeeInfos(Set<GoogleEmpInfo> employeeInfos) {
		this.employeeInfos = employeeInfos;
	}

	@Override
	public String toString() {
		return "GoogleEmployeeDetails [empId=" + empId + ", empName=" + empName + ", address=" + address + ", gender="
				+ gender + ", deptartment=" + deptartment + ", joiningYear=" + joiningYear + ", email=" + email
				+ ", password=" + password + ", mobile=" + mobile + ", salary=" + salary + ", employeeInfos="
				+ employeeInfos + "]";
	}

}
