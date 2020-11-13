package com.cg.cbs.controller;

import java.util.List;
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
import com.cg.cbs.entity.Crop;
import com.cg.cbs.entity.Status;
import com.cg.cbs.exception.CropNotFoundException;
import com.cg.cbs.exception.FarmerNotFoundException;
import com.cg.cbs.service.CropServiceImpl;

@RestController
@RequestMapping("/api/crops")
public class CropController {

	@Autowired
	CropServiceImpl cropService;
	
	// adding Crop details
	@PostMapping("/add")
	public ResponseEntity<Crop> addCrop(@RequestBody Crop crop) 
	{
		return new ResponseEntity<Crop>(cropService.addCrop(crop),HttpStatus.OK);
	}
	
	// update Crop details
	@PutMapping("/update")
	public ResponseEntity<Crop> updateCrop(@RequestBody Crop crop)
	{
		Crop cropEditing = cropService.editCrop(crop);
		return new ResponseEntity<Crop>(cropEditing,HttpStatus.OK);
	}
	
	// get all the Crops 
	@GetMapping("/all")
	public ResponseEntity<List<Crop>> getAllCrops() throws CropNotFoundException
	{
		List<Crop> cropsList = cropService.getAllCrops();
		return new ResponseEntity<List<Crop>>(cropsList,HttpStatus.OK);
	}
	
	// get Crop details by cropId
	@GetMapping("/{cropId}")
	public ResponseEntity<Crop> getCropById(@PathVariable int cropId) throws CropNotFoundException
	{
		Crop res = cropService.getCrop(cropId);
		return new ResponseEntity<Crop>(res,HttpStatus.OK);
	}
	
	// get Crops details by Crop name
	@GetMapping("/byName/{cropName}")
	public ResponseEntity<List<Crop>> getCropByName(@PathVariable String cropName) throws CropNotFoundException
	{
		List<Crop> cropsByName = cropService.getCropsByName(cropName);
		return new ResponseEntity<List<Crop>>(cropsByName,HttpStatus.OK);
	}
	
	//get Crops details by farmer id
	@GetMapping("/byFarmerId/{farmerId}")
	public ResponseEntity<List<Crop>> getCropsByfarmerId(@PathVariable int farmerId) throws FarmerNotFoundException
	{
		List<Crop> cropsByfarmerId = cropService.getCropsByFarmer(farmerId);
		return new ResponseEntity<List<Crop>>(cropsByfarmerId,HttpStatus.OK);
	}
	
	// get Crops details by Crop status 
	@GetMapping("/byStatus/{status}")
	public ResponseEntity<List<Crop>> getCropByStatus(@PathVariable Status status) throws CropNotFoundException
	{
		List<Crop> cropsByStatus = cropService.getCropsByStatus(status);
		return new ResponseEntity<List<Crop>>(cropsByStatus,HttpStatus.OK);
	}
}