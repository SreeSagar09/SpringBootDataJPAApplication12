package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	@Query(value = "from Product p")
	public List<Product> getAllProducts();
	
	@Modifying
	@Transactional
	@Query(value = "insert into product (product_code, product_name, quantity, price) values (?1, ?2, ?3, ?4)", nativeQuery = true)
	public Integer saveProduct(String productCode, String productName, Integer quantity, Double price);
	
	@Modifying
	@Transactional
	@Query(value = "update Product p set p.productCode =?1, p.productName =?2, p.quantity =?3, p.price =?4 where p.productId =?5")
	public Integer updateProduct(String productCode, String productName, Integer quantity, Double price, Integer productId);
	
	@Modifying
	@Transactional
	@Query(value = "delete from Product p where p.productId =?1")
	public Integer deleteProduct(Integer productId);
	
	@Modifying
	@Transactional
	@Query(value = "delete from Product p")
	public Integer deleteAllProducts();
}
