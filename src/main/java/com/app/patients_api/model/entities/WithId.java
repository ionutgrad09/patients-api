package com.app.patients_api.model.entities;

import java.io.Serializable;

public interface WithId extends Serializable {

    Long getId();

    void setId(Long id);
}

