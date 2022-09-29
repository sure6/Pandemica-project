package com.csci927.pandemicavaccine.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.csci927.pandemicavaccine.bean.VaccineDetails;

public interface VaccineRepository extends JpaRepository<VaccineDetails,Long>{
	

}
