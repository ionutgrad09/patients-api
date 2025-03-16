package com.app.patients_api.model.entities;

import com.app.patients_api.model.entities.id.DailyStatusID;
import jakarta.persistence.*;
import lombok.*;

@Data
@Table(name = "daily_status")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@IdClass(DailyStatusID.class)
public class DailyStatus {

    @Id
    @Column(name = "patient_id", nullable = false)
    private String patientId;

    @Id
    @Column(name = "timestamp", nullable = false)
    private Long timestamp;

    @Column(name = "activities")
    private String activities;

    @Column(name = "mentions")
    private String mentions;

    @Column(name = "medication")
    private String medication;

    @Column(name = "health_condition")
    private String healthCondition;

    @Column(name = "meals")
    private String meals;

    @Column(name = "assigned_to")
    private String assignedTo;

}
