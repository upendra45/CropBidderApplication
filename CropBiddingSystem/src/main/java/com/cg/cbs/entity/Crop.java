package com.cg.cbs.entity;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Crop {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cropId;
	private String cropName;	
	private String cropType;	
	private String fertilizer;	
	private double quantity;	
	private double basePrice;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@ManyToOne
	@JoinColumn(name="farmer_id")
	private Farmer farmer;

	public Crop() {
	
	}

	public Crop(int cropId, String cropName, String cropType, String fertilizer, double quantity, double basePrice,
			Status status, Farmer farmer) {
		super();
		this.cropId = cropId;
		this.cropName = cropName;
		this.cropType = cropType;
		this.fertilizer = fertilizer;
		this.quantity = quantity;
		this.basePrice = basePrice;
		this.status = status;
		this.farmer = farmer;
	}

	public Crop(String cropName, String cropType, String fertilizer, double quantity, double basePrice, Status status,
			Farmer farmer) {
		super();
		this.cropName = cropName;
		this.cropType = cropType;
		this.fertilizer = fertilizer;
		this.quantity = quantity;
		this.basePrice = basePrice;
		this.status = status;
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
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}

	@JsonBackReference
	public Farmer getFarmer() {
		return farmer;
	}
	public void setFarmer(Farmer farmer) {
		this.farmer = farmer;
	}
	
	@Override
	public String toString() {
		return "Crop [cropId=" + cropId + ", cropName=" + cropName + ", cropType=" + cropType + ", fertilizer="
				+ fertilizer + ", quantity=" + quantity + ", basePrice=" + basePrice + ", farmer=" + farmer + "]";
	}	
}
