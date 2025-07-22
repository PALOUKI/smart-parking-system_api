package com.roothsa.smart_parking_system.entry;

import com.roothsa.smart_parking_system.event.VehiculeEnteredEvent;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class EntryService {

    private final ParkingEntryRepository parkingEntryRepository;
    private final ApplicationEventPublisher publisher;
    public void vehiculeEntry(String vehiculeNumber){
        ParkingEntry parkingEntry = new ParkingEntry(null, vehiculeNumber, LocalDateTime.now(), null, true);
        parkingEntryRepository.save(parkingEntry);
        //publish an event
        publisher.publishEvent(new VehiculeEnteredEvent(vehiculeNumber, parkingEntry.getEntryTime()));
    }
}
