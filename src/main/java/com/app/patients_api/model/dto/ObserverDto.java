package com.app.patients_api.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ObserverDto implements Serializable {

    @Serial
    private static final long serialVersionUID = -555018680575010900L;

    private String patientIdentifier;
    private String observerEmail;
    private Long timestamp;
}
