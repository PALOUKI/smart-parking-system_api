package com.roothsa.smart_parking_system.billing;

import com.roothsa.smart_parking_system.event.VehiculeExitedEvent;
import lombok.AllArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.time.Duration;

@AllArgsConstructor
@Service
public class BillingService {

    private BillingRecordRepository billingRecordRepository;

    @EventListener
    public void handlevehiculeExit(VehiculeExitedEvent event){
        Duration duration = Duration.between(event.entryTime(), event.exitTime());
        double amount = Math.max(20, (duration.toMinutes()/60.0)*50); // 50 Francs/heure
        BillingRecord billingRecord = new BillingRecord(null, event.vehiculeNumber(), amount, event.exitTime());
        billingRecordRepository.save(billingRecord);
        System.out.println("Billed " + amount + " for vehicule " + event.vehiculeNumber() +
                " from " + event.entryTime() + " to " + event.exitTime());
    }
}
