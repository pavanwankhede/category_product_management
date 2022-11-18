package com.product.management.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.product.management.model.ProductModel;
import com.product.management.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	ProductRepository productRepository;

	public ProductModel saveProduct(ProductModel Product) {

		return productRepository.save(Product);
	}

	public List<ProductModel> getAllproducts(Pageable paging) {
		Page<ProductModel> products = productRepository.findAll(paging);
		return products.get().collect(Collectors.toList());
	}

	public ProductModel updateProduct(ProductModel Product) {

		return productRepository.saveAndFlush(Product);
	}

	public String deletProduct(ProductModel Product) {
		productRepository.delete(Product);
		return "Data deleted successfully";
	}

}
