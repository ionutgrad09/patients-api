package com.app.patients_api.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PatientDto implements Serializable {

    @Serial
    private static final long serialVersionUID = -928776773318300054L;

    @NotNull
    private String patientId;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String gender;

    @NotNull
    private Long dateOfBirth;

    private String mentions;
    private String recommendation;
    private String diseases;

    @NotNull
    private Long unitId;

    private List<ContactPersonDto> contactPersons;
}
