package com.cognizant.shop_service.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.shop_service.model.Product;
import com.cognizant.shop_service.security.AppUserDetailsService;
import com.cognizant.shop_service.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	ProductService proServ;
	@Autowired
	private AppUserDetailsService appUserDetailsService;
	
	@GetMapping
	public List<Product> getAllProduct()
	{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String user = authentication.getName();
		UserDetails userDetails = this.appUserDetailsService.loadUserByUsername(user);
		String role = userDetails.getAuthorities().toArray()[0].toString();
		System.out.println(role);
		if(role.equalsIgnoreCase("ADMIN") )
		{
			return proServ.getProductListAdmin();
		}
		else if(role.equalsIgnoreCase("USER"))
		{
			return proServ.getProductListCustomer();
		}
		return null;
	}
	@GetMapping("/{code}")
	public Product getProductByCode(@PathVariable("code") String code )
	{
		return proServ.getProductByCode(code);
	}
	
	@PutMapping("")
	public Product modifyProductDetail(@RequestBody Product product)
	{
		return proServ.modifyProductDetail(product);
		
	}
	
	@PostMapping("/new")
	public List<Product> addProduct(@RequestBody Product product)
	{
		return proServ.addProduct(product);
	}
	@DeleteMapping("/{code}")
	public List<Product> deletProduct(@PathVariable ("code") String code)
	{
		 return proServ.removeProduct(code);
		
	}
	
}
