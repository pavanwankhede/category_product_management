package com.product.management.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class ProductModel {

	@Id
	@Column(name = "prod_id")
	private int productId;

	@Column(name = "prod_name")
	private String productName;

//	@Column(nullable = false, name = "user_id")
//	private String userId;
	
	@ManyToOne
    @JoinColumn(name="cat_id")
    private CategoryModel category;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

//	public String getUserId() {
//		return userId;
//	}
//
//	public void setUserId(String userId) {
//		this.userId = userId;
//	}
}
