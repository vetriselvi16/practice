package com.cognizant.authenticationservice.model;


import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="product")
public class Product 
{
	@Id
	@Column(name="pro_code")
	private String code;
	@Column(name="pro_name")
	private String name;
	@Column(name="pro_type")
	private int type;
	@Column(name="pro_brand")
	private String brand;
	@Column(name="pro_quantity_type")
	private int quantityType;
	@Column(name="pro_rate_per_quantity")
	private int ratePerQuantity;
	@Column(name="pro_stock_count")
	private int stockCount;
	@Column(name="pro_add_date")
	private Date addDate;
	@Column(name="pro_aisle")
	private String aisle;
	@Column(name="pro_shelf")
	private String shelf;
	@Column(name="pro_date_of_manufacture")
	private Date dateOfManufacture;
	@Column(name="pro_date_of_expiry")
	private Date dateOfExpiry;
	@Column(name="pro_image")
	private String image;
	
	/*@JsonIgnore
	@ManyToMany(mappedBy = "products", fetch = FetchType.EAGER)
	private List<Purchase> purchases;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "products", fetch = FetchType.EAGER)
	private List<Quantity> quantity;
*/

	@JsonBackReference
	@OneToMany(mappedBy="product")
	private Set<PurchaseDetail> purDet;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getQuantityType() {
		return quantityType;
	}
	public void setQuantityType(int quantityType) {
		this.quantityType = quantityType;
	}
	public int getRatePerQuantity() {
		return ratePerQuantity;
	}
	public void setRatePerQuantity(int ratePerQuantity) {
		this.ratePerQuantity = ratePerQuantity;
	}
	public int getStockCount() {
		return stockCount;
	}
	public void setStockCount(int stockCount) {
		this.stockCount = stockCount;
	}
	public Date getAddDate() {
		return addDate;
	}
	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}
	public String getAisle() {
		return aisle;
	}
	public void setAisle(String aisle) {
		this.aisle = aisle;
	}
	public String getShelf() {
		return shelf;
	}
	public void setShelf(String shelf) {
		this.shelf = shelf;
	}
	public Date getDateOfManufacture() {
		return dateOfManufacture;
	}
	public void setDateOfManufacture(Date dateOfManufacture) {
		this.dateOfManufacture = dateOfManufacture;
	}
	public Date getDateOfExpiry() {
		return dateOfExpiry;
	}
	public void setDateOfExpiry(Date dateOfExpiry) {
		this.dateOfExpiry = dateOfExpiry;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Set<PurchaseDetail> getPurDet() {
		return purDet;
	}
	public void setPurDet(Set<PurchaseDetail> purDet) {
		this.purDet = purDet;
	}
	@Override
	public String toString() {
		return "Product [code=" + code + ", name=" + name + ", type=" + type + ", brand=" + brand + ", quantityType="
				+ quantityType + ", ratePerQuantity=" + ratePerQuantity + ", stockCount=" + stockCount + ", addDate="
				+ addDate + ", aisle=" + aisle + ", shelf=" + shelf + ", dateOfManufacture=" + dateOfManufacture
				+ ", dateOfExpiry=" + dateOfExpiry + ", image=" + image + "]";
	}
	
	
	
	
	
}
