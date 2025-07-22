package com.roothsa.smart_parking_system;

import com.roothsa.smart_parking_system.allocation.Slot;
import com.roothsa.smart_parking_system.allocation.SlotRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SmartParkingSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartParkingSystemApplication.class, args);
	}

	@Bean
	CommandLineRunner initSlots(SlotRepository slotRepository) {
		return args ->{
			if (slotRepository.count() == 0) {
				slotRepository.save(new Slot(null, "A1", true, null));
				slotRepository.save(new Slot(null, "A2", true, null));
				slotRepository.save(new Slot(null, "A3", true, null));
			}
		};
	}

}
