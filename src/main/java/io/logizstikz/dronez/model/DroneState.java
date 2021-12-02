package io.logizstikz.dronez.model;

import io.logizstikz.dronez.Enum.State;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "drone_state")
public class DroneState extends BaseModel{
    private Integer batteryLevel;
    @Enumerated(EnumType.STRING)
    private State state;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "drone_id", referencedColumnName = "id")
    private Drone drone;
}
