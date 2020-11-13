package com.cg.cbs.beans;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.*;

@Entity
public class Farmer 
{
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private int farmerId;
	private String village;
	private String district;
	@OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE})
	private List<Crop> crops;
	boolean isVerified;
	
	public Farmer() {
		super();
	}
	public Farmer(int farmerId, String village, String district, boolean isVerified) {
		super();
		this.farmerId = farmerId;
		this.village = village;
		this.district = district;
		this.isVerified = isVerified;
	}
	public int getFarmerId() {
		return farmerId;
	}
	public void setFarmerId(int farmerId) {
		this.farmerId = farmerId;
	}
	public String getVillage() {
		return village;
	}
	public void setVillage(String village) {
		this.village = village;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	@JsonBackReference
	public List<Crop> getCrops() {
		return crops;
	}
	public void setCrops(List<Crop> crops) {
		this.crops = crops;
	}
	public boolean isVerified() {
		return isVerified;
	}
	public void setVerified(boolean isVerified) {
		this.isVerified = isVerified;
	}
	@Override
	public String toString() {
		return "Farmer [farmerId=" + farmerId + ", village=" + village + ", district=" + district 
				+ ", isVerified=" + isVerified + "]";
	}
}