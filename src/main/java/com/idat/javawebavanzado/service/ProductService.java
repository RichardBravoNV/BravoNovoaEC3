package com.idat.javawebavanzado.service;

import java.util.List;

import com.idat.javawebavanzado.model.Product;



public interface ProductService {

	public List<Product> getAllProduct();
	 
	 public Product getProductById(long id);
	 
	 public void saveOrUpdate(Product article);
	 
	 public void deleteProduct(long id);
	
}
