package com.cg.cbs.service;

import java.util.List;
import com.cg.cbs.entity.Farmer;
import com.cg.cbs.exception.FarmerNotFoundException;

public interface IFarmerService {

	Farmer addFarmer(Farmer farmer);
	
	Farmer editFarmer(Farmer farmer);
	
	Farmer getFarmer(int farmerId) throws FarmerNotFoundException;
	
	List<Farmer> getAllFarmers();
	
	List<Farmer> getFarmersByStatus(boolean verified);
}
