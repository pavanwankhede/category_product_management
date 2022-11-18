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

import com.product.management.model.ProductModel;
import com.product.management.service.ProductService;

@RestController
public class ProductManagementController {

	@Autowired
	ProductService productService;

	@GetMapping("api/Products")
	public List<ProductModel> getProducts(@RequestParam(defaultValue = "0", required = false) Integer page,
			@RequestParam(defaultValue = "5", required = false) Integer pageSize) {
		Pageable paging = PageRequest.of(page, pageSize);
		return productService.getAllproducts(paging);
	}

	@PostMapping("api/Products")
	public ProductModel saveProducts(@RequestBody ProductModel ProductModel) {
		return productService.updateProduct(ProductModel);
	}

	@DeleteMapping("api/Products/{di}")
	public String deleteProducts(@PathParam("di") String id) {
		ProductModel ProductModel = new ProductModel();
		ProductModel.setProductId(Integer.parseInt(id));
		return productService.deletProduct(ProductModel);
	}

	@PutMapping("api/Products/{di}")
	public ProductModel updateProducts(@PathParam("di") String id, @RequestBody ProductModel ProductModel) {
		return productService.updateProduct(ProductModel);
	}

}
