package com.cg.cbs.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.cbs.beans.Bid;
import com.cg.cbs.exception.BidNotFoundException;
import com.cg.cbs.service.BidService;

@RestController
@RequestMapping("/bids")
public class BidController 
{
	@Autowired
	BidService bidService;
	
	@PostMapping("/add")
	public ResponseEntity<Bid> add(@RequestBody Bid bid)
	{
		return new ResponseEntity<Bid>(bidService.addBid(bid),HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Bid> updateBid(@RequestBody Bid bid)
	{
		Optional<Bid> bidObj=bidService.getBidById(bid.getBidId());
		if(!bidObj.isPresent())
		{
			throw new BidNotFoundException("Bid not found with Id : "+ bid.getBidId() + " to update.");
		}
		return new ResponseEntity<Bid>(bidService.editBit(bid),HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{bidId}")
	public ResponseEntity<Bid> delete(@PathVariable int bidId)
	{
		Optional<Bid> bidObj=bidService.getBidById(bidId);
		if(!bidObj.isPresent())
		{
			throw new BidNotFoundException("Bid not found with Id : "+ bidId + " to delete.");
		}
		bidService.deleteBid(bidId);
		return new ResponseEntity<Bid>(HttpStatus.OK);
	}
	
	@GetMapping("/getById/{bidId}")
	public ResponseEntity<Bid> findBidById(@PathVariable int bidId)
	{
		Optional<Bid> bidObj=bidService.getBidById(bidId);
		if(!bidObj.isPresent())
		{
			throw new BidNotFoundException("Bid not found with Id : " + bidId + " to return");
		}
		return new ResponseEntity<Bid>(bidObj.get(),HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Bid>> findAllBids()
	{
		return new ResponseEntity<List<Bid>>(bidService.getAllBids(),HttpStatus.OK);
	}
	
	@GetMapping("/bidderId/{bidderId}")
	public ResponseEntity<List<Bid>> findBidsByBidderId(@PathVariable int bidderId)
	{
		List<Bid> bids=bidService.getBidsByBidder(bidderId);
		if(bids.isEmpty())
		{
			throw new BidNotFoundException("Bid not found with bidderId : "+ bidderId + " to return");
		}
		return new ResponseEntity<List<Bid>>(bids,HttpStatus.OK);
	}
	
	@GetMapping("/cropId/{cropId}")
	public ResponseEntity<List<Bid>> findBidsByCropId(@PathVariable int cropId)
	{
		List<Bid> bids=bidService.getBidsByCrop(cropId);
		if(bids.isEmpty())
		{
			throw new BidNotFoundException("Bid not found with bidderId : "+ cropId + " to return");
		}
		return new ResponseEntity<List<Bid>>(bids,HttpStatus.OK);
	}
	
	@GetMapping("/winningBids/{bool}")
	public ResponseEntity<List<Bid>> findWinningBids(@PathVariable boolean bool)
	{
		List<Bid> winbids=bidService.getWinningBids(bool);
		if(winbids.isEmpty())
		{
			throw new BidNotFoundException("No Winning Bids Found to return");
		}
		return new ResponseEntity<List<Bid>>(winbids,HttpStatus.OK);
	}
}