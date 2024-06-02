package com.sonu.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "google_emp_info")
public class GoogleEmpInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int infoId;
	private String familyInfo;
	private String familyDetails;
	private String educationDetails;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "emp_id", nullable = false)
	private GoogleEmployeeDetails googleEmployeeDetails;

	public int getInfoId() {
		return infoId;
	}

	public void setInfoId(int infoId) {
		this.infoId = infoId;
	}

	public String getFamilyDetails() {
		return familyDetails;
	}

	public void setFamilyDetails(String familyDetails) {
		this.familyDetails = familyDetails;
	}

	public String getEducationDetails() {
		return educationDetails;
	}

	public void setEducationDetails(String educationDetails) {
		this.educationDetails = educationDetails;
	}

	public GoogleEmployeeDetails getGoogleEmployeeDetails() {
		return googleEmployeeDetails;
	}

	public void setGoogleEmployeeDetails(GoogleEmployeeDetails googleEmployeeDetails) {
		this.googleEmployeeDetails = googleEmployeeDetails;
	}

	public String getFamilyInfo() {
		return familyInfo;
	}

	public void setFamilyInfo(String familyInfo) {
		this.familyInfo = familyInfo;
	}

	@Override
	public String toString() {
		return "GoogleEmpInfo [infoId=" + infoId + ", familyInfo=" + familyInfo + ", familyDetails=" + familyDetails
				+ ", educationDetails=" + educationDetails + ", googleEmployeeDetails=" + googleEmployeeDetails + "]";
	}

}
