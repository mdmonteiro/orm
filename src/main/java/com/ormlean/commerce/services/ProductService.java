package com.ormlean.commerce.services;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ormlean.commerce.dto.ProductDTO;
import com.ormlean.commerce.entities.Product;
import com.ormlean.commerce.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private ModelMapper mapper;

	@Transactional(readOnly = true)
	public ProductDTO findById(Long id) {
		Optional<Product> product = productRepository.findById(id);

		return mapper.map(product.get(), ProductDTO.class);
	}

	@Transactional(readOnly = true)
	public Page<ProductDTO> findAll(Pageable pageable) {
		Page<Product> products = productRepository.findAll(pageable);

		return convertToDtoList(products);
	}

	@Transactional
	public ProductDTO insert(ProductDTO dto) {
		Product product = convertDtoToObject(dto);
		productRepository.save(product);

		return mapper.map(product, ProductDTO.class);
	}
	
	
	@Transactional
	public ProductDTO update(Long id, ProductDTO dto) {
		Product product = productRepository.getReferenceById(id);		
		convertDtoToEntity(dto, product);		
		productRepository.save(product);
		
		return mapper.map(product, ProductDTO.class);
	}
	
	@Transactional
	public void delete(Long id) {
		productRepository.deleteById(id);		
	}

	public Page<ProductDTO> convertToDtoList(Page<Product> products) {
		return products.map(p -> mapper.map(p, ProductDTO.class));
	}

	public Product convertDtoToObject(ProductDTO dto) {
		return mapper.map(dto, Product.class);
	}
	
	private void convertDtoToEntity(ProductDTO dto, Product product) {		
		product.setName(dto.getName());
		product.setDescription(dto.getDescription());
		product.setImgUrl(dto.getImgUrl());
		product.setPrice(dto.getPrice());		
	}

}
