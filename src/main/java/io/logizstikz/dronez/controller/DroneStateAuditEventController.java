package io.logizstikz.dronez.controller;

import io.logizstikz.dronez.service.DroneAuditEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/drone-events")
public class DroneStateAuditEventController {
    @Autowired
    private DroneAuditEventService droneAuditEventService;

    @GetMapping("/by-droneId/{droneId}")
    public ResponseEntity<?> findByDroneId(@PathVariable long droneId){
        return new ResponseEntity<>(droneAuditEventService.findDroneId(droneId), HttpStatus.OK);
    }

    @GetMapping("/by-batteryLevel/{batteryLevel}")
    public ResponseEntity<?> findByBatteryLevel(@PathVariable int batteryLevel){
        return new ResponseEntity<>(droneAuditEventService.findBatteryLevel(batteryLevel), HttpStatus.OK);
    }

    @GetMapping("/by-droneName/{droneName}")
    public ResponseEntity<?> findByDroneName(@PathVariable String droneName){
        return new ResponseEntity<>(droneAuditEventService.findDroneName(droneName), HttpStatus.OK);
    }
}
