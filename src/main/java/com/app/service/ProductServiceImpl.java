package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.Product;
import com.app.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public List<Product> getAllProducts() {
		try {
			List<Product> productList = productRepository.getAllProducts();
			
			return productList;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public Integer saveProduct(Product product) {
		try {
			Integer count = productRepository.saveProduct(product.getProductCode(), product.getProductName(), product.getQuantity(), product.getPrice());
			
			return count;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public Integer updateProduct(Product product) {
		try {
			Integer count = productRepository.updateProduct(product.getProductCode(), product.getProductName(), product.getQuantity(), product.getPrice(), product.getProductId());
			
			return count;
		} catch (Exception e) {
			throw e;
		}
	}
	
	@Override
	public Integer deleteProduct(Integer productId) {
		try {
			Integer count = productRepository.deleteProduct(productId);
			
			return count;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public Integer deleteAllProducts() {
		try {
			Integer count = productRepository.deleteAllProducts();
			
			return count;
		} catch (Exception e) {
			throw e;
		}
	}

}
