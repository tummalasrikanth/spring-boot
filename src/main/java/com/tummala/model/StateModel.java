package com.tummala.model;

import org.springframework.hateoas.ResourceSupport;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class StateModel extends ResourceSupport{
	
	private Integer sid;
	private CountryModel country;
	private String code;
	private String name;

}
