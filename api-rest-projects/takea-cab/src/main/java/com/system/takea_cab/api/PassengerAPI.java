package com.system.takea_cab.api;

import com.system.takea_cab.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RestController
@RequestMapping(path = "/passengers", produces = MediaType.APPLICATION_JSON_VALUE)
public class PassengerAPI{
	
	@Autowired
	PassengerRepository passengerRepository;
	
	@PostMapping("/add")
	public Passenger createPassenger(@RequestBody AboutPassenger aboutPassenger) {
		return passengerRepository.save(fromAboutPassengerToPassenger(aboutPassenger));
	}
	
	@GetMapping("/pickone/{id}")
	public Passenger findPassenger(@PathVariable("id") Long id) {
		return passengerRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

	@GetMapping("/pickall")
	public List<Passenger> findPassengers() {
		return passengerRepository.findAll();
	}
	
	@PutMapping("/update/{id}")
    public Passenger update(@PathVariable("id") Long id, @RequestBody Updater updater) {
        Passenger passenger = findPassenger(id);
		toUpdate(passenger, updater);
        return passengerRepository.save(passenger);
    }

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") Long id) {
		Passenger passenger = findPassenger(id);
		passengerRepository.delete(passenger);
	}
	
	private Passenger fromAboutPassengerToPassenger(AboutPassenger aboutPassenger){
		return new Passenger(aboutPassenger.name(), aboutPassenger.pronouns());
	}
	
	private void toUpdate(Passenger passenger, Updater updater) {
		if(!isNullOrEmpty(updater.name()))
			passenger.setName(updater.name());
		if(!isNullOrEmpty(updater.pronouns()))
			passenger.setPronouns(updater.pronouns());
	}

	private boolean isNullOrEmpty(String data){
		return (data == null || data.isEmpty());
	}

}