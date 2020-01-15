package com.idat.javawebavanzado.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.idat.javawebavanzado.model.Product;
import com.idat.javawebavanzado.repository.ProductRepository;


@Service
@Transactional
public class ProductServiceImpl implements ProductService {
 
 @Autowired
 ProductRepository ProductRepository;

 @Override
 public List<Product> getAllProduct() {
  return (List<Product>) ProductRepository.findAll();
 }

 @Override
 public Product getProductById(long id) {
  return ProductRepository.findById(id).get();
 }

 @Override
 public void saveOrUpdate(Product article) {
	 ProductRepository.save(article);
 }

 @Override
 public void deleteProduct(long id) {
	 ProductRepository.deleteById(id);
 }

}
