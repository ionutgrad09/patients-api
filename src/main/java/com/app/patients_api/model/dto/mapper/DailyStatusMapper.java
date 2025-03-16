package com.app.patients_api.model.dto.mapper;

import com.app.patients_api.model.dto.DailyStatusDto;
import com.app.patients_api.model.entities.DailyStatus;

public class DailyStatusMapper {

    public static DailyStatus toEntity(DailyStatusDto dto) {
        if (dto == null) {
            return null;
        }
        return DailyStatus.builder()
                .patientId(dto.getPatientId())
                .timestamp(dto.getTimestamp())
                .activities(dto.getActivities())
                .mentions(dto.getMentions())
                .medication(dto.getMedication())
                .healthCondition(dto.getHealthCondition())
                .meals(dto.getMeals())
                .assignedTo(dto.getAssignedTo())
                .build();
    }

    public static DailyStatusDto toDto(DailyStatus entity) {
        if (entity == null) {
            return null;
        }
        return DailyStatusDto.builder()
                .patientId(entity.getPatientId())
                .timestamp(entity.getTimestamp())
                .activities(entity.getActivities())
                .mentions(entity.getMentions())
                .medication(entity.getMedication())
                .healthCondition(entity.getHealthCondition())
                .meals(entity.getMeals())
                .assignedTo(entity.getAssignedTo())
                .build();
    }
}
