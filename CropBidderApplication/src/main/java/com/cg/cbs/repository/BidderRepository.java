package com.cg.cbs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.cbs.entity.Bidder;

public interface BidderRepository extends JpaRepository<Bidder,Integer>
{

	public List<Bidder> findByIsVerified(boolean status);

}
