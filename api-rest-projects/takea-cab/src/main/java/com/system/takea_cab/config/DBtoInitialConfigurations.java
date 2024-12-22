package com.system.takea_cab.config;

import com.system.takea_cab.domain.Cabby;
import com.system.takea_cab.domain.CabbyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DBtoInitialConfigurations implements CommandLineRunner {
	
	@Autowired
	private CabbyRepository cabbyRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
	    Cabby sirYellowGb = new Cabby("Frank Martin", "He/Him", "+44 7993 434539");
		Cabby twoThreeSevenCP = new Cabby("Pak Hoi", "He/Him", "+852 9343 4539");
		Cabby broFromBronx = new Cabby("Cliff Booth", "He/Him", "+1 718 9343 4539");
		Cabby inaLA = new Cabby("Belle Williams", "She/Her", "+1 310 9343 4539");

        List<Cabby> frota = List.of(inaLA, twoThreeSevenCP, broFromBronx, sirYellowGb);

		cabbyRepository.saveAll(frota);
	}

}