package io.logizstikz.dronez.repository;

import io.logizstikz.dronez.model.Medication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicationRepository extends JpaRepository<Medication, Long> {

    @Query(value = "SELECT * FROM medication m WHERE m.drone_id = ?1", nativeQuery = true)
    Medication findByDroneId(long droneId);
}
