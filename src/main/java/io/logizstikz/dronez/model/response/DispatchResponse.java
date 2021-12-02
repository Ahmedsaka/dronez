package io.logizstikz.dronez.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.logizstikz.dronez.model.DroneState;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DispatchResponse {
    private DroneState droneState;
    @JsonProperty("dispatch-item")
    private Object object;
}
