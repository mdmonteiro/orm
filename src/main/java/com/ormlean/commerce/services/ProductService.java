package com.ormlean.commerce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ormlean.commerce.dto.ProductDTO;
import com.ormlean.commerce.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Transactional(readOnly = true)
	public ProductDTO findById(Long id) {
		return new ProductDTO(productRepository.findById(id).get());
	}

}
