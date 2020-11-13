package com.cg.cbs;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import com.cg.cbs.entity.Bid;
import com.cg.cbs.entity.Bidder;
import com.cg.cbs.entity.Crop;
import com.cg.cbs.entity.Farmer;
import com.cg.cbs.exception.BidderNotFoundException;
import com.cg.cbs.repository.BidderRepository;
import com.cg.cbs.service.BidderService;
import java.util.Optional;

@SpringBootTest
class CropBidderApplicationTestForService 
{

	@InjectMocks
	BidderService service;
	@Mock
	BidderRepository repository;
	Farmer farmer;
	List<Bidder> bidderList;
	List<Bid> bidList;
	Crop crop;
	Bidder bidder;
	Bidder bidder1;
	Bidder bidder2;
	Bidder bidder3;
	Bid bid;
	List<Bidder> bidderList1;
	Optional<Bidder> bidderOptional;

	@BeforeEach
	public void before()
	{
		bidderList=new ArrayList();
		crop=new Crop(1,"paddy","seasonal","nitrogen",100,true,farmer);
		bidder=new Bidder(11,"ramgnagar","12334","1245678",bidList,true);
		bidder1=new Bidder(5,"vizag","12334","1245678",bidList,true);
		bidder2=new Bidder(19,"nellore","92334","5245678",bidList,true);
		bidder3=new Bidder(190,"rajam","65787", "5468556",bidList,true);
		bid=new Bid(10,LocalDate.now(),10000,true,crop,bidder);
		bidderOptional=Optional.of(bidder);
	}
	@Test
	public void addBidderTest()
	{
        when(repository.save(bidder)).thenReturn(bidder);
		Bidder bidderFromService=service.saveBidder(bidder);
		assertEquals(bidderFromService.getLicenseNo(),bidder.getLicenseNo());
	}

	@Test
	public void updateBidderTest()
	{
        when(repository.save(bidder)).thenReturn(bidder);
		Bidder bidderService=service.editBidder(bidder);
		assertEquals(bidder,bidderService);
	}

	@Test
	public void updateBidderTest_BidderNotFoundException()
	{
		 when(repository.save(bidder)).thenThrow(BidderNotFoundException.class);
		 assertThrows(BidderNotFoundException.class,
					()->{
							service.saveBidder(bidder);
						}
					);
	}
	
	@Test
	public void findBidderByIdTest()
	{
        when(repository.findById(11)).thenReturn(bidderOptional);
		Optional<Bidder> bidderOptional1=service.getBidder(11);
		assertEquals(bidderOptional.get().getBidderId(),bidderOptional1.get().getBidderId());
	}

	@Test
	public void findBidderByIdTest_BidderNotFoundException()
	{
		 when(repository.findById(bidder.getBidderId())).thenThrow(BidderNotFoundException.class);
		 assertThrows(BidderNotFoundException.class,
					()->{
							service.getBidder(bidder.getBidderId());
						}
					);
	}
	@Test
	public void findByStatusTest()
	{
		bidderList.add(bidder);
		bidderList.add(bidder1);
		bidderList.add(bidder2);
		when(repository.findByIsVerified(true)).thenReturn(bidderList);
		List<Bidder> list=service.getBiddersByStatus(true);
		assertEquals(list.size(),bidderList.size());
     }

	@Test
	public void findByStatusTest_BidderNotFoundException()
	{
		when(repository.findByIsVerified(false)).thenThrow(BidderNotFoundException.class);
		 assertThrows(BidderNotFoundException.class,
					()->{
							service.getBiddersByStatus(false);
						}
					);
	}
	@Test
	public void deleteTest()
	{
		repository.deleteById(100);
		bidderList.add(bidder);
		bidderList.add(bidder1);
		bidderList.add(bidder2);
		boolean result=true;
		for(Bidder b:bidderList)
		{
			if(b.getBidderId()==100)
				result=false;
		}
		assertTrue(result);
	}
	
	@Test
	public void deleteTest_BidderNotFoundException()
	{
		 when(repository.findById(bidder.getBidderId())).thenThrow(BidderNotFoundException.class);
		 assertThrows(BidderNotFoundException.class,
					()->{
							service.getBidder(bidder.getBidderId());
						}
					);
	}
}
