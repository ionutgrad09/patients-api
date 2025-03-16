package com.app.patients_api.service;


import com.app.patients_api.model.entities.Patient;
import com.app.patients_api.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;

    public List<Patient> getPatients() {
        return patientRepository.findAllNotDeleted();
    }

    public List<Patient> getPatients(final Long unitId) {
        return patientRepository.findAllNotDeletedByUnitId(unitId);
    }

    public Patient getPatient(final String patientId, final Long unitId) {
        return patientRepository.findByIdAndUnitId(patientId, unitId)
                .orElseThrow(() -> new NoSuchElementException("Pacientul cu CNP-ul:  " + patientId + " nu a putut fi gasit."));
    }

    public Patient getPatient(final String patientId) {
        return patientRepository.findByPatientId(patientId)
                .orElseThrow(() ->new NoSuchElementException("Pacientul cu CNP-ul:  " + patientId + " nu a putut fi gasit."));
    }

    @Transactional
    public Patient putPatient(final Patient patient) {
        return patientRepository.save(patient);
    }

    @Transactional
    public void deletePatient(final String id, final Long unitId) {

        final var patient = getPatient(id, unitId);

        patient.setDeleted(true);

        patientRepository.save(patient);

    }

}
