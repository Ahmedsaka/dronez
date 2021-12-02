package io.logizstikz.dronez.controller;

import io.logizstikz.dronez.service.MedicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/medication")
public class MedicationController {
    @Autowired
    private MedicationService medicationService;

    @GetMapping("/{droneId}")
    public ResponseEntity<?> getMedicationByDroneId(@PathVariable long droneId) {
        return new ResponseEntity<>(medicationService.findByDroneId(droneId), HttpStatus.OK);
    }
}
