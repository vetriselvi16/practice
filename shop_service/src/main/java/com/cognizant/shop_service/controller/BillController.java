package com.cognizant.shop_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.shop_service.model.Bill;
import com.cognizant.shop_service.service.BillService;

@RequestMapping("/bill")
@RestController
public class BillController {

	@Autowired
	BillService billServ;
	
	
	/*@PostMapping("")
	public void generateBill(@RequestBody Bill bill)
	{
		billServ.generateBill(bill);
	}*/
	
	@PostMapping("")
	public void generateBill(@RequestBody Bill bill)
	{
		billServ.generateBill(bill);
	}
	
	
}
