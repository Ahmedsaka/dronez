package io.logizstikz.dronez.service;

import io.logizstikz.dronez.model.DroneState;
import io.logizstikz.dronez.repository.DroneStateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DroneStateService {
    @Autowired
    private DroneStateRepository droneStateRepository;

    public DroneState save(DroneState droneState) {
        return droneStateRepository.save(droneState);
    }

    public List<DroneState> getAvailableDroneForLoading() {
        return droneStateRepository.getAvailableDroneForLoading();
    }
}
