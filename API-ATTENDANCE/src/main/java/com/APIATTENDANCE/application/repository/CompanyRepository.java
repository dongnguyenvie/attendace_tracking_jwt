package com.APIATTENDANCE.application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.APIATTENDANCE.application.entity.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer>{
	@Query("SELECT c FROM Company c WHERE c.com_province = ?1")
	public List<Company> GetComByProvinceID(int id);
}
