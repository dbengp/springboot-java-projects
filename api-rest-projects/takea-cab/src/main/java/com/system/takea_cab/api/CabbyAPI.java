package com.system.takea_cab.api;

import com.system.takea_cab.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RestController
@RequestMapping(value = "/cabbies", produces = MediaType.APPLICATION_JSON_VALUE)
public class CabbyAPI{

	@Autowired
	CabbyRepository cabbyRepository;
	
	@Autowired
    CarRepository carRepository;

	@PostMapping("/addone")
	public Cabby createCabby(@RequestBody Recruited recruited) {
		return cabbyRepository.save(fromRecruitedToCabby(recruited));
	}

	@GetMapping("/justone/{id}")
	public Cabby findCabby(@PathVariable("id") Long id) {
		return cabbyRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

	@GetMapping("/whoare")
	public List<Cabby> findCabbies() {
		return cabbyRepository.findAll();
	}
	
	@GetMapping("/by/{licenseplate}")
    public Cabby getCabbyByLicensePlate(@PathVariable("licenseplate") String licenseplate) {
		Optional<Car> optionalCar = carRepository.findByLicensePlate(licenseplate);
		if (optionalCar.isPresent()) {
			Car car = optionalCar.get();
			return car.getCabby();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
			//EntityNotFoundException("There is no cabby with this license plate: " + licenseplate);
		}
	}
	
	@PutMapping("/update/{id}")
    public Cabby update(@PathVariable("id") Long id, @RequestBody Updater updater) {
        Cabby cabby = findCabby(id);
		toUpdate(cabby, updater);
        return cabbyRepository.save(cabby);
    }

	@DeleteMapping("/fired/{id}")
	public void delete(@PathVariable("id") Long id) {
		Cabby cabby = findCabby(id);
		cabbyRepository.delete(cabby);
	}
	
	private void toUpdate(Cabby cabby, Updater updater) {

		if(!isNullOrEmpty(updater.name()))
			cabby.setName(updater.name());
		if(!isNullOrEmpty(updater.pronouns()))
			cabby.setPronouns(updater.pronouns());
		if(!isNullOrEmpty(updater.contact()))
			cabby.setContact(updater.contact());
	}

	private boolean isNullOrEmpty(String data){
		return (data == null || data.isEmpty());
	}
	
	private Cabby fromRecruitedToCabby(Recruited recruited){
		return new Cabby(recruited.name(), recruited.pronouns(), recruited.contact());
	}
}