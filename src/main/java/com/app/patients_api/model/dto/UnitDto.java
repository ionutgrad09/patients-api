package com.app.patients_api.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UnitDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 6904284478286643039L;

    private Long id;
    private String name;
}
