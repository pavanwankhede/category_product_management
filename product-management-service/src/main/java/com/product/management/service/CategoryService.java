package com.product.management.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.product.management.model.CategoryModel;
import com.product.management.repository.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	CategoryRepository categoryRepository;

	public CategoryModel saveCategory(CategoryModel category) {

		return categoryRepository.save(category);
	}

	public List<CategoryModel> getAllCategories(Pageable paging) {
		Page<CategoryModel> categories = categoryRepository.findAll(paging);
		return categories.get().collect(Collectors.toList());
	}

	public CategoryModel updateCategory(CategoryModel category) {

		return categoryRepository.saveAndFlush(category);
	}

	public String deletCategory(CategoryModel category) {
		categoryRepository.delete(category);
		return "Data deleted successfully";
	}

}
