package com.app.patients_api.model.dto.mapper;

import com.app.patients_api.model.dto.PatientDto;
import com.app.patients_api.model.dto.ContactPersonDto;
import com.app.patients_api.model.entities.Patient;
import com.app.patients_api.model.entities.ContactPerson;

import java.util.List;
import java.util.stream.Collectors;

public class PatientMapper {

    public static Patient toEntity(PatientDto dto) {
        if (dto == null) {
            return null;
        }
        return Patient.builder()
                .patientId(dto.getPatientId())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .gender(dto.getGender())
                .dateOfBirth(dto.getDateOfBirth())
                .mentions(dto.getMentions())
                .recommendation(dto.getRecommendation())
                .diseases(dto.getDiseases())
                .unitId(dto.getUnitId())
                .contactPersons(dto.getContactPersons() != null
                        ? dto.getContactPersons().stream()
                        .map(ContactPersonMapper::toEntity)
                        .collect(Collectors.toList())
                        : null)
                .build();
    }

    public static PatientDto toDto(Patient entity) {
        if (entity == null) {
            return null;
        }
        return PatientDto.builder()
                .patientId(entity.getPatientId())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .gender(entity.getGender())
                .dateOfBirth(entity.getDateOfBirth())
                .mentions(entity.getMentions())
                .recommendation(entity.getRecommendation())
                .diseases(entity.getDiseases())
                .unitId(entity.getUnitId())
                .contactPersons(entity.getContactPersons() != null
                        ? entity.getContactPersons().stream()
                        .map(ContactPersonMapper::toDto)
                        .collect(Collectors.toList())
                        : null)
                .build();
    }

}
