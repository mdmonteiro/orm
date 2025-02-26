package com.ormlean.commerce.dto;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomError {

	private Instant timestamp;
	private Integer status;
	private String error;
	private String path;

}
