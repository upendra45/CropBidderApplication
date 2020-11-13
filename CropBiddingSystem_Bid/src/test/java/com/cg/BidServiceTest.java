package com.cg;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import com.cg.cbs.beans.Bid;
import com.cg.cbs.beans.Bidder;
import com.cg.cbs.beans.Crop;
import com.cg.cbs.beans.Farmer;
import com.cg.cbs.exception.BidNotFoundException;
import com.cg.cbs.repository.BidRepository;
import com.cg.cbs.service.BidService;

@ExtendWith(MockitoExtension.class)
class BidServiceTest 
{
	@Mock
	BidRepository bidRepository;
	
	@InjectMocks
	BidService bidService;
	
	Farmer farmer ;
	Crop crop1;
	Crop crop2;
	Bidder bidder1;
	Bidder bidder2;
	Bid bid1;
	Bid bid2;
	
	@BeforeEach
	public void setup()
	{
		farmer = new Farmer(1,"ramnagar","nellore",true);
		crop1=new Crop(1,"rice","rabi","nitrogen",5.5,20000,true,farmer);
		crop2=new Crop(2,"wheat","zaid","phosphorous",5,15000,true,farmer);
		bidder1=new Bidder(1,"hyderabad","432541","BNZY398974",true);
		bidder2=new Bidder(2,"secunderabad","459826","BNZY749872",true);
		bid1=new Bid(1,LocalDate.of(2020,8,18),25000,true,crop1,bidder1);
		bid2=new Bid(2,LocalDate.of(2020,3,13),20000,true,crop2,bidder1);
	}
	
	@Test 
	public void addBidTest()
	{
		when(bidRepository.save(bid1)).thenReturn(bid1);
		assertNotNull(bidService.addBid(bid1));
	}
	@Test
	public void editBidTestPass()
	{
		when(bidRepository.save(bid1)).thenReturn(bid1);
		assertNotNull(bidService.editBit(bid1));
	}
	@Test 
	public void editBidTestFail()
	{
		when(bidRepository.save(bid2)).thenThrow(BidNotFoundException.class);
		assertThrows(BidNotFoundException.class,
				()->{
					bidService.editBit(bid2);
					}
				);
	}
	@Test
	public void getBidByIdTestPass()
	{
		when(bidRepository.findById(1)).thenReturn(Optional.of(bid1));
		assertEquals(Optional.of(bid1), bidService.getBidById(1));
	}
	@Test
	public void getBidByIdTestFail()
	{
		when(bidRepository.findById(3)).thenThrow(BidNotFoundException.class);
		assertThrows(BidNotFoundException.class,
				()->{
					bidService.getBidById(3);
					}
				);
	}
	@Test
	public void getAllBidsTestPass()
	{
		List<Bid> bids=Stream.of(bid1,bid2).collect(Collectors.toList());
		when(bidRepository.findAll()).thenReturn(bids);
		assertEquals(bids,bidService.getAllBids());
	}
	@Test
	public void getAllBidsTestFails()
	{
		when(bidRepository.findAll()).thenThrow(BidNotFoundException.class);
		assertThrows(BidNotFoundException.class,
				()->{
					bidService.getAllBids();
					}
				);
	}
	@Test
	public void getBidsByBidderIdTestPass()
	{
		List<Bid> bids=Stream.of(bid1,bid2).collect(Collectors.toList());
		when(bidRepository.findByBidderId(1)).thenReturn(bids);
		assertEquals(bids, bidService.getBidsByBidder(1));
	}
	@Test
	public void getBidsByBidderIdTestFail()
	{
		when(bidRepository.findByBidderId(3)).thenThrow(BidNotFoundException.class);
		assertThrows(BidNotFoundException.class,
			()->{
				bidService.getBidsByBidder(3);
				}
			);
	}
	@Test
	public void getBidsByCropIdTestPass()
	{
		List<Bid> bids=Stream.of(bid1,bid2).collect(Collectors.toList());
		when(bidRepository.findByCropId(1)).thenReturn(bids);
		assertEquals(bids, bidService.getBidsByCrop(1));
	}
	@Test
	public void getBidsByCropIdTestFail()
	{
		when(bidRepository.findByCropId(4)).thenThrow(BidNotFoundException.class);
		assertThrows(BidNotFoundException.class,
				()->{
					bidService.getBidsByCrop(4);
					}
				);
	}
	@Test
	public void getWinningBidsTestPass()
	{
		List<Bid> bids=Stream.of(bid1,bid2).collect(Collectors.toList());
		when(bidRepository.findWinningBids(true)).thenReturn(bids);
		assertEquals(bids, bidService.getWinningBids(true));
	}
	@Test
	public void getWinningBidsTestFail()
	{
		when(bidRepository.findWinningBids(true)).thenThrow(BidNotFoundException.class);
		assertThrows(BidNotFoundException.class,
				()->{
					bidService.getWinningBids(true);
					}
				);
	}
}