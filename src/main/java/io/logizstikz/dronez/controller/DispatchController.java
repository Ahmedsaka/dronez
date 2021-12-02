package io.logizstikz.dronez.controller;

import io.logizstikz.dronez.model.request.DispatchRequest;
import io.logizstikz.dronez.model.request.DroneRequest;
import io.logizstikz.dronez.service.DispatchProcessingService;
import io.logizstikz.dronez.service.DroneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/drone")
public class DispatchController {
    @Autowired
    private DroneService droneService;
    @Autowired
    private DispatchProcessingService dispatchProcessingService;

    @PostMapping(value = "/register-drone", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> register(@RequestBody DroneRequest request){
        return new ResponseEntity<>(droneService.registerDrone(request), HttpStatus.CREATED);
    }

    @PostMapping(value = "/request-dispatch", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> register(@RequestBody DispatchRequest request){
        return new ResponseEntity<>(dispatchProcessingService.requestDrone(request), HttpStatus.GONE);
    }
}
