package io.logizstikz.dronez.model;

import io.logizstikz.dronez.Enum.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "drone")
public class Drone extends BaseModel{
    private String name;
    @Enumerated(EnumType.STRING)
    private Model model;
}
