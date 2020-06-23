package com.tummala.util;

import lombok.Getter;

@Getter
public enum APIErrorCodes {
	
	NO_CONTENT("ERROR0001","No Content"),
	COUNTRY_CODE("ERROR0002","Country Code Not Found"),
	INTERNAL_SERVER_ERROR("ERROR0003","Internal Server Error");
	
	private String errorCode;
	private String errorDesc;
	
	private APIErrorCodes(String errorCode, String errorDesc) {
		this.errorCode = errorCode;
		this.errorDesc = errorDesc;
	}
	
	
	

}
