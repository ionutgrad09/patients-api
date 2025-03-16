package com.app.patients_api.repository;

import com.app.patients_api.model.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, String> {

    @Query("SELECT p FROM Patient p WHERE p.patientId = :patientId AND NOT p.deleted")
    Optional<Patient> findByPatientId(String patientId);

    @Query("SELECT p FROM Patient p WHERE p.patientId = :patientId AND p.unitId = :unitId AND NOT p.deleted")
    Optional<Patient> findByIdAndUnitId(String patientId, Long unitId);

    @Query("SELECT p FROM Patient p WHERE NOT p.deleted")
    List<Patient> findAllNotDeleted();

    @Query("SELECT p FROM Patient p WHERE p.unitId = :unitId AND NOT p.deleted")
    List<Patient> findAllNotDeletedByUnitId(Long unitId);
}
