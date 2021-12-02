package io.logizstikz.dronez.controller;

import io.logizstikz.dronez.service.DroneStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/drone-state")
public class DroneStateController {
    @Autowired
    private DroneStateService droneStateService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getDroneBatteryLevel(@PathVariable long id){
        return new ResponseEntity<>(droneStateService.getDroneBatteryLevel(id), HttpStatus.OK);
    }
}
