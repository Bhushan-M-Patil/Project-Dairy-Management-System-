package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.entities.Bill;
import com.app.repository.BillRepository;

@Service
@Transactional
public class BillServiceImplementation implements BillService {

	@Autowired
	private BillRepository billRepository;

	

	@Override
	public List<Bill> generateBill() {

		return billRepository.findAll();
	}

	@Override
	public Bill addBill(Bill bill) {
		Bill persistBill = null;
		try {
			bill = billRepository.save(bill);
		} catch (RuntimeException eception) {
			throw new ResourceNotFoundException("Not saved ");
		}
		return persistBill;
	}

	@Override
	public String deleteBill(Long id) {
		try {
			billRepository.deleteById(id);
		} catch (RuntimeException eception) {
			throw new ResourceNotFoundException("Not saved ");
		}
		return "Deleted from the database";
	}

	@Override
	public Bill updateBill(Bill bill) {
		if (billRepository.existsById(bill.getBillId())) {
			return billRepository.save(bill);
		}
		throw new ResourceNotFoundException("Bill with this id not found ");
	}

}
