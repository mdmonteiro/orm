package com.ormlean.commerce.dto;

import java.math.BigDecimal;

import com.ormlean.commerce.entities.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

	private Long id;
	private String name;
	private String description;
	private BigDecimal price;
	private String imgUrl;

	public ProductDTO(Product product) {
		id = product.getId();
		name = product.getName();
		description = product.getDescription();
		price = product.getPrice();
		imgUrl = product.getImgUrl();
	}

}
