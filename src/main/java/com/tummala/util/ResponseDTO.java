package com.tummala.util;

import java.util.HashSet;
import java.util.Set;

import org.springframework.hateoas.ResourceSupport;

import com.tummala.util.ApiStatusCode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ResponseDTO<T> extends ResourceSupport {

	private ApiStatusCode status;
	
	private Set<MessageBean> messages =new HashSet<>();
	
	private T body;
	
	public boolean addMessage(APIErrorCodes apiErrorCodes) {
		return messages.add(new MessageBean(apiErrorCodes.getErrorCode(),apiErrorCodes.getErrorDesc()));
	}
	
	public boolean addMessage(MessageBean apiMessage) {
		return messages.add(apiMessage);
	}

}
