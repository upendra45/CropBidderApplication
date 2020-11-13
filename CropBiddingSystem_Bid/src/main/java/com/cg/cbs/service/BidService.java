package com.cg.cbs.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cg.cbs.beans.Bid;
import com.cg.cbs.repository.BidRepository;

@Component
public class BidService 
{
	@Autowired
	BidRepository bidRepository;
	
	public Bid addBid(Bid bid)
	{
		return bidRepository.save(bid);
	}
	
	public Bid editBit(Bid bid)
	{
			return bidRepository.save(bid);
	}
	
	public void deleteBid(int bidId)
	{
		bidRepository.deleteById(bidId);
	}
	
	public Optional<Bid> getBidById(int bidId)
	{
		return bidRepository.findById(bidId);
	}
	
	public List<Bid> getBidsByBidder(int bidderId)
	{
		return bidRepository.findByBidderId(bidderId);
	}
	
	public List<Bid> getBidsByCrop(int cropId)
	{
		return bidRepository.findByCropId(cropId);
	}
	
	public List<Bid> getWinningBids(boolean bool)
	{
		return bidRepository.findWinningBids(bool);
	}
	
	public List<Bid> getAllBids()
	{
		return bidRepository.findAll();
	}
}