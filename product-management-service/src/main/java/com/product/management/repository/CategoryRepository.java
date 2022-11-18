package com.product.management.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.management.model.CategoryModel;

public interface CategoryRepository extends JpaRepository<CategoryModel, UUID> {

//	Optional<List<CategoryModel>> findAll(Pageable page);
}
