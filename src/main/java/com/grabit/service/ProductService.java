package com.grabit.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.grabit.exception.ProductException;
import com.grabit.model.Product;
import com.grabit.request.CreateProductRequest;

public interface ProductService {
	
	public Product createProduct(CreateProductRequest req);
	
	public String deleteProduct(Long ptoductId) throws ProductException;
	
	public Product updateProduct(Long productId, Product req) throws ProductException;
	
	public Product findProductById(Long Id) throws ProductException;
	
	public List<Product> findProductByCategory(String category);
	
	public Page<Product> getAllProduct(String category, List<String> colors, List<String> sizes, Integer minPrice, Integer maxPrice,
			Integer minDiscount, String sort, String stock,  Integer pageNumber, Integer pageSize);

	public List<Product> findAllProducts();

}
