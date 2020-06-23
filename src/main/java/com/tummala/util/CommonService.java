package com.tummala.util;

import org.springframework.stereotype.Component;

@Component
public class CommonService {

	public ResponseDTO defaultInternalServerErrorResponseDto() {
		ResponseDTO response = new ResponseDTO();
		response.setStatus(ApiStatusCode.FAILURE);
		response.addMessage(APIErrorCodes.INTERNAL_SERVER_ERROR);
		return response;
	}

}
