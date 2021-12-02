package io.logizstikz.dronez.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

@Data
@Document(indexName = "drone_state_audit_event")
public class DroneStateAuditEvent {
    @Id
    private String id;
    @Field(type = FieldType.Integer)
    private Integer batteryLevel;
    @Field(type = FieldType.Long)
    private Long droneId;
    @Field(type = FieldType.Text)
    private String droneName;
    @Field(type = FieldType.Date, format = DateFormat.custom, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    private Date date;
}
