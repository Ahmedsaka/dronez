package io.logizstikz.dronez.repository;

import io.logizstikz.dronez.model.DroneStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DroneStatusRepository extends JpaRepository<DroneStatus, Long> {
    @Query(value = "SELECT TOP 1 s FROM DRONE_STATUS s WHERE s.drone_id = ?1 ORDER BY s.id DESC", nativeQuery = true)
    DroneStatus getLastDroneStatusByDroneId(long droneId);
}
