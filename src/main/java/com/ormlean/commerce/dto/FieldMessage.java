package com.ormlean.commerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FieldMessage {

	private String fieldName;
	private String message;

}
