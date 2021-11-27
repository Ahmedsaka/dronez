package io.logizstikz.dronez;

import io.logizstikz.dronez.Enum.Model;
import io.logizstikz.dronez.exception.NotFoundException;
import io.logizstikz.dronez.model.Drone;
import io.logizstikz.dronez.model.DroneRequest;
import io.logizstikz.dronez.repository.DroneRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.EnumSet;

@Slf4j
@Service
public class DroneService {

    @Autowired
    private DroneRepository droneRepository;

    public Drone registerDrone(DroneRequest request) {

        Drone drone = new Drone();
        drone.setName(request.getName());
//        if (request.getWeightLimit() <= ConstantUtil.MAX_CARRIAGE_CAPACITY) {
//            drone.setWeightLimit(request.getWeightLimit());
//        } else throw new CarriageCapacityExceededException(String.format("Drone maximum carrying capacity exceeded by {}",
//                request.getWeightLimit()-ConstantUtil.MAX_CARRIAGE_CAPACITY));
//
       if (request.getModel() != null){
           for (Model m : EnumSet.allOf(Model.class)){
               if (Model.valueOf(request.getModel()).equals(m)) drone.setModel(Model.valueOf(request.getModel()));
           }
       } else throw new NotFoundException("Drone model does not exists");

       log.info("Drone {} created", drone.getName());
       return droneRepository.save(drone);
    }
}
