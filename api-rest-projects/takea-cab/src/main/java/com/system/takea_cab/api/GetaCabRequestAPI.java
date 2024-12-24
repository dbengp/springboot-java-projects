package com.system.takea_cab.api;

import com.system.takea_cab.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Service
@RestController
@RequestMapping(path = "/cabrequests", produces = MediaType.APPLICATION_JSON_VALUE)
public class GetaCabRequestAPI{
	
	@Autowired
	GetaCabRequestService getaCabRequestService;
	
	@Autowired
	GetaCabRequestMapper getaCabRequestMapper;
	
	@PostMapping("/add")
	public EntityModel<GetaCabRequestOut> createCabRequest(@RequestBody GetaCabRequestIn cabrequestIn) {
		GetaCabRequest getaCabRequest = getaCabRequestService.saveGetaCabRequest(getaCabRequestMapper.map(cabrequestIn));
		GetaCabRequestOut getaCabRequestOut = getaCabRequestMapper.map(getaCabRequest);
		return getaCabRequestMapper.buildOutModel(getaCabRequest, getaCabRequestOut);
	}
}