package com.cg.cbs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import com.cg.cbs.entity.Crop;
import com.cg.cbs.entity.Farmer;
import com.cg.cbs.entity.Status;
import com.cg.cbs.exception.CropNotFoundException;
import com.cg.cbs.exception.FarmerNotFoundException;
import com.cg.cbs.repository.ICropRepository;
import com.cg.cbs.service.CropServiceImpl;


@SpringBootTest
class CropServiceImplTests {

	@Mock
	ICropRepository cropRepository;
	
	@InjectMocks
	CropServiceImpl cropService;
	
	Farmer farmer = new Farmer(1,"Chinnakottala","Kurnool",true);
	Farmer farmer1 = new Farmer(3,"Koilakunta","Kurnool",true);
	Crop crop1 = new Crop(11,"Rice","Rabi","NitrogenBased",80,1125,Status.GOOD,farmer);
	Crop crop2 = new Crop(12,"Wheat","Kharif","NitrogenBased",90,1125,Status.AVERAGE,farmer);
	Crop crop3 = new Crop(13,"Rice","Rabi","NitrogenBased",99,1125,Status.BAD,farmer1);
	Crop crop4 = new Crop(14,"Wheat","Kharif","NitrogenBased",90,1125,Status.AVERAGE,farmer1);
	Crop crop5 = new Crop(15,"Rice","Rabi","NitrogenBased",99,1125,Status.BAD,farmer1);
	
	/*
	 * Scenario: Adding Crop details
	 * */
	@Test
	public void addCropTest()
	{
		when(cropRepository.save(crop1)).thenReturn(crop1);
		Crop addedCrop = cropService.addCrop(crop1);
		assertNotNull(addedCrop);
		assertEquals(crop1, addedCrop);
	}
	
	/*
	 * Scenario: get all the Crops
	 * */
	@Test
	public void getAllCropsTest() 
	{	
		List<Crop> crops = new ArrayList<Crop>();
		crops.add(crop1);
		crops.add(crop2);
		crops.add(crop3);
		when(cropRepository.findAll()).thenReturn(crops);
		assertEquals(3, cropService.getAllCrops().size());
	}
	
	/*
	 * Scenario: exception when there is no crops are available ( Crop List is empty )
	 * */
	@Test
	public void getAllCropsTestFailure()
	{
		List<Crop> crops = new ArrayList<Crop>();
		when(cropRepository.findAll()).thenReturn(crops);
		assertThrows(CropNotFoundException.class,
				()->{
						cropService.getAllCrops();
					}
				);
	}
	
	/*
	 * Scenario: edit the Crop by crop id
	 * */
	@Test
	public void editCropTest()
	{
		when(cropRepository.save(crop1)).thenReturn(crop1);
		when(cropRepository.findById(crop1.getCropId())).thenReturn(Optional.of(crop1));
		Crop editedCrop = cropService.editCrop(crop1);
		assertNotNull(editedCrop);
		assertEquals(crop1, editedCrop);	
	}
	
	/*
	 * Scenario: exception when Crop not available to update 
	 * */
	@Test
	public void editCropTestFailure()
	{
		when(cropRepository.findById(crop1.getCropId())).thenThrow(CropNotFoundException.class);
	}
	
	/*
	 * Scenario: get Crop by id
	 * */
	@Test
	public void getCropByIdTest()
	{
		when(cropRepository.findById(crop1.getCropId())).thenReturn(Optional.of(crop1));
		Crop cropByid = cropService.getCrop(crop1.getCropId());
		assertNotNull(cropByid);
		assertEquals(crop1, cropByid);
	}
	
	/*
	 * Scenario: exception when crop not found with the given cropId
	 * */
	@Test
	public void getCropByIdTestFailure()
	{
		when(cropRepository.findById(crop1.getCropId())).thenReturn(Optional.of(new Crop()));
		
		assertThrows(CropNotFoundException.class,
				()->{
						cropService.getCrop(crop1.getCropId());
					}
				);
	}
	
	/*
	 * Scenario: get Crops by farmer id
	 * */
	@Test
	public void getCropByFarmerIdTest()
	{
		List<Crop> crops = new ArrayList<Crop>();
		crops.add(crop3);
		crops.add(crop4);
		crops.add(crop5);
		
		when(cropRepository.findCropsByFarmer(farmer1.getFarmerId())).thenReturn(crops);
		List<Crop> cropsByid =cropService.getCropsByFarmer(farmer1.getFarmerId());
		assertNotNull(cropsByid);
		assertEquals(crops.size(), cropsByid.size());
	}
	
	/*
	 * Scenario: exception when there is no crops available with the given farmerId ( Crop List is empty )
	 * */
	@Test
	public void getCropByFarmerIdTestFailure()
	{
		List<Crop> crops = new ArrayList<Crop>();
		when(cropRepository.findCropsByFarmer(1)).thenReturn(crops);
		assertThrows(FarmerNotFoundException.class,
				()->{
						cropService.getCropsByFarmer(1);
					}
				);
	}

	/*
	 * Scenario: get Crops by Crop Name 
	 * */
	@Test
	public void getCropsByNameTest()
	{
		List<Crop> crops = new ArrayList<Crop>();
		crops.add(crop1);
		crops.add(crop2);
		crops.add(crop3);
		
		when(cropRepository.findBycropName("Rice")).thenReturn(crops);
		assertEquals(crops, cropService.getCropsByName("Rice"));
	}
	
	/*
	 * Scenario: exception when crop not found with the given cropName ( Crop List is empty )
	 * */
	@Test
	public void getCropsByNameTestFailure()
	{
		List<Crop> crops = new ArrayList<Crop>();
		when(cropRepository.findBycropName("Rice")).thenReturn(crops);
		assertThrows(CropNotFoundException.class,
				()->{
						cropService.getCropsByName("Rice");
					}
				);
	}
	
	/*
	 * Scenario: get Crops by Crop Status
	 * */
	@Test
	public void getCropsByStatusTest()
	{
		List<Crop> crops = new ArrayList<Crop>();
		crops.add(crop1);
		crops.add(crop2);
		crops.add(crop3);
		
		when(cropRepository.findBystatus(Status.GOOD)).thenReturn(crops);
		assertEquals(crops, cropService.getCropsByStatus(Status.GOOD));
	}
	
	/*
	 * Scenario: exception when crop not found with the given status ( Crop List is empty )
	 * */
	@Test
	public void getCropsByStatusTestFailure()
	{
		List<Crop> crops = new ArrayList<Crop>();
		when(cropRepository.findBystatus(Status.GOOD)).thenReturn(crops);
		assertThrows(CropNotFoundException.class,
				()->{
						cropService.getCropsByStatus(Status.GOOD);
					}
				);
	}
}