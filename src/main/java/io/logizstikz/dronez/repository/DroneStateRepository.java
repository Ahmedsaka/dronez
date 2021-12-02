package io.logizstikz.dronez.repository;

import io.logizstikz.dronez.model.DroneState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DroneStateRepository extends JpaRepository<DroneState, Long> {

    @Query(value = "SELECT * FROM DRONE_STATE  WHERE state = 'IDLE' AND battery_capacity >= 25", nativeQuery = true)
    List<DroneState> getAvailableDroneForLoading();

    @Query(value = "SELECT battery_capacity FROM DRONE_STATE  WHERE drone_id = ?1", nativeQuery = true)
    Integer findBatteryLevelDroneId(Long id);
}
