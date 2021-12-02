package io.logizstikz.dronez.repository;

import io.logizstikz.dronez.model.DroneState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DroneStateRepository extends JpaRepository<DroneState, Long> {
    @Query(value = "SELECT TOP 1 s FROM DRONE_STATE s WHERE s.drone_id = ?1 ORDER BY s.id DESC", nativeQuery = true)
    DroneState getLastDroneStatusByDroneId(long droneId);

    @Query(value = "SELECT * FROM DRONE_STATE  WHERE state = 'IDLE' AND battery_capacity >= 25", nativeQuery = true)
    List<DroneState> getAvailableDroneForLoading();
}
