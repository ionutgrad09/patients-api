package com.app.patients_api.controller;

import com.app.patients_api.model.dto.PatientDto;
import com.app.patients_api.model.dto.mapper.PatientMapper;
import com.app.patients_api.service.PatientService;
import com.app.patients_api.service.PermissionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/patient", produces = APPLICATION_JSON_VALUE)
public class PatientController {

    private final PatientService patientService;
    private final PermissionService permissionService;

    @GetMapping("/all")
    public List<PatientDto> getAllPatients(@RequestParam(name = "unitId") final Long unitId) {

        permissionService.isSameUnit(unitId);

        if (permissionService.isSuperAdmin()) {
            final var allPatients = patientService.getPatients();
            return allPatients.stream()
                    .map(PatientMapper::toDto)
                    .toList();
        }

        return patientService.getPatients(unitId).stream()
                .map(PatientMapper::toDto)
                .toList();
    }

    @GetMapping
    public PatientDto getPatient(@RequestParam("patientId") String patientId) {

        final var currentUser = permissionService.getCurrentUser();

        if (permissionService.isSuperAdmin()) {
            return PatientMapper.toDto(patientService.getPatient(patientId));
        }

        final var patient = patientService.getPatient(patientId, currentUser.getUnitId());

        return PatientMapper.toDto(patient);
    }


    @PostMapping
    public PatientDto createPatient(@RequestBody PatientDto patientDto) {

        permissionService.canModifyPatient(patientDto.getUnitId());

        final var patientEntity = PatientMapper.toEntity(patientDto);

        final var createdPatient = patientService.putPatient(patientEntity);

        return PatientMapper.toDto(createdPatient);
    }

    @DeleteMapping
    public Boolean deletePatient(@RequestParam("patientId") final String patientId) {

        permissionService.canDeletePatient();

        if (permissionService.isSuperAdmin()) {

            final var patient = patientService.getPatient(patientId);

            patientService.deletePatient(patientId, patient.getUnitId());

            return true;
        }

        final var currentUser = permissionService.getCurrentUser();

        patientService.deletePatient(patientId, currentUser.getUnitId());

        return true;
    }

}
