package com.app.patients_api.model.entities.id;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class DailyStatusID implements Serializable {

    @Serial
    private static final long serialVersionUID = -3009101733507961105L;

    private String patientId;

    private Long timestamp;
}

