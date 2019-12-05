package com.cognizant.shop_service.model;

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
import javax.persistence.Table;

@Entity
@Table(name="purchase")
public class Purchase {

	@Id
	@Column(name="pu_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	@ManyToOne
	@JoinColumn(name="pu_us_id")
	private User user;

	
	@Column(name="pu_total_amount")
	private int total;
	
	@Column(name="pu_reward_points")
	private int rewardPoints;
	
	@Column(name="pu_date")
	private Date dateOfPurchase;
	
	@OneToMany(mappedBy="purchase")
	private List<PurchaseDetail> purchaseDetails;

	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getRewardPoints() {
		return rewardPoints;
	}

	public void setRewardPoints(int rewardPoints) {
		this.rewardPoints = rewardPoints;
	}

	public Date getDateOfPurchase() {
		return dateOfPurchase;
	}

	public void setDateOfPurchase(Date dateOfPurchase) {
		this.dateOfPurchase = dateOfPurchase;
	}

	public List<PurchaseDetail> getPurchaseDetails() {
		return purchaseDetails;
	}

	public void setPurchaseDetails(List<PurchaseDetail> purchaseDetails) {
		this.purchaseDetails = purchaseDetails;
	}

	public Purchase() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Purchase( User user, int total, int rewardPoints, Date dateOfPurchase
			) {
		super();
		
		this.user = user;
		this.total = total;
		this.rewardPoints = rewardPoints;
		this.dateOfPurchase = dateOfPurchase;
		
	}

	@Override
	public String toString() {
		return "Purchase [id=" + id + ", user=" + user + ", total=" + total + ", rewardPoints=" + rewardPoints
				+ ", dateOfPurchase=" + dateOfPurchase + "]";
	}

	

}
