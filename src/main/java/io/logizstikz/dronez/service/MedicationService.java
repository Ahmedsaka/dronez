package io.logizstikz.dronez.service;

import io.logizstikz.dronez.model.Medication;
import io.logizstikz.dronez.repository.MedicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicationService {
    @Autowired
    private MedicationRepository medicationRepository;

    public Medication save(Medication medication){
        return medicationRepository.save(medication);
    }

    public Medication findByDroneId(Long droneId) {
        return medicationRepository.findByDroneId(droneId);
    }
}
