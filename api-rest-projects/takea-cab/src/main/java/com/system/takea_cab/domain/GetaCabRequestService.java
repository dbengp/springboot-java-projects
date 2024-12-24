package com.system.takea_cab.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetaCabRequestService{

	@Autowired
	GetaCabRequestRepository getaCabRequestRepository;
	
	public GetaCabRequest saveGetaCabRequest(GetaCabRequest getaCabRequest) {
		
		return getaCabRequestRepository.save(getaCabRequest.nowAndCreated());
	}
	
}