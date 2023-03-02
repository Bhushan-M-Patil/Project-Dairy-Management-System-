package com.app.service;

import java.time.LocalDate;
import java.util.List;
import com.app.entities.MilkRate;

public interface MilkRateService {
	// Get MilkRates
//	List<MilkRate> getMilkRates();
	// Add New Store
	MilkRate setMilkRate(MilkRate milkrate);
	// get milk Rates within Specified dates
    List<MilkRate> getMilkRatesBetweenDates(LocalDate startDate, LocalDate endDate);

}
