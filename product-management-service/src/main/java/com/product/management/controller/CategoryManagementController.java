package com.product.management.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.product.management.model.CategoryModel;
import com.product.management.service.CategoryService;

@RestController
public class CategoryManagementController {

	@Autowired
	CategoryService categoryService;

	@GetMapping("api/categories")
	public List<CategoryModel> getCategories(@RequestParam(defaultValue = "0", required = false) Integer page,
			@RequestParam(defaultValue = "5", required = false) Integer pageSize) {
		Pageable paging = PageRequest.of(page, pageSize);
		return categoryService.getAllCategories(paging);
	}

	@PostMapping("api/categories")
	public CategoryModel saveCategories(@RequestBody CategoryModel categoryModel) {
		return categoryService.updateCategory(categoryModel);
	}

	@DeleteMapping("api/categories/{di}")
	public String deleteCategories(@PathParam("di") String id) {
		CategoryModel categoryModel = new CategoryModel();
		categoryModel.setCategoryId(Integer.parseInt(id));
		return categoryService.deletCategory(categoryModel);
	}

	@PutMapping("api/categories/{di}")
	public CategoryModel updateCategories(@PathParam("di") String id,@RequestBody CategoryModel categoryModel) {
		return categoryService.updateCategory(categoryModel);
	}

}
