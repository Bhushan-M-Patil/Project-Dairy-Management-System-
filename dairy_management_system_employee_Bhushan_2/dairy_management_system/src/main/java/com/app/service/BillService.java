package com.app.service;

import java.util.List;

import com.app.entities.Bill;

public interface BillService {
	
 List<Bill> generateBill();
 
 Bill addBill(Bill bill);
 
 String deleteBill(Long id);
 
 Bill updateBill(Bill bill);
}
