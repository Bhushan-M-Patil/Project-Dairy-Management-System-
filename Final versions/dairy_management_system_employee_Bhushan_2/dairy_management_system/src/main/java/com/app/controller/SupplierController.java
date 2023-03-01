package com.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.Suppliers;
import com.app.service.SupplierService;

@RestController
//To enable CORS header 
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/Suppliers")
@Validated
public class SupplierController {

    @Autowired
    private SupplierService supplierservice;
    
	public SupplierController() {
		System.out.println("in def ctor " + getClass());
	}

  
	
//	public List<Suppliers> checkMilkSuppliedHistory() {
//	return ;
//	}
	@PostMapping
	public Suppliers saveSupplierDetails(@RequestBody @Valid Suppliers transientSupplier) {
		Suppliers persistentSupplier=supplierservice.addSupplier(transientSupplier);
		return persistentSupplier;
	}

	
	@DeleteMapping("/{SupplierId}")
	public String deleteEmpDetails(@PathVariable Long SupplierId) {
	  return supplierservice.deleteSupplier(SupplierId);
	}

	
	@PutMapping
	public Suppliers updateEmpDetails(@RequestBody long supplierId) {
		return supplierservice.updateSupplierDetails(supplierId);
	}

     
	@GetMapping
	public List<Suppliers> getAllSuppliers()
	{
		return supplierservice.getAllSuppliers();
	}
}
