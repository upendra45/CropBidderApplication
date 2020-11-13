package com.cg.cbs.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.cbs.entity.Farmer;
import com.cg.cbs.exception.FarmerNotFoundException;
import com.cg.cbs.repository.IFarmerRepository;

@Service
@Transactional
public class FarmerServiceImpl implements IFarmerService {

	@Autowired
	IFarmerRepository farmerRepository;
	
	// adding Farmer details
	@Override
	public Farmer addFarmer(Farmer farmer) {
		
		return farmerRepository.save(farmer);
	}

	// get all the Farmers
	@Override
	public List<Farmer> getAllFarmers() {
		
		return farmerRepository.findAll();
	}

	@Override
	public Farmer editFarmer(Farmer farmer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Farmer getFarmer(int farmerId) throws FarmerNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Farmer> getFarmersByStatus(boolean verified) {
		// TODO Auto-generated method stub
		return null;
	}

}
