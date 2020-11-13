package com.cg.cbs.serviceImp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.cbs.entity.Farmer;
import com.cg.cbs.exception.FarmerNotFoundException;
import com.cg.cbs.repository.IFarmerRepository;
import com.cg.cbs.service.IFarmerService;

@Service
public class FarmerSerImp implements IFarmerService
{
	@Autowired
	IFarmerRepository farmerRepository;
	
	@Autowired
	EntityManager em;
	
	public Farmer addFarmer(Farmer farmer)
	{
		return farmerRepository.save(farmer);
	}
	public Farmer editFarmer(Farmer farmer)
	{
		if(farmerRepository.findById(farmer.getFarmerId())!=null)
		{
		return farmerRepository.save(farmer);
		}
		else
		{
			return null;
		}
	}
	public Farmer getFarmer(int farmerId) throws FarmerNotFoundException
	{
		return farmerRepository.findById(farmerId).orElse(new Farmer());
	}
	public List<Farmer> getAllFarmers()
	{
		return farmerRepository.findAll();
	}
	public List<Farmer> getFarmersByStatus(boolean verified)
	{
		TypedQuery<Farmer> query=em.createQuery("Select f FROM Farmer f WHERE isVerified=:isVerified",Farmer.class).setParameter("isVerified",verified);
		List<Farmer> farmersList=query.getResultList();
		return farmersList;
	}
}