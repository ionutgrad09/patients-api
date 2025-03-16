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
public class ContactPersonDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 3231022211749542318L;

    private String email;
    private String firstName;
    private String lastName;
    private String phoneNumber;
}
