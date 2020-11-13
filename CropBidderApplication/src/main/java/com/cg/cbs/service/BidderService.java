package com.cg.cbs.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.cbs.entity.Bidder;
import com.cg.cbs.exception.BidderNotFoundException;
import com.cg.cbs.repository.BidderRepository;

@Service
public class BidderService {

	@Autowired
	BidderRepository bidderRepository;

	public List<Bidder> getAllBidders()
	{
		List<Bidder> list=bidderRepository.findAll();
		if(list.isEmpty())
		{
			throw new BidderNotFoundException("The list is empty"); 
		}
		return list;
	}

	public Optional<Bidder> getBidder(int id)throws BidderNotFoundException
	{
		Optional<Bidder> bidder = bidderRepository.findById(id);
		if (!bidder.isPresent())
		{
			throw new BidderNotFoundException("bidder not found with the given id");
		}
		return bidderRepository.findById(id);
	}

	public Bidder saveBidder(Bidder bidder)
	{
		
		return bidderRepository.save(bidder);
	}

	public Bidder editBidder(Bidder bidder)
	{
		Bidder bidderObject=bidderRepository.findById(bidder.getBidderId()).orElse(null);
		if (bidderObject==null)
		{
			throw new BidderNotFoundException("Not found bidder with id : " + bidder.getBidderId() + " to update");
		}
		
		return bidderRepository.save(bidder);
	}
	public List<Bidder> getBiddersByStatus(boolean status)
	{
		List<Bidder> list=bidderRepository.findByIsVerified(status);
		if(list.isEmpty())
		{
			throw new BidderNotFoundException("No bidders found with the given status"); 
		}
		return list;
		
	}
	public void deleteBidder(int id)
	{
		Optional<Bidder> bidder = bidderRepository.findById(id);
		System.out.println(bidder);
		if (!bidder.isPresent())
		{
			throw new BidderNotFoundException("Not Bidder found  with id : " + id + " to delete");
		}
		bidderRepository.deleteById(id);
	}
}

