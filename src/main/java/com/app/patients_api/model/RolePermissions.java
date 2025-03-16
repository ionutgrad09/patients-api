package com.app.patients_api.model;

import java.util.List;

public class RolePermissions {

    public static List<Permission> SUPER_ADMIN_PERMISSIONS = List.of(
        Permission.VIEW_PATIENT,
        Permission.CREATE_PATIENT,
        Permission.UPDATE_DAILY_STATUS,
        Permission.VIEW_USER,
        Permission.CREATE_USER,
        Permission.VIEW_UNIT,
        Permission.CREATE_UNIT
    );

    public static List<Permission> ADMIN_PERMISSIONS = List.of(
            Permission.VIEW_PATIENT,
            Permission.CREATE_PATIENT,
            Permission.UPDATE_DAILY_STATUS,
            Permission.VIEW_USER,
            Permission.CREATE_USER
    );

    public static List<Permission> MODERATOR_PERMISSIONS = List.of(
            Permission.VIEW_PATIENT,
            Permission.UPDATE_DAILY_STATUS
    );

    public static List<Permission> OBSERVER_PERMISSIONS = List.of(
            Permission.VIEW_PATIENT
    );

}
