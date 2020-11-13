package com.cg.cbs.controller;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.cbs.entity.Farmer;
import com.cg.cbs.exception.FarmerNotFoundException;
import com.cg.cbs.serviceImp.FarmerSerImp;


@RestController
@RequestMapping("/api/farmer")
public class FarmerController {
	
	@Autowired
	public FarmerSerImp service;
	
	@PostMapping("/farmer/add")
	
	public ResponseEntity<Farmer> addFarmer(@RequestBody Farmer farmer)
	{
		
		Farmer res=service.addFarmer(farmer);
		return new ResponseEntity<Farmer>(res,HttpStatus.CREATED);
	}

	@PutMapping("/farmer")
	public ResponseEntity<Farmer> editFarmer(@RequestBody Farmer farmer)
	{
		Farmer res=service.editFarmer(farmer);
		return new ResponseEntity<Farmer>(res,HttpStatus.OK);
	}
	
	@GetMapping("/farmer/{id}")
	public ResponseEntity<Farmer> getFarmerById(@PathVariable int farmerId)
	{
		Farmer res=service.getFarmer(farmerId);
		if(res.getFarmerId()==0)
		{
			throw new FarmerNotFoundException("No Farmer found with id:"+farmerId);
		}
		else 
		{
		return new ResponseEntity<Farmer>(res, HttpStatus.OK);
		}
	}
	
	@GetMapping("/farmers")
	public List<Farmer> getAllFarmers()
	{
		return service.getAllFarmers();
	}

}

