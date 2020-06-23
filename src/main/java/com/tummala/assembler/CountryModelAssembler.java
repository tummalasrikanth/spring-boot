package com.tummala.assembler;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import com.tummala.entity.Country;
import com.tummala.entity.State;
import com.tummala.model.CountryModel;
import com.tummala.model.StateModel;
import com.tummala.web.CountryRestController;

@Component
public class CountryModelAssembler extends ResourceAssemblerSupport<Country, CountryModel> {

	public CountryModelAssembler() {
		super(CountryRestController.class, CountryModel.class);
	}

	@Override
	public CountryModel toResource(Country country) {
		CountryModel countryModel =new CountryModel();
		countryModel.setCid(country.getCid());
		countryModel.setCode(country.getCode());
		countryModel.setName(country.getName());
		countryModel.setPopulation(country.getPopulation());
		if(null!=country.getStates()) {
			Set<StateModel> states = new LinkedHashSet<>();
			for(State state:country.getStates()) {
				StateModel stateModel =new StateModel();
				stateModel.setSid(state.getSid());
				stateModel.setCode(state.getCode());
				stateModel.setName(state.getName());
				states.add(stateModel);
			}
		 countryModel.setStates(states);
		}//if states
		return  countryModel;
	}
	
	

}
