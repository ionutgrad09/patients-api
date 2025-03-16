package com.app.patients_api.model.dto.mapper;

import com.app.patients_api.model.dto.UnitDto;
import com.app.patients_api.model.dto.UserDto;
import com.app.patients_api.model.entities.Unit;
import com.app.patients_api.model.entities.User;

public class UnitMapper {

    public static Unit toEntity(UnitDto dto) {
        if (dto == null) {
            return null;
        }
        return Unit.builder()
                .id(dto.getId())
                .name(dto.getName())
                .build();
    }

    public static UnitDto toDto(Unit entity) {
        if (entity == null) {
            return null;
        }

        return UnitDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }
}
