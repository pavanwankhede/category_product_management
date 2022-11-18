package com.product.management.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.management.model.CategoryModel;
import com.product.management.model.ProductModel;

public interface ProductRepository extends JpaRepository<ProductModel, UUID> {

}
