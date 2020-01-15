package com.idat.javawebavanzado.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.idat.javawebavanzado.model.Product;
import com.idat.javawebavanzado.service.ProductService;






@Controller
@RequestMapping(value="/product")
public class ProductController {

 @Autowired
 ProductService ProductService;
 
 @RequestMapping(value="/list", method=RequestMethod.GET)
 public ModelAndView list() {
  ModelAndView model = new ModelAndView("Product_list");
  List<Product> productList = ProductService.getAllProduct();
  model.addObject("productList", productList);
  
  return model;
 }
 
 @RequestMapping(value="/addProduct/", method=RequestMethod.GET)
 public ModelAndView addArticle() {
  ModelAndView model = new ModelAndView();
  
  Product product = new Product();
model.addObject("ProductForm", product);
  model.setViewName("Product_form");
  
  return model;
 }
 
 @RequestMapping(value="/updateProduct/{id}", method=RequestMethod.GET)
 public ModelAndView editArticle(@PathVariable long id) {
  ModelAndView model = new ModelAndView();
  
  Product article = ProductService.getProductById(id);
  model.addObject("ProductForm", article);
  model.setViewName("Product_form");
  
  return model;
 }
 
 @RequestMapping(value="/saveArticle", method=RequestMethod.POST)
 public ModelAndView save(@ModelAttribute("ProductForm") Product article) {
  ProductService.saveOrUpdate(article);
  
  return new ModelAndView("redirect:/Product/list");
 }
 
 @RequestMapping(value="/deleteProduct/{id}", method=RequestMethod.GET)
 public ModelAndView delete(@PathVariable("id") long id) {
  ProductService.deleteProduct(id);
  
  return new ModelAndView("redirect:/Product/list");
 }
}