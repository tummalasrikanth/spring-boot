package com.tummala.util;

import lombok.Getter;

@Getter
public enum ApiStatusCode {
	SUCCESS("SUCCESS"),
	FAILURE("FAILURE"),
	BAD_REQUEST("BAD_REQUEST"),
	UNAUTHORIZED("UNAUTHORIZED");
	
	private String code;

	private ApiStatusCode(String code) {
		this.code = code;
	}
	
	
	

}
