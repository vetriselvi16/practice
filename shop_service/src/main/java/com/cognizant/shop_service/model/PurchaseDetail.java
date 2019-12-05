package com.cognizant.shop_service.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="purchase_detail")
public class PurchaseDetail {

	@Id
	@Column(name="pd_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	

	@OneToOne
	@JoinColumn(name="pd_pro_code")
	private Product product;
	
	
	@ManyToOne
	@JoinColumn(name="pd_pu_id")
	private Purchase purchase;
	
	@Column(name="pd_quantity")
	private int quantity;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Purchase getPurchase() {
		return purchase;
	}

	public void setPurchase(Purchase purchase) {
		this.purchase = purchase;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public PurchaseDetail(Product product, Purchase purchase, int quantity) {
		this.product = product;
		this.purchase = purchase;
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "PurchaseDetail [id=" + id + ", product=" + product + ", purchase=" + purchase + ", quantity=" + quantity
				+ "]";
	}

	public PurchaseDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	

}
