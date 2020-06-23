package com.tummala.model;

import java.util.Set;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class CountryModel extends ResourceSupport{
	
	private Integer cid;
	private String code;
	private String name;
	private String population;
	
	@JsonIgnore
	private int page;
	@JsonIgnore
	private int size;
	private Set<StateModel> states;

}
