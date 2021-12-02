package io.logizstikz.dronez.service;

import io.logizstikz.dronez.Enum.State;
import io.logizstikz.dronez.exception.CarriageCapacityExceededException;
import io.logizstikz.dronez.exception.UnavailableDroneException;
import io.logizstikz.dronez.model.*;
import io.logizstikz.dronez.model.request.DispatchRequest;
import io.logizstikz.dronez.model.response.DispatchResponse;
import io.logizstikz.dronez.util.ConstantUtil;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class DispatchProcessingService {
    @Autowired
    private DroneStateService droneStateService;
    @Autowired
    private DroneService droneService;
    @Autowired
    private MedicationService medicationService;
    @Autowired
    private ModelMapper mapper;

    @Transactional
    public DispatchResponse requestDrone(DispatchRequest request) {
        Medication medication = mapper.map(request, Medication.class);

        List<DroneState> states = droneStateService.getAvailableDroneForLoading();
        DroneState droneState;
        Drone drone;
        if (states != null) {
            droneState = states.get(0);
            drone = droneService.findById(droneState.getDrone().getId());
        } else throw new UnavailableDroneException("No drone available at the moment");

            if (medication.getWeight() <= ConstantUtil.MAX_CARRIAGE_CAPACITY) {
                droneState.setState(State.LOADING);
                droneState.setDrone(drone);
                droneStateService.save(droneState);
            } else {
                throw new CarriageCapacityExceededException(String.format("Drone maximum carrying capacity exceeded by %s",
                        medication.getWeight() - ConstantUtil.MAX_CARRIAGE_CAPACITY));
            }

            medication.setDroneId(drone.getId());
        medicationService.save(medication);
        droneState.setState(State.LOADED);
        droneStateService.save(droneState);
        return new DispatchResponse(droneState, medication);
    }
}

