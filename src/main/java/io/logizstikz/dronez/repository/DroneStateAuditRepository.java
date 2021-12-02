package io.logizstikz.dronez.repository;

import io.logizstikz.dronez.model.DroneStateAuditEvent;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DroneStateAuditRepository extends ElasticsearchRepository<DroneStateAuditEvent, String> {
    List<DroneStateAuditEvent> findByDroneId(long droneId);
    List<DroneStateAuditEvent> findByDroneName(String droneName);
    List<DroneStateAuditEvent> findByBatteryLevel(int batteryLevel);
}
