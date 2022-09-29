package com.csci927.pandemicavaccine.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.csci927.pandemicavaccine.bean.VaccineDetails;
import com.csci927.pandemicavaccine.repository.VaccineRepository;
import com.csci927.pandemicavaccine.service.VaccineService;

@Service
public class VaccineServiceImpl implements VaccineService {
	
	private VaccineRepository vaccineRepo;

	public VaccineServiceImpl(VaccineRepository vaccineRepo) {
		super();
		this.vaccineRepo = vaccineRepo;
	}
	
	
	@Override
	public List<VaccineDetails> getAllVaccineDetails(){
		return vaccineRepo.findAll();
		
	}


	@Override
	public VaccineDetails saveBooking(VaccineDetails vaccineDetails) {
		
		return vaccineRepo.save(vaccineDetails);
	}
}
