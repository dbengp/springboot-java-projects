package com.system.takea_cab.config;

import com.system.takea_cab.domain.Cabby;
import com.system.takea_cab.domain.CabbyRepository;
import com.system.takea_cab.domain.Car;
import com.system.takea_cab.domain.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DBtoInitialConfigurations implements CommandLineRunner {
	
	@Autowired
	private CabbyRepository cabbyRepository;
	
	@Autowired
	private CarRepository carRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
	    Cabby sirBlackUk = new Cabby("Frank Martin", "He/Him", "+44 7993 434539");
		Cabby twoThreeSevenCP = new Cabby("Pak Hoi", "He/Him", "+852 9343 4539");
		Cabby broFromBronx = new Cabby("Cliff Booth", "He/Him", "+1 718 9343 4539");
		Cabby inaLA = new Cabby("Belle Williams", "She/Her", "+1 310 9343 4539");

        List<Cabby> cabbies = List.of(inaLA, twoThreeSevenCP, broFromBronx, sirBlackUk);

		cabbyRepository.saveAll(cabbies);
		
	    Car one = new Car("DV61ABC", "hatch");
        Car two = new Car("AA123", "SUV");
        Car three = new Car("NYB1234", "sedan");
		Car four = new Car("1ABC123", "hatch");
		Car five = new Car("NYC9876", "SUV");
		Car six = new Car("DV71BBC", "sedan");
		
		List<Car> fleetOf = List.of(one, two, three, four, five, six);
		
		carRepository.saveAll(fleetOf);

		one.setCabby(sirBlackUk);
		carRepository.save(one);

		two.setCabby(twoThreeSevenCP);
		carRepository.save(two);

		three.setCabby(broFromBronx);
		carRepository.save(three);

		four.setCabby(inaLA);
		carRepository.save(four);

		five.setCabby(broFromBronx);
		carRepository.save(five);

		six.setCabby(sirBlackUk);
		carRepository.save(six);
	}

}