package com.roothsa.smart_parking_system.entry;

import com.roothsa.smart_parking_system.event.VehiculeExitedEvent;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class ExitService {

    private final ParkingEntryRepository parkingEntryRepository;
    private final ApplicationEventPublisher publisher;

    @EventListener
    public void vehiculeExit(String vehiculeNumber){
        ParkingEntry entry = parkingEntryRepository.findByVehiculeNumberAndActiveTrue(vehiculeNumber)
                .orElseThrow(()-> new RuntimeException("No active entry found for vehicule"));
        entry.setExitTime(LocalDateTime.now());
        entry.setActive(false);
        parkingEntryRepository.save(entry);
        publisher.publishEvent(new VehiculeExitedEvent(vehiculeNumber, entry.getEntryTime(), entry.getExitTime()));
    }
}
