package io.logizstikz.dronez.model.request;

import lombok.Data;
import org.springframework.lang.NonNull;

@Data
public class DispatchRequest {
    @NonNull
    private String name;
    @NonNull
    private double weight;
    @NonNull
    private String code;
    private byte[] image;
}
