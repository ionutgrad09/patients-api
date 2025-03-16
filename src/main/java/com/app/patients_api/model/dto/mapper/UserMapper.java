package com.app.patients_api.model.dto.mapper;

import com.app.patients_api.exceptions.InternalServerErrorException;
import com.app.patients_api.model.Permission;
import com.app.patients_api.model.Role;
import com.app.patients_api.model.RolePermissions;
import com.app.patients_api.model.dto.UserDto;
import com.app.patients_api.model.entities.User;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class UserMapper {

    public User toEntity(UserDto dto) {
        if (dto == null) {
            return null;
        }
        return User.builder()
                .username(dto.getUsername())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .password(dto.getPassword())
                .phoneNumber(dto.getPhoneNumber())
                .role(dto.getRole())
                .unitId(dto.getUnitId())
                .build();
    }

    public UserDto toDto(User entity) {
        if (entity == null) {
            return null;
        }

        return UserDto.builder()
                .username(entity.getUsername())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .phoneNumber(entity.getPhoneNumber())
                .role(entity.getRole())
                .unitId(entity.getUnitId())
                .permissions(getPermissions(entity.getRole()))
                .build();
    }

    private List<Permission> getPermissions(final Role role) {
        if (role == Role.MODERATOR) {
            return RolePermissions.MODERATOR_PERMISSIONS;
        } else if (role == Role.ADMIN) {
            return RolePermissions.ADMIN_PERMISSIONS;
        } else if (role == Role.SUPER_ADMIN) {
            return RolePermissions.SUPER_ADMIN_PERMISSIONS;
        }

        throw new InternalServerErrorException("Unrecognized role: " + role);
    }
}
