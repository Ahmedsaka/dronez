package io.logizstikz.dronez;

import io.logizstikz.dronez.Enum.Model;
import io.logizstikz.dronez.Enum.State;
import io.logizstikz.dronez.model.Drone;
import io.logizstikz.dronez.model.DroneState;
import io.logizstikz.dronez.model.DroneStateAuditEvent;
import io.logizstikz.dronez.repository.DroneRepository;
import io.logizstikz.dronez.repository.DroneStateAuditRepository;
import io.logizstikz.dronez.repository.DroneStateRepository;
import io.logizstikz.dronez.util.ConstantUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

import java.util.*;

@EnableJpaRepositories
@EnableElasticsearchRepositories(basePackages = "io.logizstikz.dronez.repository")
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
	@Autowired
	private DroneStateAuditRepository droneStateAuditRepository;

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
			droneState.setBatteryLevel(new Random().nextInt(101));
			setDroneStatus(droneState);
			statuses.add(droneState);

		}
		droneStateRepository.saveAll(statuses);

		List<DroneStateAuditEvent> droneStateAuditEvents = new LinkedList<>();
		for (DroneState droneState : droneStateRepository.findAll()) {
			DroneStateAuditEvent droneStateAuditEvent = new DroneStateAuditEvent();
			droneStateAuditEvent.setDroneId(droneState.getDrone().getId());
			droneStateAuditEvent.setDroneName(droneState.getDrone().getName());
			droneStateAuditEvent.setBatteryLevel(droneState.getBatteryLevel());
			droneStateAuditEvent.setDate(new Date());
			droneStateAuditEvents.add(droneStateAuditEvent);
		}
		droneStateAuditRepository.saveAll(droneStateAuditEvents);
	}

	private void setDroneStatus(DroneState sts){
		State state = State.values()[new Random().nextInt(State.values().length)];
		if ((sts.getBatteryLevel() < ConstantUtil.MIN_BATTERY_CAPACITY ) && state != State.LOADING) {
			sts.setState(state);
		} else sts.setState(State.IDLE);
	}
}
