package io.logizstikz.dronez;

import io.logizstikz.dronez.model.DroneRequest;
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
public class DroneController {
    @Autowired
    private DroneService droneService;

    @PostMapping(value = "/register-drone", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> register(@RequestBody DroneRequest request){
        return new ResponseEntity<>(droneService.registerDrone(request), HttpStatus.CREATED);
    }
}
