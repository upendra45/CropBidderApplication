package com.cg.cbs.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.cbs.entity.Crop;
import com.cg.cbs.entity.Status;
import com.cg.cbs.exception.CropNotFoundException;
import com.cg.cbs.exception.FarmerNotFoundException;
import com.cg.cbs.repository.ICropRepository;

@Service
@Transactional
public class CropServiceImpl implements ICropService {

	@Autowired
	ICropRepository cropRepository;
	
	// adding the crop details
	@Override
	public Crop addCrop(Crop crop) 
	{	
		return cropRepository.save(crop);
	}

	// update the crop details 
	@Override
	public Crop editCrop(Crop crop) throws CropNotFoundException
	{	
		Crop cropObj = cropRepository.findById(crop.getCropId()).orElse(null);
		if(cropObj!=null)
		{
			return cropRepository.save(crop);
			//return cropObj;
		}
		else
		{
			throw new CropNotFoundException("No Crop available to update");
		}
	}

	// get Crop details by cropId 
	@Override
	public Crop getCrop(int cropId) throws CropNotFoundException 
	{
		Crop crop = cropRepository.findById(cropId).orElse(new Crop());
		if(crop.getCropId()!=cropId)
		{
			throw new CropNotFoundException("No Crop available with this id");
		}
		else
		{
			return crop;
		}
	}

	// get all the crops
	@Override
	public List<Crop> getAllCrops() throws CropNotFoundException
	{	
		//return cropRepository.findAll();
		List<Crop> cropsList = cropRepository.findAll();
		if(cropsList.isEmpty())
		{
			throw new CropNotFoundException("No Crops available");
		}
		else
		{
			return cropsList;
		}
	}

	// get crops details by farmerId
	@Override
	public List<Crop> getCropsByFarmer(int farmerId) throws FarmerNotFoundException 
	{	
		List<Crop> cropsListByfarmerId = cropRepository.findCropsByFarmer(farmerId);
		
		if(cropsListByfarmerId.isEmpty())
		{
			throw new FarmerNotFoundException("No Farmer found with this id: "+farmerId);
		}
		else
		{
			return cropsListByfarmerId;
		}		
	}
	
	// get crops details by Crop name 
	@Override
	public List<Crop> getCropsByName(String name) throws CropNotFoundException 
	{
		List<Crop> cropsList =  cropRepository.findBycropName(name);
		if(cropsList.isEmpty())
		{
			throw new CropNotFoundException("No Crop found with this name");
		}
		else
		{
			return cropsList;
		}
	}

	//get crops details by status of the crop
	@Override
	public List<Crop> getCropsByStatus(Status status) throws CropNotFoundException 
	{
		List<Crop> cropsList = cropRepository.findBystatus(status);
		if(cropsList.isEmpty())
		{
			throw new CropNotFoundException("No Crop found with this Status");
		}
		else
		{
			return cropsList;
		}
	}
}