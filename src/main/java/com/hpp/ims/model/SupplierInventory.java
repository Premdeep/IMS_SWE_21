package com.hpp.ims.model;

public class SupplierInventory {
	
	private int supplierInventoryId;
	private int supplierId;
	private int productId;
	private String productName;
	private int currentQuantity;
	private int productPrice;
	public int getSupplierInventoryId() {
		return supplierInventoryId;
	}
	public void setSupplierInventoryId(int supplierInventoryId) {
		this.supplierInventoryId = supplierInventoryId;
	}
	public int getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
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
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	@Override
	public String toString() {
		return "SupplierInventory [supplierInventoryId=" + supplierInventoryId + ", supplierId=" + supplierId
				+ ", productId=" + productId + ", productName=" + productName + ", currentQuantity=" + currentQuantity
				+ ", productPrice=" + productPrice + "]";
	}
	public SupplierInventory() {
		System.out.println("Supplier Inventory Constructor");
	}
	
	
	

}
