package com.app.patients_api.controller;

import com.app.patients_api.model.dto.DailyStatusDto;
import com.app.patients_api.model.dto.ObserverDto;
import com.app.patients_api.model.dto.PatientDto;
import com.app.patients_api.model.dto.mapper.DailyStatusMapper;
import com.app.patients_api.model.dto.mapper.PatientMapper;
import com.app.patients_api.model.entities.Patient;
import com.app.patients_api.service.DailyStatusService;
import com.app.patients_api.service.PatientService;
import com.app.patients_api.service.PermissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/observer", produces = APPLICATION_JSON_VALUE)
public class ObserverController {

    private final PatientService patientService;
    private final PermissionService permissionService;
    private final DailyStatusService dailyStatusService;

    @PostMapping
    public Patient loginObserver(@RequestBody ObserverDto observerDto) {

        final var patient = patientService.getPatient(observerDto.getPatientIdentifier());

        permissionService.checkIsContactPerson(patient, observerDto.getObserverEmail());

        return patient;
    }

    @GetMapping("/daily-status")
    public DailyStatusDto getDailyStatus(@RequestParam("patientId") final String patientId,
                                         @RequestParam("observerEmail") final String observerEmail,
                                         @RequestParam("timestamp") final Long timestamp) {

        final var patient = patientService.getPatient(patientId);

        permissionService.checkIsContactPerson(patient, observerEmail);

        final var dailyStatus = dailyStatusService.getDailyStatus(patientId, timestamp);

        return DailyStatusMapper.toDto(dailyStatus);

    }

    @GetMapping("/patient")
    public PatientDto getPatient(@RequestParam("patientId") String patientId, @RequestParam("observerEmail") final String observerEmail) {

        final var patient = patientService.getPatient(patientId);

        permissionService.checkIsContactPerson(patient, observerEmail);

        return PatientMapper.toDto(patient);
    }


}
