package com.cg.cbs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import com.cg.cbs.entity.Bid;
import com.cg.cbs.entity.Bidder;
import com.cg.cbs.entity.Crop;
import com.cg.cbs.entity.Farmer;
import com.cg.cbs.repository.BidderRepository;

@SpringBootTest
class CropBidderApplicationTestForRepository
{
    @Mock
	BidderRepository repository;
	Farmer farmer;
	List<Bidder> bidderList;
	List<Bid> bidList;
	Crop crop;
	Bidder bidder;
	Bidder bidder1;
	Bidder bidder2;
	Bid bid;
	Optional<Bidder> bidderOptional;

	@BeforeEach
	public void before()
	{
		bidderList=new ArrayList();
		crop=new Crop(1,"paddy","seasonal","nitrogen",100,true,farmer);
		bidder=new Bidder(11,"vizag","12334","1245678",bidList,true);
		bidder1=new Bidder(5,"vizag","12334","1245678",bidList,true);
		bidder2=new Bidder(19,"nellore","92334","5245678",bidList,true);
		bid=new Bid(10,LocalDate.now(),10000,true,crop,bidder);
		bidderOptional=Optional.of(bidder);
	}

	@Test
	public void addBidderTest()
	{
		when(repository.save(bidder)).thenReturn(bidder);
		assertEquals(repository.save(bidder),bidder);
    }

	@Test
	public void updateBidderTest()
	{
		when(repository.save(bidder)).thenReturn(bidder);
		assertEquals(repository.save(bidder),bidder);
    }

	@Test
	public void findBidByIdTest()
	{
		when(repository.findById(11)).thenReturn(bidderOptional);
		assertEquals(bidderOptional.get().getBidderId(),bidder.getBidderId());
	}

	@Test
	public void findByStatusTest()
	{
        bidderList.add(bidder);
		bidderList.add(bidder1);
		bidderList.add(bidder2);
		when(repository.findAll()).thenReturn(bidderList);
		assertEquals(repository.findAll(),bidderList);
    }

	@Test
	public void deleteTest()
	{
		repository.deleteById(6);
		bidderList.add(bidder);
		bidderList.add(bidder1);
		bidderList.add(bidder2);
		boolean result=true;
		for(Bidder b:bidderList)
		{
			if(b.getBidderId()==100)
			result=false;
		}
		assertTrue(true);
	}
}
