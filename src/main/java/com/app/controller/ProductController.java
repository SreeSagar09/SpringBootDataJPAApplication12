package com.app.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.Product;
import com.app.service.ProductService;

@Controller
@RequestMapping(path = "/product")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@GetMapping(path = "/getAllProducts")
	public ResponseEntity<List<Product>> getAllProducts(){
		
		ResponseEntity<List<Product>> responseEntity = null;
		try {
			List<Product> productList = productService.getAllProducts();
			
			responseEntity = new ResponseEntity<List<Product>>(productList, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}
	
	@PostMapping(path = "/saveProduct")
	public ResponseEntity<Map<String, Object>> saveProduct(@RequestBody Product product){

		ResponseEntity<Map<String, Object>> responseEntity = null;
		try {
			Integer count = productService.saveProduct(product);
			
			Map<String, Object> responseMap = new LinkedHashMap<>();
			responseMap.put("count", count);
			
			responseEntity = new ResponseEntity<Map<String,Object>>(responseMap, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}
	
	@PutMapping(path = "/updateProduct")
	public ResponseEntity<Map<String, Object>> updateProduct(@RequestBody Product product){
		ResponseEntity<Map<String, Object>> responseEntity = null;
		try {
			Integer count = productService.updateProduct(product);
			
			Map<String, Object> responseMap = new LinkedHashMap<>();
			responseMap.put("count", count);
			
			responseEntity = new ResponseEntity<Map<String,Object>>(responseMap, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}
	
	@DeleteMapping(path = "/deleteProduct")
	public ResponseEntity<Map<String, Object>> deleteProduct(@RequestParam Integer productId){
		
		ResponseEntity<Map<String, Object>> responseEntity = null;
		try {
			Integer count = productService.deleteProduct(productId);
			
			Map<String, Object> responseMap = new LinkedHashMap<>();
			responseMap.put("count", count);
			
			responseEntity = new ResponseEntity<Map<String,Object>>(responseMap, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}
	
	@DeleteMapping(path = "/deleteAllProducts")
	public ResponseEntity<Map<String, Object>> deleteAllProducts(){
		
		ResponseEntity<Map<String, Object>> responseEntity = null;
		try {
			Integer count = productService.deleteAllProducts();
			
			Map<String, Object> responseMap = new LinkedHashMap<>();
			responseMap.put("count", count);
			
			responseEntity = new ResponseEntity<Map<String,Object>>(responseMap, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}
	
}
