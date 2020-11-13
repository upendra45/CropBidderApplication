package com.cg.cbs;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import com.cg.cbs.controller.CropController;
import com.cg.cbs.entity.Crop;
import com.cg.cbs.entity.Farmer;
import com.cg.cbs.entity.Status;
import com.cg.cbs.service.CropServiceImpl;
import com.cg.cbs.service.FarmerServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(CropController.class)
@AutoConfigureMockMvc
class CropControllerTest {

	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	FarmerServiceImpl farmerService;
	@MockBean
	CropServiceImpl cropService;
	 
	//private static ObjectMapper mapper = new ObjectMapper();
	   
	/*@Test
	public void addCropTest() throws Exception 
	{
		Farmer farmer1 = new Farmer(1,"Chinnakottala","Kurnool",true);
			Crop crop = new Crop();
	        crop.setCropId(1);
	        crop.setCropName("Rice");
	        crop.setCropType("Rabi");
	        crop.setFertilizer("Nitro");
	        crop.setBasePrice(100);
	        crop.setQuantity(10);
	        crop.setFarmer(farmer1);
	        Mockito.when(cropService.addCrop(ArgumentMatchers.any())).thenReturn(crop);
	        String json = mapper.writeValueAsString(crop);
	        mockMvc.perform(post("/api/crops/add").contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8").content(json)
	        		.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
	        		.andExpect((ResultMatcher) jsonPath("$.crop.cropId", Matchers.equalTo(1)))
	        		.andExpect((ResultMatcher) jsonPath("$.crop.cropName", Matchers.equalTo("Rice")))
	        		.andExpect((ResultMatcher) jsonPath("$.crop.cropType", Matchers.equalTo("Rabi")))
	        		.andExpect((ResultMatcher) jsonPath("$.crop.fertilizer", Matchers.equalTo("Nitro")))
	        		.andExpect((ResultMatcher) jsonPath("$.crop.basePrice", Matchers.equalTo(100)))
	        		.andExpect((ResultMatcher) jsonPath("$.crop.quantity", Matchers.equalTo(10)))
	        		.andExpect((ResultMatcher) jsonPath("$.farmer1.farmer", Matchers.equalTo("farmer1")));
		}*/
	
	@Test
	public void testAddCrop() throws Exception 
	{
		Farmer farmer = new Farmer(1,"Chinnakottala","Kurnool",true);
		Crop crop1 = new Crop(11,"Rice","Rabi","NitrogenBased",80,1125,Status.GOOD,farmer);
		Crop crop = mock(Crop.class);
		when(cropService.addCrop(crop)).thenReturn(crop);
		ObjectMapper objectMapper = new ObjectMapper();
		String requestDataJson = objectMapper.writeValueAsString(crop1);
		String expectedJson = objectMapper.writeValueAsString(crop1);
		mockMvc.perform(post("/api/crops/add").content(requestDataJson).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(content().json(expectedJson));
	}
}