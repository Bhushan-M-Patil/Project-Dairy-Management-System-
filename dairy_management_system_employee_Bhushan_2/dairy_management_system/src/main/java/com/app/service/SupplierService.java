package com.app.service;

import java.util.List;

import javax.validation.Valid;

import com.app.dto.LoginRequestDto;
import com.app.entities.Suppliers;


public interface SupplierService {

	 List<Suppliers> getAllSuppliers();

	String deleteSupplier(Long supplierId);

	Suppliers addSupplier(Suppliers supplier);

	Suppliers updateSupplierDetails(long supplierId);

	Suppliers authenticateSupplier(@Valid LoginRequestDto loginRequestDto);


	


}
