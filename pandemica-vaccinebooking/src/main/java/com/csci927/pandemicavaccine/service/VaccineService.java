package com.csci927.pandemicavaccine.service;

import java.util.List;

import com.csci927.pandemicavaccine.bean.VaccineDetails;

public interface VaccineService {
	
 List<VaccineDetails> getAllVaccineDetails();
 
 VaccineDetails saveBooking(VaccineDetails vaccineDetails);

}
