package com.app.patients_api.service;

import com.app.patients_api.exceptions.ForbiddenException;
import com.app.patients_api.exceptions.NotFoundException;
import com.app.patients_api.model.Role;
import com.app.patients_api.model.dto.UserDto;
import com.app.patients_api.model.entities.Patient;
import com.app.patients_api.model.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class PermissionService {

    private final UserService userService;

    public User getCurrentUser() {
        final var authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            final var username = authentication.getName();
            return userService.findByUsername(username);
        }
        return null;
    }

    public boolean isSuperAdmin() {
        return getCurrentUser().getRole() == Role.SUPER_ADMIN;
    }

    public boolean isAdmin() {
        return getCurrentUser().getRole() == Role.SUPER_ADMIN;
    }

    public boolean isModerator() {
        return getCurrentUser().getRole() == Role.MODERATOR;
    }

    public void isSameUnit(final Long unitId) {

        if (isSuperAdmin()) {
            return;
        }

        if (!Objects.equals(getCurrentUser().getUnitId(), unitId)) {
            throw new ForbiddenException("You don't have the permissions for the requested unit id");
        }
    }

    public void canEditUser(final UserDto userDto) {

        if (isSuperAdmin()) {
            return;
        }

        if (isModerator() || (isAdmin() && userDto.getRole() != Role.MODERATOR)) {
            throw new ForbiddenException("You don't have the permissions to do this action");
        }

        isSameUnit(userDto.getUnitId());
    }

    public void canDeleteUser(final String username) {

        if (isSuperAdmin()) {
            return;
        }

        final var user = userService.findByUsername(username);


        if (isModerator() ||
                (isAdmin() && user.getRole() != Role.MODERATOR) ||
                (isAdmin() && !Objects.equals(user.getUnitId(), getCurrentUser().getUnitId()))) {
            throw new ForbiddenException("You don't have the permissions to delete this user");
        }
    }

    public void canReadPatient(final Patient patient) {

        if (isSuperAdmin()) {
            return;
        }

        if (!Objects.equals(getCurrentUser().getUnitId(), patient.getUnitId())) {
            throw new ForbiddenException("You don't have the permissions for the requested patient");
        }
    }

    public void canModifyPatient(final Long unitId) {

        if (isModerator()) {
            throw new ForbiddenException("You don't have the permissions for the requested patient");
        }

        isSameUnit(unitId);
    }

    public void canDeletePatient() {

        if (isModerator()) {
            throw new ForbiddenException("You don't have the permissions for the requested patient");
        }

    }


    public void checkCanSeeUsers(final Long unitId) {

        if (isModerator()) {
            throw new ForbiddenException("You don't have the permissions to see all users");
        }

        isSameUnit(unitId);
    }

    public void hasUnitAccess() {
        if (!isSuperAdmin()) {
            throw new ForbiddenException("You don't have the permission to see all units");
        }
    }

    public void checkIsContactPerson(final Patient patient, final String observerEmail) {
        final var observerIsAContactPerson = patient.getContactPersons().stream()
                .anyMatch(contactPerson -> contactPerson.getEmail().equals(observerEmail));

        if (!observerIsAContactPerson) {
            throw new NotFoundException("Observer is not a contact person for this patient");
        }
    }

}
