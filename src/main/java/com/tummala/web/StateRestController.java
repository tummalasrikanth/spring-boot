package com.tummala.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.tummala.service.StateService;

@RestController
public class StateRestController {
	
	@Autowired
	StateService stateService;

}
