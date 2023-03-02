package com.app.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.app.entities.MilkRate;
import com.app.service.MilkRateService;

@RestController 
@RequestMapping("/milk-rates")
@CrossOrigin(origins = "http://localhost:3000")
public class MilkRateController {
	@Autowired
	private MilkRateService milkRateService; 

	public MilkRateController() {
		super();
		System.out.println("Inside Default Ctor"+getClass());
	}
	
	@PostMapping("/add-rate")
	public MilkRate setMilkRate(@RequestBody @Valid MilkRate milkrate) {
		System.out.println("In setMilkRate");
		return milkRateService.setMilkRate(milkrate);
	}
	
	@GetMapping("/get-rate")
	public List<MilkRate> getMilkRatesBetweenDates(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate){
		return milkRateService.getMilkRatesBetweenDates(startDate, endDate);
	}
	
//	@GetMapping
//	public List<MilkRate> getMilkRatesBetweenDates(@RequestParam String startDate, String endDate){
//		return milkRateService.getMilkRatesBetweenDates(LocalDate.parse(startDate), LocalDate.parse(endDate));
//	}
}

