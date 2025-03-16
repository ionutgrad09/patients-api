package com.app.patients_api.model;

import lombok.Getter;

@Getter
public enum Role {
    SUPER_ADMIN("SUPER_ADMIN"),
    ADMIN("ADMIN"),
    MODERATOR("MODERATOR"),
    OBSERVER("OBSERVER");

    private final String name;

    Role(final String role) {
        this.name = role;
    }


}
