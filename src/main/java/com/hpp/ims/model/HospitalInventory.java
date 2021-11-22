package com.hpp.ims.model;

public class HospitalInventory {
	
	private int hospitalInventoryId;
	private int hospitalId;;
	private int productId;
	private String productName;
	private int currentQuantity;
	private int minQuanReq;
	private int maxQuantity;
	private int productPrice;
	public int getHospitalInventoryId() {
		return hospitalInventoryId;
	}
	public void setHospitalInventoryId(int hospitalInventoryId) {
		this.hospitalInventoryId = hospitalInventoryId;
	}
	public int getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(int hospitalId) {
		this.hospitalId = hospitalId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getCurrentQuantity() {
		return currentQuantity;
	}
	public void setCurrentQuantity(int currentQuantity) {
		this.currentQuantity = currentQuantity;
	}
	public int getMinQuanReq() {
		return minQuanReq;
	}
	public void setMinQuanReq(int minQuanReq) {
		this.minQuanReq = minQuanReq;
	}
	public int getMaxQuantity() {
		return maxQuantity;
	}
	public void setMaxQuantity(int maxQuantity) {
		this.maxQuantity = maxQuantity;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	@Override
	public String toString() {
		return "HospitalInventory [hospitalInventoryId=" + hospitalInventoryId + ", hospitalId=" + hospitalId
				+ ", productId=" + productId + ", productName=" + productName + ", currentQuantity=" + currentQuantity
				+ ", minQuanReq=" + minQuanReq + ", maxQuantity=" + maxQuantity + ", productPrice=" + productPrice
				+ "]";
	}
	public HospitalInventory() {
		
		System.out.println("Hospital Inventory Constructor ");
	}
	
	

}
