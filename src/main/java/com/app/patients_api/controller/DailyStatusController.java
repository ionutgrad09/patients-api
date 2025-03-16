package com.app.patients_api.controller;

import com.app.patients_api.model.dto.DailyStatusDto;
import com.app.patients_api.model.dto.mapper.DailyStatusMapper;
import com.app.patients_api.service.DailyStatusService;
import com.app.patients_api.service.PermissionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/daily-status", produces = APPLICATION_JSON_VALUE)
public class DailyStatusController {

    private final DailyStatusService dailyStatusService;

    private final PermissionService permissionService;


    @PostMapping
    public DailyStatusDto updateDailyStatus(@RequestBody DailyStatusDto dailyStatusDto) {

        final var currentUser = permissionService.getCurrentUser();

        final var dailyStatusEntity = DailyStatusMapper.toEntity(dailyStatusDto);

        final var updatedDailyStatus = dailyStatusService.updateDailyStatus(dailyStatusEntity, currentUser.getUnitId());

        return DailyStatusMapper.toDto(updatedDailyStatus);
    }

    @GetMapping
    public DailyStatusDto getDailyStatus(@RequestParam("patientId") final String patientId,
                                         @RequestParam("timestamp") final Long timestamp) {

        final var currentUser = permissionService.getCurrentUser();

        final var dailyStatus = dailyStatusService.getDailyStatus(patientId, timestamp, currentUser.getUnitId());

        return DailyStatusMapper.toDto(dailyStatus);

    }

}
