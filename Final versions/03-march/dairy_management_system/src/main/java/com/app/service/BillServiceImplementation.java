package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.entities.Bill;
import com.app.entities.Suppliers;
import com.app.repository.BillRepository;
import com.app.repository.SupplierRepository;

@Service
@Transactional
public class BillServiceImplementation implements BillService {

	
	private Suppliers supplier = null;
	
	@Autowired
	private BillRepository billRepository;

	//--------------------------------------------
		@Autowired
		private SupplierRepository supplierRepository;
		
	//---------------------------------------------------

	@Override
	public List<Bill> generateBill() {

		return billRepository.findAll();
	}

//	@Override
//	public Bill addBill(Bill bill) {
//		Bill persistBill = null;
//		try {
//			bill = billRepository.save(bill);
//		} catch (RuntimeException eception) {
//			throw new ResourceNotFoundException("Not saved ");
//		}
//		return persistBill;
//	}
	
	@Override
	public Bill addNewBill(Bill bill) {
		Bill persistBill = null;
		try {
			
			long supplierId=bill.getSupplier().getSupplierId();
			 supplier=supplierRepository.findById(supplierId).orElseThrow(()->  new ResourceNotFoundException("supplier not found"));
			persistBill = billRepository.save(bill);
			
			supplier.addBill(persistBill,supplier);
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
			throw new ResourceNotFoundException("Bill with Id = "+id+" is not present");
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
