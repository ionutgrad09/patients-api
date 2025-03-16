package com.app.patients_api.controller;

import com.app.patients_api.model.dto.UnitDto;
import com.app.patients_api.model.dto.mapper.UnitMapper;
import com.app.patients_api.service.PermissionService;
import com.app.patients_api.service.UnitService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/unit", produces = APPLICATION_JSON_VALUE)
public class UnitController {

    private final UnitService unitService;
    private final PermissionService permissionService;

    @GetMapping("/all")
    public List<UnitDto> getAllUnits() {

        permissionService.hasUnitAccess();

        final var allUnits = unitService.getAllUnits();

        return allUnits.stream()
                .map(UnitMapper::toDto)
                .toList();
    }

    @PostMapping
    public UnitDto putUnit(@RequestBody UnitDto unitDto) {

        permissionService.hasUnitAccess();

        final var unitEntity = UnitMapper.toEntity(unitDto);

        final var createdUnit = unitService.putUnit(unitEntity);

        return UnitMapper.toDto(createdUnit);
    }

    @DeleteMapping
    public Boolean deleteUnit(@RequestParam("unitId") final Long unitId) {

        permissionService.hasUnitAccess();

        unitService.deleteUnit(unitId);

        return true;
    }

}
