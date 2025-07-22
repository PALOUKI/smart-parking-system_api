package com.roothsa.smart_parking_system.entry;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ParkingEntryRepository extends JpaRepository<ParkingEntry, Long> {
    //List<ParkingEntry> vehiculeNumber(String vehiculeNumber);
    Optional<ParkingEntry> findByVehiculeNumberAndActiveTrue(String vehiculeNumber);
}
