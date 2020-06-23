package com.tummala.web;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tummala.model.CountryModel;
import com.tummala.service.CountryService;
import com.tummala.util.CommonService;
import com.tummala.util.ResponseDTO;

@RestController
public class CountryRestController {

	@Autowired
	CountryService countryService;
	
	@Autowired
	CommonService commonService;

	@GetMapping(value="/api/country-list", produces = { MediaType.APPLICATION_JSON_VALUE, MediaTypes.HAL_JSON_VALUE })
	public ResponseEntity<PagedResources<CountryModel>> getAllCountries(CountryModel countryModel) {
		PagedResources<CountryModel> result = null;
		try {
			result = countryService.getAllCountries(countryModel);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@GetMapping(value="/api/countryList", produces = { MediaType.APPLICATION_JSON_VALUE, MediaTypes.HAL_JSON_VALUE })
	public ResponseEntity<ResponseDTO<PagedResources<CountryModel>>> getCountries(CountryModel countryModel) {
		ResponseDTO<PagedResources<CountryModel>> response = null;
		try {
			response = countryService.validateCountryModel(countryModel);
			if(Objects.nonNull(response)) {
				response.add(linkTo(methodOn(CountryRestController.class).getCountries(countryModel)).withSelfRel().expand());
				return ResponseEntity.badRequest().body(response);
			}else {
				response = countryService.getCountries(countryModel);
				response.add(linkTo(methodOn(CountryRestController.class).getCountries(countryModel)).withSelfRel().expand());
				return ResponseEntity.ok(response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			response=commonService.defaultInternalServerErrorResponseDto();
			response.add(linkTo(methodOn(CountryRestController.class).getCountries(countryModel)).withSelfRel().expand());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}

		
	}
	
	

}
