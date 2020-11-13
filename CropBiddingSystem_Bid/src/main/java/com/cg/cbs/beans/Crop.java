package com.cg.cbs.beans;

import javax.persistence.*;

@Entity
public class Crop 
{
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
	private int cropId;
    private String cropName;	// Wheat/Rice/Cotton/Lentils/Sugarcane
	private String cropType;	// Kharif/Rabi/Zaid
	private String fertilizer;	// Nitrogen based/Phosphorus based and Complex
	private double quantity;	// Tons/Kgs
	private double basePrice;
	private boolean isApproved;
	@ManyToOne(cascade= {CascadeType.PERSIST,CascadeType.MERGE})
	private Farmer farmer;
	
	public Crop() {
		super();
	}
	public Crop(int cropId, String cropName, String cropType, String fertilizer, double quantity, double basePrice,
			boolean isApproved, Farmer farmer) {
		super();
		this.cropId = cropId;
		this.cropName = cropName;
		this.cropType = cropType;
		this.fertilizer = fertilizer;
		this.quantity = quantity;
		this.basePrice = basePrice;
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
	public double getBasePrice() {
		return basePrice;
	}
	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
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
				+ fertilizer + ", quantity=" + quantity + ", basePrice=" + basePrice + ", isApproved=" + isApproved
				+ ", farmer=" + farmer.getFarmerId()+ "]";
	}
}