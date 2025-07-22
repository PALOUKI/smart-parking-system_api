package com.roothsa.smart_parking_system.notification;

import com.roothsa.smart_parking_system.event.VehiculeEnteredEvent;
import com.roothsa.smart_parking_system.event.VehiculeExitedEvent;
import lombok.AllArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class NotificationService {

    @EventListener
    public void notifyOnVehiculeEntered(VehiculeEnteredEvent event){
        System.out.println("Notification : Vehicule " + event.vehiculeNumber() + " has been entered at " + event.entryTime());
    }

    @EventListener
    public void notifyOnVehiculeExited(VehiculeExitedEvent event){
        System.out.println("Notification: Vehicule " + event.vehiculeNumber() + "has exited" + event.exitTime());
    }
}
