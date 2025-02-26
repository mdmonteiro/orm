package com.ormlean.commerce.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
	
	
	private Long id;	

	@NotBlank(message = "Campo não pode ser vazio.")
	@Size(min = 3, max = 80, message = "Campo deve ter entre 3 e 80 caracteres.")
	private String name;
	
	@NotBlank(message = "Campo não pode ser vazio.")
	@Size(min = 10, message = "Precisa ter no mínimo 10 caracteres.")
	private String description;
	
	@Positive(message = "Preço deve ser positivo.")
	private BigDecimal price;
	
	private String imgUrl;

}
