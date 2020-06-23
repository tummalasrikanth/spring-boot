package com.tummala.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "country")
public class Country implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer cid;
	private String code;
	private String name;
	private String population;
	private Set<State> states = new LinkedHashSet<>(0);

	public Country() {
	}

	public Country(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public Country(String code, String name, Set<State> states) {
		this.code = code;
		this.name = name;
		this.states = states;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "cid", unique = true, nullable = false)
	public Integer getCid() {
		return this.cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	@Column(name = "code", nullable = false, length = 10)
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "name", nullable = false, length = 25)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "population", length = 25)
	public String getPopulation() {
		return population;
	}

	public void setPopulation(String population) {
		this.population = population;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "country")
	public Set<State> getStates() {
		return this.states;
	}

	public void setStates(Set<State> states) {
		this.states = states;
	}

}
