package com.roothsa.smart_parking_system.event;

import java.time.LocalDateTime;

public record VehiculeExitedEvent(
        String vehiculeNumber,
        LocalDateTime entryTime,
        LocalDateTime exitTime
) {
}
