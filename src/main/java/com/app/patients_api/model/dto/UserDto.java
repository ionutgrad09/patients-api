package com.app.patients_api.model.dto;

import com.app.patients_api.model.Permission;
import com.app.patients_api.model.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserDto implements Serializable {

    @Serial
    private static final long serialVersionUID = -3143057927811478651L;

    private String username;
    private String firstName;
    private String password;
    private String lastName;
    private String phoneNumber;
    private Role role;
    private Long unitId;
    private List<Permission> permissions;
}
