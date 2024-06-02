package com.sonu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sonu.model.GoogleEmpInfo;
import com.sonu.model.GoogleEmployeeDetails;

public interface GoogleEmployeeInfoRepository extends JpaRepository<GoogleEmpInfo, Integer> {
    List<GoogleEmpInfo> findByGoogleEmployeeDetails(GoogleEmployeeDetails googleEmployeeDetails);
}

