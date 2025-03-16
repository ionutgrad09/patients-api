package com.app.patients_api.controller;

import com.app.patients_api.model.dto.UserDto;
import com.app.patients_api.model.dto.mapper.UserMapper;
import com.app.patients_api.service.PermissionService;
import com.app.patients_api.service.UserService;
import lombok.AllArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/user", produces = APPLICATION_JSON_VALUE)
public class UserController {

    private final UserService userService;
    private final PermissionService permissionService;

    @GetMapping("/all")
    public List<UserDto> getAllUsers(@RequestParam(name="unitId", required = false) Long unitId) {

        permissionService.checkCanSeeUsers(unitId);

        if (permissionService.isSuperAdmin()) {
            return userService.findAll().stream()
                    .map(UserMapper::toDto)
                    .toList();
        }

        return userService.findAllByUnitId(unitId).stream()
                .map(UserMapper::toDto)
                .toList();
    }

    @PostMapping
    public UserDto createUser(@RequestBody UserDto userDto) {
        
        permissionService.canEditUser(userDto);
        
        final var userEntity = UserMapper.toEntity(userDto);

        final var createdUser = userService.createUser(userEntity);

        return UserMapper.toDto(createdUser);
    }

    @DeleteMapping
    public Boolean deleteUser(@RequestParam("username") final String username) {

        permissionService.canDeleteUser(username);

        userService.deleteUser(username);

        return true;
    }

}
