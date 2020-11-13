package com.cg.cbs.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.cbs.beans.Bid;

public interface BidRepository extends JpaRepository<Bid,Integer> 
{
	@Query("select b from Bid b where b.crop.cropId=?1")
	public List<Bid> findByCropId(int cropId);
	
	@Query("select b from Bid b where b.bidder.bidderId=?1")
	public List<Bid> findByBidderId(int bidderId);
	
	@Query("select b from Bid b where b.isWinningBid=?1")
	public List<Bid> findWinningBids(boolean bool);
}
