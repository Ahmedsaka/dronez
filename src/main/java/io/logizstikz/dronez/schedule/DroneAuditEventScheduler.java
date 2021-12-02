package io.logizstikz.dronez.schedule;

import io.logizstikz.dronez.model.DroneState;
import io.logizstikz.dronez.model.DroneStateAuditEvent;
import io.logizstikz.dronez.repository.DroneStateAuditRepository;
import io.logizstikz.dronez.service.DroneStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Component
public class DroneAuditEventScheduler {

    @Autowired
    DroneStateAuditRepository droneStateAuditRepository;
    @Autowired
    DroneStateService droneStateService;

    @Scheduled(fixedDelay = 100000L)
    public void runAudit(){
        List<DroneState> droneStates = droneStateService.findAll();
        List<DroneStateAuditEvent> droneStateAuditEvents = new LinkedList<>();
        for (DroneState droneState : droneStates) {
            DroneStateAuditEvent droneStateAuditEvent = new DroneStateAuditEvent();
            droneStateAuditEvent.setDroneId(droneState.getDrone().getId());
            droneStateAuditEvent.setDroneName(droneState.getDrone().getName());
            droneStateAuditEvent.setDate(new Date());
            droneStateAuditEvents.add(droneStateAuditEvent);
        }
        droneStateAuditRepository.saveAll(droneStateAuditEvents);
    }
}
