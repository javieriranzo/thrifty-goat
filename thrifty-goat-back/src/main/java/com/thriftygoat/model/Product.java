package com.thriftygoat.model;

import java.math.BigDecimal;

public class Product {

	private Long id;
	private String name; 
	private String description; 
	private BigDecimal price;
	private ProductCategory productCategory;
	
	public Product() {}
	
	public Product(Long id, String name, String description, BigDecimal price, ProductCategory productCategory) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.productCategory = productCategory;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public ProductCategory getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
	} 
	
}
