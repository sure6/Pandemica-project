package com.csci927.pandemicavaccine.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.csci927.pandemicavaccine.bean.VaccineDetails;
import com.csci927.pandemicavaccine.service.VaccineService;

@Controller
public class VaccineController {
	
	private VaccineService vaccineService;

	public VaccineController(VaccineService vaccineService) {
		super();
		this.vaccineService = vaccineService;
	}
	
	
	
	@GetMapping("/bookings")
	public String listBookings(Model model) {
		model.addAttribute("vaccineDetails", vaccineService.getAllVaccineDetails());
		return "VaccineDetails";
	}
	
	@GetMapping("/bookings/new")
	public String createBooking(Model model) {
		VaccineDetails details = new VaccineDetails();
		model.addAttribute("booking",details);
		return "create_booking";
		
	}
	
	@PostMapping("/bookings")
	public String saveBooking(@ModelAttribute("booking")VaccineDetails vaccineDetails) {
		vaccineService.saveBooking(vaccineDetails);
		return "redirect:/bookings";
	}

}
