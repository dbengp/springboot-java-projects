package com.system.takea_cab.api;

import com.system.takea_cab.domain.CabbyRepository;
import com.system.takea_cab.domain.Cabby;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Service
@RestController
@RequestMapping(value = "/cabbies", produces = MediaType.APPLICATION_JSON_VALUE)
public class CabbyAPI{

	@Autowired
	CabbyRepository cabbyRepository;

	@GetMapping("/whoare")
	public List<Cabby> cabbies() {
		return cabbyRepository.findAll();
	}
	
}