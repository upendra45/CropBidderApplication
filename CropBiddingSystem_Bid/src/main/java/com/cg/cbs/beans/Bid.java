package com.cg.cbs.beans;

import java.time.LocalDate;
import javax.persistence.*;

@Entity
public class Bid {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private int bidId;
	private LocalDate date;
	private double amount;
	private boolean isWinningBid;
	@OneToOne(cascade= {CascadeType.PERSIST,CascadeType.MERGE})
	Crop crop;
	@ManyToOne(cascade= {CascadeType.PERSIST,CascadeType.MERGE})
	Bidder bidder;
	
	public Bid() {
		super();
	}
	public Bid(int bidId, LocalDate date, double amount, boolean isWinningBid, Crop crop, Bidder bidder) 
	{
		super();
		this.bidId = bidId;
		this.date = date;
		this.amount = amount;
		this.isWinningBid = isWinningBid;
		this.crop = crop;
		this.bidder = bidder;
	}
	public int getBidId() {
		return bidId;
	}
	public void setBidId(int bidId) {
		this.bidId = bidId;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public boolean isWinningBid() {
		return isWinningBid;
	}
	public void setWinningBid(boolean isWinningBid) {
		this.isWinningBid = isWinningBid;
	}
	public Crop getCrop() {
		return crop;
	}
	public void setCrop(Crop crop) {
		this.crop = crop;
	}
	public Bidder getBidder() {
		return bidder;
	}
	public void setBidder(Bidder bidder) {
		this.bidder = bidder;
	}
	@Override
	public String toString() {
		return "Bid [bidId=" + bidId + ", date=" + date + ", amount=" + amount + ", isWinningBid=" + isWinningBid
				+ ", cropId=" + crop.getCropId() +", bidderId=" + bidder.getBidderId() + "]";
	}
}