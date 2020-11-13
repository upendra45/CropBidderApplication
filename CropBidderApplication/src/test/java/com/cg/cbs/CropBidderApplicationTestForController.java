package com.cg.cbs;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.cg.cbs.controller.BidderController;
import com.cg.cbs.entity.Bid;
import com.cg.cbs.entity.Bidder;
import com.cg.cbs.service.BidderService;
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
class CropBidderApplicationTestForController {

	@InjectMocks
	private BidderController bidderController;
	@Mock
	BidderService bidderService;
	List<Bid> bidList;
	int userId=5;
	Bidder bidder=new Bidder(11,"vizag","12334","1245678",bidList,true);
	MockMvc mockMvc;
	@Test
	public void getBidderTest() throws Exception
	{
		mockMvc=MockMvcBuilders.standaloneSetup(bidderController).build();
		mockMvc.perform(get("/bidder", userId)).andExpect(status().isOk()).
				andExpect(jsonPath("$.bidderId",is(bidder.getBidderId())));
		
		
	}

}
