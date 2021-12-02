package io.logizstikz.dronez;

import io.logizstikz.dronez.Enum.Model;
import io.logizstikz.dronez.Enum.State;
import io.logizstikz.dronez.model.Drone;
import io.logizstikz.dronez.model.DroneState;
import io.logizstikz.dronez.repository.DroneRepository;
import io.logizstikz.dronez.repository.DroneStateRepository;
import io.logizstikz.dronez.util.ConstantUtil;
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
	private DroneStateRepository droneStateRepository;

	@Override
	public void run(String... args) throws Exception {

		List<Drone> drones = new ArrayList<>();
		List<DroneState> statuses = new ArrayList<>();

		for (int i = 0; i < 1000; i++) {
			Drone drone = new Drone();
			drone.setName(String.format("drone-%s", i));
			drone.setModel(Model.values()[new Random().nextInt(Model.values().length)]);
			drones.add(drone);

			DroneState droneState = new DroneState();
			droneState.setDrone(drone);
			droneState.setBatteryCapacity(new Random().nextInt(101));
			setDroneStatus(droneState);
			statuses.add(droneState);

		}
//		droneRepository.saveAll(drones);
		droneStateRepository.saveAll(statuses);
	}

	private void setDroneStatus(DroneState sts){
		State state = State.values()[new Random().nextInt(State.values().length)];
		if ((sts.getBatteryCapacity() < ConstantUtil.MIN_BATTERY_CAPACITY ) && state != State.LOADING) {
			sts.setState(state);
		} else sts.setState(State.IDLE);
	}
}
