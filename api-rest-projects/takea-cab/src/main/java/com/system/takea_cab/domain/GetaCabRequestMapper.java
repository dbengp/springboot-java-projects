package com.system.takea_cab.domain;

import com.system.takea_cab.api.PassengerAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class GetaCabRequestMapper {

	@Autowired
	PassengerRepository	passengerRepository;
	
	public GetaCabRequest map(GetaCabRequestIn getaCabRequestIn){
		Passenger passenger = passengerRepository.findById(getaCabRequestIn.passengerId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		return new GetaCabRequest(passenger, getaCabRequestIn.wearehere(), getaCabRequestIn.wegoto());
	}
	
	public GetaCabRequestOut map(GetaCabRequest getaCabRequest){
		return new GetaCabRequestOut( 
				getaCabRequest.getId(),
				getaCabRequest.getWearehere(),
				getaCabRequest.getWegoto(),
			    getaCabRequest.getStatus(), 
				getaCabRequest.getCreationDate()
			);
	}
	
	public EntityModel<GetaCabRequestOut> buildOutModel(GetaCabRequest getaCabRequest, GetaCabRequestOut getaCabRequestOut){
		EntityModel<GetaCabRequestOut> outModel = EntityModel.of(getaCabRequestOut); 
		Link passengerLink = WebMvcLinkBuilder
				.linkTo(PassengerAPI.class)
				.slash("/pickone/".concat(String.valueOf(getaCabRequest.getPassenger().getId())))
				.withRel("passenger")
				.withTitle(getaCabRequest.getPassenger().getName());
		outModel.add(passengerLink);
		return outModel;
	}

}