package com.cognizant.shop_service.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.shop_service.model.Product;
import com.cognizant.shop_service.repository.ProductRepository;


@Service
public class ProductService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductService.class);
	@Autowired
	ProductRepository proRep;
	
	public List<Product> getProductListAdmin()
	{
		return proRep.findAll();
	}
	public List<Product> getProductListCustomer()
	{
		return proRep.getProductListCustomer();
	}
	public Product getProductByCode(String code)
	{
		return proRep.getProductByCode(code);
	}
	
	public Product modifyProductDetail(Product product)
	{
		Product modified = proRep.getProductByCode(product.getCode());
		//modified.setId(product.getId());
		modified.setName(product.getName());
		modified.setCode(product.getCode());
		modified.setBrand(product.getBrand());
		modified.setType(product.getType());
		modified.setQuantityType(product.getQuantityType());
		modified.setRatePerQuantity(product.getRatePerQuantity());
		modified.setStockCount(product.getStockCount());
		modified.setAddDate(product.getAddDate());
		modified.setAisle(product.getAisle());
		modified.setShelf(product.getShelf());
		modified.setDateOfManufacture(product.getDateOfManufacture());
		modified.setDateOfExpiry(product.getDateOfExpiry());
		modified.setImage(product.getImage());
		modified = proRep.save(modified);
		return modified;
	}
	
	public List<Product> addProduct(Product product)
	{
		List<Product> pro = proRep.findAll();
		pro.add(product);
		pro = proRep.saveAll(pro);
		return pro;
	}
	 public List<Product> removeProduct(String code)
	 {
		 /*List<Product> pro = proRep.findAll();
		 Product delete=proRep.getProductByCode(code);
		 pro.remove(delete);
		 pro = proRep.saveAll(pro);
		 return pro;*/
		 proRep.deleteById(code);
		 return proRep.findAll();
	
	 }
}
