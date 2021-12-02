package io.logizstikz.dronez.service;

import io.logizstikz.dronez.model.DroneStateAuditEvent;
import io.logizstikz.dronez.repository.DroneStateAuditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DroneAuditEventService {
    @Autowired
    private DroneStateAuditRepository droneStateAuditRepository;

    public List<DroneStateAuditEvent> saveAll(Iterable<DroneStateAuditEvent> droneStateAuditEvents) {
        return (List<DroneStateAuditEvent>) droneStateAuditRepository.saveAll(droneStateAuditEvents);
    }

    public Optional<DroneStateAuditEvent> findId(String id){
        return droneStateAuditRepository.findById(id);
    }

    public List<DroneStateAuditEvent> findDroneId(long id){
        return droneStateAuditRepository.findByDroneId(id);
    }

    public List<DroneStateAuditEvent> findBatteryLevel(int batteryLevel){
        return droneStateAuditRepository.findByBatteryLevel(batteryLevel);
    }

    public List<DroneStateAuditEvent> findDroneName(String droneName){
        return droneStateAuditRepository.findByDroneName(droneName);
    }
}
