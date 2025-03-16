package com.app.patients_api.model.dto;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DailyStatusDto implements Serializable {

    @Serial
    private static final long serialVersionUID = -6505384140955157856L;

    private String patientId;
    private Long timestamp;
    private String activities;
    private String mentions;
    private String medication;
    private String healthCondition;
    private String meals;
    private String assignedTo;
}
