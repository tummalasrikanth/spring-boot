package com.tummala.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tummala.repository.StateRepository;
import com.tummala.service.StateService;

@Component
public class StateServiceImpl implements StateService {
	
	@Autowired
	StateRepository stateRepository;

}
