package com.tummala.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.PagedResources;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.querydsl.core.BooleanBuilder;
import com.tummala.assembler.CountryModelAssembler;
import com.tummala.entity.Country;
import com.tummala.entity.QCountry;
import com.tummala.model.CountryModel;
import com.tummala.repository.CountryRepository;
import com.tummala.service.CountryService;
import com.tummala.util.APIErrorCodes;
import com.tummala.util.ApiStatusCode;
import com.tummala.util.MessageBean;
import com.tummala.util.ResponseDTO;

@Component
public class CountryServiceImpl implements CountryService {

	@Autowired
	CountryRepository countryRepository;

	private static final int DEFAULT_PAGE_SIZE = 2;
	

    @Autowired
    PagedResourcesAssembler<Country> pagedResourcesAssembler;
    
    @Autowired
    CountryModelAssembler countryModelAssembler;

	@Override
	public PagedResources<CountryModel> getAllCountries(CountryModel countryModel) {
		Pageable pageable = null;
		int pageNo = countryModel.getPage();
		int pageSize = countryModel.getSize();
		pageSize = (pageSize > 0) ? pageSize : DEFAULT_PAGE_SIZE;
		Page<Country> countries = null;
		Link selfLink = null;
		PagedResources<CountryModel> result = null;
		BooleanBuilder booleanBuilder = null;
		String code,name,population;
		try {
			pageable = PageRequest.of(pageNo, pageSize);
			//pageable = PageRequest.of(pageNo, pageSize,Sort.by("cid").descending());
			//countries = countryRepository.findAll(pageable);
			
			booleanBuilder = new BooleanBuilder();
			
			code=countryModel.getCode();
			code=(null!=code)?code.trim():"";
			
			name=countryModel.getName();
			name=(null!=name)?name.trim():"";
			
			population=countryModel.getPopulation();
			population=(null!=population?population.trim():"");

			if (!code.isEmpty()) {
				booleanBuilder.and(QCountry.country.code.eq(code));
			}

			if (!name.isEmpty()) {
				booleanBuilder.and(QCountry.country.name.eq(name));		
			}
			
			if (!population.isEmpty()) {
				booleanBuilder.and(QCountry.country.population.eq(population));	
			}
			
			countries = countryRepository.findAll(booleanBuilder.getValue(),pageable);
			
			//countries = countryRepository.findByPopulationNativeSQL(population, pageable);
			
			if (null != countries) {
				selfLink = new Link(ServletUriComponentsBuilder.fromCurrentRequest().build().toUriString());
				result = pagedResourcesAssembler.toResource(countries,countryModelAssembler,selfLink);
			} // countries
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public ResponseDTO<PagedResources<CountryModel>> getCountries(CountryModel countryModel) {
		Pageable pageable = null;
		int pageNo = countryModel.getPage();
		int pageSize = countryModel.getSize();
		pageSize = (pageSize > 0) ? pageSize : DEFAULT_PAGE_SIZE;
		Page<Country> countries = null;
		Link selfLink = null;
		ResponseDTO<PagedResources<CountryModel>> body = new ResponseDTO<>();
		BooleanBuilder booleanBuilder = null;
		String code,name,population;
		try {
			pageable = PageRequest.of(pageNo, pageSize);
			
			booleanBuilder = new BooleanBuilder();
			
			code=countryModel.getCode();
			code=(null!=code)?code.trim():"";
			
			name=countryModel.getName();
			name=(null!=name)?name.trim():"";
			
			population=countryModel.getPopulation();
			population=(null!=population?population.trim():"");

			if (!code.isEmpty()) {
				booleanBuilder.and(QCountry.country.code.eq(code));
			}

			if (!name.isEmpty()) {
				booleanBuilder.and(QCountry.country.name.eq(name));		
			}
			
			if (!population.isEmpty()) {
				booleanBuilder.and(QCountry.country.population.eq(population));	
			}
			
			countries = countryRepository.findAll(booleanBuilder.getValue(),pageable);
			
			if (null != countries) {
				selfLink = new Link(ServletUriComponentsBuilder.fromCurrentRequest().build().toUriString());
				
				body.setStatus(ApiStatusCode.SUCCESS);
				body.addMessage(new MessageBean(ApiStatusCode.SUCCESS.getCode(),"Country List Size"));
				body.setBody(pagedResourcesAssembler.toResource(countries,countryModelAssembler,selfLink));
			} // countries
		}catch(Exception e) {
			e.printStackTrace();
			body.setStatus(ApiStatusCode.FAILURE);
			body.addMessage(APIErrorCodes.INTERNAL_SERVER_ERROR);
		}
		return body;
	}

	@Override
	public ResponseDTO<PagedResources<CountryModel>> validateCountryModel(CountryModel countryModel) {
		// TODO Auto-generated method stub
		return null;
	}

}
