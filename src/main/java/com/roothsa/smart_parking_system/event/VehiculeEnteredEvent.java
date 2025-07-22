package com.roothsa.smart_parking_system.event;

import java.time.LocalDateTime;

public record VehiculeEnteredEvent(
        String vehiculeNumber,
        LocalDateTime entryTime
) {
}
