package io.logizstikz.dronez.model;

import io.logizstikz.dronez.Enum.Status;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "drone_status")
public class DroneStatus{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private Integer batteryCapacity;
    @Enumerated(EnumType.STRING)
    private Status status;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "drone_id")
    private Drone drone;
}
