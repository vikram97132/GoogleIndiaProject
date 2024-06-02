package com.sonu.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sonu.model.GoogleEmployeeDetails;

@Repository
public interface GoogleEmployeeRepository extends JpaRepository<GoogleEmployeeDetails, Integer> {

	public GoogleEmployeeDetails save(GoogleEmployeeDetails googleEmployeeDetails);

	Optional<GoogleEmployeeDetails> findById(int empId);

	@Query("SELECT e FROM GoogleEmployeeDetails e WHERE " + "(:empId IS NULL OR e.empId = :empId) AND "
			+ "(:name IS NULL OR e.empName = :name) AND " + "(:deptartment IS NULL OR e.deptartment = :deptartment)")
	List<GoogleEmployeeDetails> findByCriteria(@Param("empId") Long empId, @Param("name") String name,
			@Param("deptartment") String deptartment);

}
