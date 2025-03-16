package com.app.patients_api.model;

import lombok.Getter;

@Getter
public enum Permission {

    VIEW_PATIENT("VIEW_PATIENT"),
    CREATE_PATIENT("CREATE_PATIENT"),

    UPDATE_DAILY_STATUS("UPDATE_DAILY_STATUS"),

    VIEW_USER("VIEW_USER"),
    CREATE_USER("CREATE_USER"),

    VIEW_UNIT("VIEW_UNIT"),
    CREATE_UNIT("CREATE_UNIT");



    private final String name;
    Permission(final String name) {
        this.name = name;
    }
}
