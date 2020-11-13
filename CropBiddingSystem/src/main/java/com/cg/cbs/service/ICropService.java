package com.cg.cbs.service;

import java.util.List;

import com.cg.cbs.entity.Crop;
import com.cg.cbs.entity.Status;
import com.cg.cbs.exception.CropNotFoundException;
import com.cg.cbs.exception.FarmerNotFoundException;

public interface ICropService {

	Crop addCrop(Crop crop);

	Crop editCrop(Crop crop);

	Crop getCrop(int cropId) throws CropNotFoundException;

	List<Crop> getAllCrops() throws CropNotFoundException;

	List<Crop> getCropsByFarmer(int farmerId) throws FarmerNotFoundException;

	List<Crop> getCropsByName(String name) throws CropNotFoundException;
	
	List<Crop> getCropsByStatus(Status status) throws CropNotFoundException;
}
