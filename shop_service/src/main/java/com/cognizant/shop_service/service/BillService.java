package com.cognizant.shop_service.service;

import java.util.Calendar;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.shop_service.model.Bill;
import com.cognizant.shop_service.model.Product;
import com.cognizant.shop_service.model.Purchase;
import com.cognizant.shop_service.model.PurchaseDetail;
import com.cognizant.shop_service.model.User;
import com.cognizant.shop_service.repository.ProductRepository;
import com.cognizant.shop_service.repository.PurchaseDetailRepository;
import com.cognizant.shop_service.repository.PurchaseRepository;
import com.cognizant.shop_service.repository.UserRepository;

@Service
public class BillService {

	@Autowired
	ProductRepository proRep;
	@Autowired
	UserRepository userRep;
	@Autowired
	PurchaseRepository purchaseRep;
	@Autowired
	PurchaseDetailRepository pdRep;
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(BillService.class);
	
	public void generateBill(Bill bill)
	{
		System.out.println("Bill");
		System.out.println(bill.getTotalAmount());
		int rewardPoints = ((int)bill.getTotalAmount()/5);
		User user = userRep.findByContactNumber(bill.getContactNumber());
		System.out.println(bill.getContactNumber());
		LOGGER.debug("User={}",user);
		Purchase pr = new Purchase(user,(int)bill.getTotalAmount(),rewardPoints,new java.sql.Date(Calendar.getInstance().getTime().getTime()));
		LOGGER.debug("Purchase={}",pr);
		purchaseRep.save(pr);
		PurchaseDetail pd = null;
		
		int i=0;
		//List<Product> pro[] = proRep.getProductByCode(bill.getCode());
		
		for(String code :bill.getCode())
		{
			Product pro = proRep.getProductByCode(code);
			LOGGER.debug("Product={}",pro);
			int Quantity = bill.getQuantity().get(i);
			String product = code;
			pd = new PurchaseDetail(pro,pr,Quantity);
			LOGGER.debug("PurchaseDetail={}",pd);
			int Stock = pro.getStockCount();
			pro.setStockCount(Stock-Quantity);
			i++;
			proRep.save(pro);
			pdRep.save(pd);	
			
			
			
		}
		
	}
	
}
