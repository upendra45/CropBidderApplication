package com.cg.cbs.entity;
import javax.persistence.*;

import org.springframework.beans.factory.annotation.Autowired;
@Entity
public class Crop {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int cropId;
    private String cropName;	
	private String cropType;
	private String fertilizer;	
	private double quantity;	
	private boolean isApproved;
	
	
	@ManyToOne(cascade=CascadeType.ALL)
	Farmer farmer;
	public Crop()
	{}
	public Crop(int cropId, String cropName, String cropType, String fertilizer, double quantity, boolean isApproved,
			Farmer farmer) {
		super();
		this.cropId = cropId;
		this.cropName = cropName;
		this.cropType = cropType;
		this.fertilizer = fertilizer;
		this.quantity = quantity;
		this.isApproved = isApproved;
		this.farmer = farmer;
	}
	public int getCropId() {
		return cropId;
	}
	public void setCropId(int cropId) {
		this.cropId = cropId;
	}
	public String getCropName() {
		return cropName;
	}
	public void setCropName(String cropName) {
		this.cropName = cropName;
	}
	public String getCropType() {
		return cropType;
	}
	public void setCropType(String cropType) {
		this.cropType = cropType;
	}
	public String getFertilizer() {
		return fertilizer;
	}
	public void setFertilizer(String fertilizer) {
		this.fertilizer = fertilizer;
	}
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	public boolean isApproved() {
		return isApproved;
	}
	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}
	public Farmer getFarmer() {
		return farmer;
	}
	public void setFarmer(Farmer farmer) {
		this.farmer = farmer;
	}
	@Override
	public String toString() {
		return "Crop [cropId=" + cropId + ", cropName=" + cropName + ", cropType=" + cropType + ", fertilizer="
				+ fertilizer + ", quantity=" + quantity + ", isApproved=" + isApproved + ", farmer=" + farmer + "]";
	}	
}