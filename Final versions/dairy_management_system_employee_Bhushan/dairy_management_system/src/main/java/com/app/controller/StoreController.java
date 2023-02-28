package com.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.app.entities.Store;
import com.app.service.StoreService;

@RestController // (@Controller + @ResponseBody)
@RequestMapping("/store")
@CrossOrigin(origins = "http://localhost:3000")
public class StoreController {
	@Autowired
	private StoreService storeService; 

	public StoreController() {
		super();
		System.out.println("Inside Default Ctor"+getClass());
	}
	@GetMapping("/getstores")
	public List<Store>getAllStores(){
		System.out.println("In getAllEmployee()");
		return storeService.getAllStore();
	}

	//add REST end point t0 return JSON representation of new emp
	//URL: htp://host:port/employees,method:POST
	// Compulsory @RequestBody for Un-Marshling Deserilizing
	@PostMapping
	public Store addStoreDetails(@RequestBody @Valid Store store) {
		System.out.println("In save store Details");
		return storeService.saveStoreDetails(store); 
	}

	@DeleteMapping
	public void deleteStore(Long id) {
		storeService.deleteById(id);
	}

	@GetMapping("/{storeId}")
	public Store getStoreById(@PathVariable Long storeId) {
		return storeService.getStoreById(storeId);
	}
	
	@PutMapping
	public Store updateStore(@RequestBody Store persistentStore) {
		return storeService.updateStore(persistentStore);
	}
	
}
