package com.app.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.entities.MilkRate;
import com.app.repository.MilkRateRepository;


@Service
@Transactional
public class MilkRateServiceImpl implements MilkRateService {

	@Autowired 
	private MilkRateRepository milkRateRepo;
	
	@Override
	public MilkRate setMilkRate(MilkRate milkRate) {
		return milkRateRepo.save(milkRate);
		
	}

	@Override
	public List<MilkRate> getMilkRatesBetweenDates(LocalDate startDate, LocalDate endDate) {
	      return milkRateRepo.findMilkRatesBetweenDates(startDate, endDate);
	}

}
