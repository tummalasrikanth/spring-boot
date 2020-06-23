package com.tummala.service;

import org.springframework.hateoas.PagedResources;

import com.tummala.model.CountryModel;
import com.tummala.util.ResponseDTO;

public interface CountryService {
	
	public PagedResources<CountryModel> getAllCountries(CountryModel countryModel);
	
	public ResponseDTO<PagedResources<CountryModel>> getCountries(CountryModel countryModel);

	public ResponseDTO<PagedResources<CountryModel>> validateCountryModel(CountryModel countryModel);

}
