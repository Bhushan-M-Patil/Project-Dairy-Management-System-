package com.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.Bill;
import com.app.service.BillService;

@RestController
//@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/bills")

@Validated // specific class supposed to be validated
public class BillController {

	public BillController() {
		System.out.println("inDef constructor of " + getClass());
	}

	@Autowired
	private BillService billService;

	@GetMapping
	public List<Bill> generateBill() {
		return billService.generateBill();
	}

	@PostMapping
	public Bill addBill(@RequestBody @Valid Bill transientBill) {
		return billService.addBill(transientBill);
	}

	@DeleteMapping("/{billId}")
	public String deleteBill(@PathVariable Long billId) {
		return "deleted bill " + billService.deleteBill(billId);
	}

	@PutMapping
	public String updateBill(@RequestBody Bill detachedBill) {
		return "deleted " + billService.updateBill(detachedBill);
	}
}