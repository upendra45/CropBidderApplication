package com.cg.cbs.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.cbs.entity.Farmer;
import com.cg.cbs.service.FarmerServiceImpl;

@RestController
@RequestMapping("/api/farmer")
public class FarmerController {

	@Autowired
	FarmerServiceImpl farmerService;
	
	// adding Farmer details
	@PostMapping("/add")
	public ResponseEntity<Farmer> addFarmer(@RequestBody Farmer farmer)
	{
		return new ResponseEntity<Farmer>(farmerService.addFarmer(farmer),HttpStatus.OK);
		
	}
	
	// update Farmer details
	@GetMapping("/all")
	public List<Farmer> getAllFarmers()
	{
		return farmerService.getAllFarmers();
	}
}
