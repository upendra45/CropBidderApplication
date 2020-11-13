package com.cg.cbs.beans;

import java.util.List;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Bidder {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private int bidderId;
	private String city;
	private String licenseNo;
	private String pan;
	@OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE})
	private List<Bid> bids;
	private boolean isVerified;
	
	public Bidder() {
		super();
	}
	public Bidder(int bidderId, String city, String licenseNo, String pan,boolean isVerified) {
		super();
		this.bidderId = bidderId;
		this.city = city;
		this.licenseNo = licenseNo;
		this.pan = pan;
		this.isVerified = isVerified;
	}
	public int getBidderId() {
		return bidderId;
	}
	public void setBidderId(int bidderId) {
		this.bidderId = bidderId;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getLicenseNo() {
		return licenseNo;
	}
	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	@JsonBackReference
	public List<Bid> getBids() {
		return bids;
	}
	public void setBids(List<Bid> bids) {
		this.bids = bids;
	}
	public boolean isVerified() {
		return isVerified;
	}
	public void setVerified(boolean isVerified) {
		this.isVerified = isVerified;
	}
	@Override
	public String toString() {
		return "Bidder [bidderId=" + bidderId + ", city=" + city + ", licenseNo=" + licenseNo + ", pan=" + pan
				+ ", isVerified=" + isVerified + "]";
	}	
}