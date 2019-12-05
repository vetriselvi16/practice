package com.cognizant.shop_service.model;

import java.util.List;

public class Bill {
	
	//private List<Product> productList;
	private List<Integer> quantity;
	private Long contactNumber;
	private double totalAmount;
	private List<String> code; 
	
	
	
	/*public List<Product> getProductList() {
		return productList;
	}
	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}*/
	
	public List<Integer> getQuantity() {
		return quantity;
	}
	public void setQuantity(List<Integer> quantity) {
		this.quantity = quantity;
	}
	public Long getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(Long contactNumber) {
		this.contactNumber = contactNumber;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotal(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public List<String> getCode() {
		return code;
	}
	public void setCode(List<String> code) {
		this.code = code;
	}
	@Override
	public String toString() {
		return "Bill [quantity=" + quantity + ", contactNumber=" + contactNumber + ", totalAmount=" + totalAmount + ", code=" + code + "]";
	}
	
	
	
	
}
