package com.ormlean.commerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ormlean.commerce.dto.ProductDTO;
import com.ormlean.commerce.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping(value = "/{id}")	
	public ProductDTO findById(@PathVariable Long id) {
		ProductDTO dto = productService.findById(id);
		return dto;
	}

}
