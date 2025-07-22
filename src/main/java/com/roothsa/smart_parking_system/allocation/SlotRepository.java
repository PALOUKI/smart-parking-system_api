package com.roothsa.smart_parking_system.allocation;

import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface SlotRepository extends JpaRepository<Slot, Long> {
    Optional<Slot> findFirstAndLockByAvailableTrue(); // ceci marche parfaitement avec le find first and lock available pour éviter les problème de concurrence, ça peut également réduire les problèmes de performence si on a beacuoup de requettes simultané. ça remplace donc la methode findAndLockFirstAvailable en bas

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT s FROM Slot s WHERE s.available = true ORDER BY s.id LIMIT 1")
    Optional<Slot> findAndLockFirstAvailable();

    Optional<Slot> findByVehiculeNumberAndAvailableFalse(String vehiculeNumber);
}
