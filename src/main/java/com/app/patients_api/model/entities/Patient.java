package com.app.patients_api.model.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;

import java.util.List;

import static org.hibernate.type.SqlTypes.JSON;

@Data
@Table(name = "patient")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Patient {

    @Id
    @Column(name = "patient_id", nullable = false)
    private String patientId;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name = "date_of_birth", nullable = false)
    private Long dateOfBirth;

    @Column(name = "mentions", nullable = false)
    private String mentions;

    @Column(name = "recommendation", nullable = false)
    private String recommendation;

    @Column(name = "diseases", nullable = false)
    private String diseases;

    @Column(name = "unit_id", nullable = false)
    private Long unitId;

    @JdbcTypeCode(JSON)
    @Column(name = "contact_persons", columnDefinition = "jsonb")
    private List<ContactPerson> contactPersons;

    @Column(name = "deleted", nullable = false)
    private boolean deleted;

}
