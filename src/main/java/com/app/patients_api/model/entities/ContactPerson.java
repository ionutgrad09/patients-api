package com.app.patients_api.model.entities;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContactPerson {

    private String email;
    private String firstName;
    private String lastName;
    private String phoneNumber;

}
