package io.logizstikz.dronez;

import io.logizstikz.dronez.Enum.Model;
import io.logizstikz.dronez.Enum.Status;
import io.logizstikz.dronez.model.Drone;
import io.logizstikz.dronez.model.DroneRequest;
import io.logizstikz.dronez.model.DroneStatus;
import io.logizstikz.dronez.repository.DroneRepository;
import io.logizstikz.dronez.repository.DroneStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@EnableJpaRepositories
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}

@Component
class Initializer implements CommandLineRunner {
	@Autowired
	private DroneRepository droneRepository;
	@Autowired
	private DroneStatusRepository droneStatusRepository;

	@Override
	public void run(String... args) throws Exception {

		List<Drone> drones = new ArrayList<>();
		List<DroneStatus> statuses = new ArrayList<>();

		for (int i = 0; i < 1000; i++) {
			Drone drone = new Drone();
			drone.setName(String.format("drone-%s", i));
			drone.setModel(Model.values()[new Random().nextInt(Model.values().length)]);
			drones.add(drone);

			DroneStatus droneStatus = new DroneStatus();
			droneStatus.setDrone(drone);
			droneStatus.setBatteryCapacity(new Random().nextInt(101));
			setDroneStatus(droneStatus);
			statuses.add(droneStatus);
		}
		droneRepository.saveAll(drones);
		droneStatusRepository.saveAll(statuses);
	}

	private void setDroneStatus(DroneStatus sts){
		Status status = Status.values()[new Random().nextInt(Status.values().length)];
		if ((sts.getBatteryCapacity() < ConstantUtil.MIN_BATTERY_CAPACITY ) && status != Status.LOADING) {
			sts.setStatus(status);
		} else sts.setStatus(Status.IDLE);
	}
}
