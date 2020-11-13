package com.cg.cbs.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.cg.cbs.beans.Bid;
import com.cg.cbs.beans.Bidder;
import com.cg.cbs.beans.Crop;
import com.cg.cbs.beans.Farmer;
import com.cg.cbs.controller.BidController;
import com.cg.cbs.service.BidService;

@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
public class BidControllerTest {

	@MockBean
	private BidService bidservice;
	@InjectMocks
	private BidController bidcontroller;
	
	private MockMvc mockmvc;
	
	@Test
	public void addBidTest() throws Exception
	{
		mockmvc=MockMvcBuilders.standaloneSetup(bidcontroller).build();
		Farmer farmer = new Farmer(1,"ramnagar","nellore",true);
		Crop crop1=new Crop(1,"rice","rabi","nitrogen",5.5,20000,true,farmer);
		Bidder bidder1=new Bidder(1,"hyderabad","432541","BNZY398974",true);
		Bid bid1=new Bid(1,LocalDate.of(2020,8,18),25000,true,crop1,bidder1);
		//mockmvc=MockMvcBuilders.standaloneSetup(bidcontroller).build();
		
		when(bidservice.addBid(bid1)).thenReturn(bid1);
		mockmvc.perform(MockMvcRequestBuilders.get("/bids/add",bid1))
					.andExpect(MockMvcResultMatchers.status().isOk())
					.andExpect(MockMvcResultMatchers.jsonPath("$.bidId", is(1)))
					.andExpect(MockMvcResultMatchers.jsonPath("$.date", Matchers.is(2020-8-18)))
					.andExpect(MockMvcResultMatchers.jsonPath("$.amount", Matchers.is(25000)));
	}	
//	private MockMvc mockmvc;
//	
//	@Mock
//	private BidService bidservice;
//	
//	@InjectMocks
//	private BidController bidcontroller;
//	
//	Farmer farmer = new Farmer(1,"ramnagar","nellore",true);
//	Crop crop1=new Crop(1,"rice","rabi","nitrogen",5.5,20000,true,farmer);
//	Crop crop2=new Crop(2,"wheat","zaid","phosphorous",5,15000,true,farmer);
//	Bidder bidder1=new Bidder(1,"hyderabad","432541","BNZY398974",true);
//	Bidder bidder2=new Bidder(2,"secunderabad","459826","BNZY749872",true);
//	Bid bid1=new Bid(1,LocalDate.of(2020,8,18),25000,true,crop1,bidder1);
//	Bid bid2=new Bid(2,LocalDate.of(2020,3,13),20000,false,crop2,bidder1);
//	
//	@Before
//	public void setup()
//	{
//		mockmvc=MockMvcBuilders.standaloneSetup(bidcontroller).build();
//	}
//	
//	@Test
//	public void addBidTest() throws Exception
//	{
//		mockmvc=MockMvcBuilders.standaloneSetup(bidcontroller).build();
//		when(bidservice.addBid(bid1)).thenReturn(bid1);
//		RequestBuilder requestbuilder=MockMvcRequestBuilders.get("/bids/add").accept(MediaType.APPLICATION_JSON);
//		mockmvc.perform(requestbuilder)
//					.andExpect(MockMvcResultMatchers.status().isOk())
//					.andExpect(MockMvcResultMatchers.content().json("{'bidId':'1','date':'2020-08-18','amount':'25000'}"));
//							//jsonPath("$.bidId", Matchers.is(1))
////		MvcResult result=mockmvc.perform(requestbuilder).andReturn();
////		System.out.println(result.getResponse());
////		String expected="{bidId:1,date:2020-08-18,amount:25000}";
////		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
//		
//	}

}
