package com.ormlean.commerce.dto;

import java.math.BigDecimal;

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

}
