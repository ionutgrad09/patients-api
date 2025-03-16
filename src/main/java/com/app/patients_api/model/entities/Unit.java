package com.app.patients_api.model.entities;

import jakarta.persistence.*;
import lombok.*;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Data
@Table(name = "unit")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Unit {

    @Id
    @GeneratedValue(generator = "unit-sequence-generator", strategy = SEQUENCE)
    @SequenceGenerator(name = "unit-sequence-generator", sequenceName = "unit_seq", allocationSize = 1)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "deleted", nullable = false)
    private boolean deleted;


}
