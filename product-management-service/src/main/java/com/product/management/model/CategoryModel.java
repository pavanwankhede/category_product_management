package com.product.management.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class CategoryModel {

	@Id
	@Column(name = "cat_id")
	private int categoryId;
	@Column(name = "cat_name")
	private String categoryName;

//	@Column(nullable = false, name = "user_id")
//	private String userId;

	@OneToMany(mappedBy = "category")
	private List<ProductModel> productList;

	public void setProductList(List<ProductModel> productList) {
		this.productList = productList;
	}

	public List<ProductModel> getProductList() {
		return productList;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

//	public String getUserId() {
//		return userId;
//	}
//
//	public void setUserId(String userId) {
//		this.userId = userId;
//	}
}
