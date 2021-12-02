package io.logizstikz.dronez.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "medication")
public class Medication extends BaseModel{
    private String name;
    private double weight;
    private String code;
    private byte[] image;
    @Column(name = "drone_id", nullable = false)
    private Long droneId;
}
