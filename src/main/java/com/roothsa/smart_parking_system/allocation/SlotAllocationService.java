package com.roothsa.smart_parking_system.allocation;

import com.roothsa.smart_parking_system.event.VehiculeEnteredEvent;
import com.roothsa.smart_parking_system.event.VehiculeExitedEvent;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class SlotAllocationService {

    private final SlotRepository slotRepository;

    @Transactional
    @EventListener
    public void handleVehiculeEntry(VehiculeEnteredEvent event){
        Slot slot = slotRepository.findAndLockFirstAvailable()
                .orElseThrow(()-> new RuntimeException("No available slots!"));
            slot.setAvailable(false);
            slot.setVehiculeNumber(event.vehiculeNumber());
        slotRepository.save(slot);
        System.out.println("Allocated slot " + slot.getSlotCode() + "to vehicule " + event.vehiculeNumber());
    }

    @EventListener
    public void handleVehiculeExit(VehiculeExitedEvent event){
        Slot slot = slotRepository.findByVehiculeNumberAndAvailableFalse(event.vehiculeNumber())
                .orElseThrow(()-> new RuntimeException("No slot found for vehicule " + event.vehiculeNumber()));
        slot.setAvailable(true);
        slot.setVehiculeNumber(null);
        slotRepository.save(slot);
        System.out.println("Free slot " + slot.getSlotCode() + "from vehicule " + event.vehiculeNumber());
    }
}
