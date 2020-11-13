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
import com.cg.cbs.entity.Bidder;
import com.cg.cbs.exception.BidderNotFoundException;
import com.cg.cbs.service.BidderService;

@RestController
@RequestMapping("bidder")
public class BidderController {

	@Autowired
	BidderService bidderService;

	@GetMapping("")
	public List<Bidder> findAll()
	{
		return bidderService.getAllBidders();
	}

	@GetMapping("{id}")
	public ResponseEntity<Bidder> find(@PathVariable int id)
	{
		Optional<Bidder> bidder = bidderService.getBidder(id);
		return new ResponseEntity<Bidder>(bidder.get(), HttpStatus.OK);
	}

	@PostMapping("")
	public Bidder add(@RequestBody Bidder bidder)
	{
		return bidderService.saveBidder(bidder);
	}

	@PutMapping("")
	public ResponseEntity<Bidder> update(@RequestBody Bidder bidder)
	{
        bidderService.editBidder(bidder);
		return new ResponseEntity<Bidder>(bidder, HttpStatus.OK);
	}

	@GetMapping("status/{status}")
	public List<Bidder> findAllByStatus(@PathVariable boolean status)
	{
		return bidderService.getBiddersByStatus(status);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Bidder> delete(@PathVariable int id)
	{
        bidderService.deleteBidder(id);
		return new ResponseEntity<Bidder>(HttpStatus.OK);
	}
}
