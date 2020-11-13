package com.cg.cbs.entity;

import java.util.List;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Farmer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int farmerId;
	private String village;
	private String district;
	private boolean isVerified;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "farmer")
	private List<Crop> crops;

	public Farmer() {
		
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
	public boolean isVerified() {
		return isVerified;
	}
	public void setVerified(boolean isVerified) {
		this.isVerified = isVerified;
	}
	@JsonManagedReference
	public List<Crop> getCrops() {
		return crops;
	}
	public void setCrops(List<Crop> crops) {
		this.crops = crops;
	}
	
	@Override
	public String toString() {
		return "Farmer [farmerId=" + farmerId + ", village=" + village + ", district=" + district + ", isVerified="
				+ isVerified + ", crops=" + crops + "]";
	}
}