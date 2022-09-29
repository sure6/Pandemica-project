package com.csci927.pandemicavaccine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.csci927.pandemicavaccine.repository.VaccineRepository;

@SpringBootApplication
public class PandemicaVaccinebookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(PandemicaVaccinebookingApplication.class, args);
	}
	
	@Autowired
	private VaccineRepository vaccineRepo;

}
