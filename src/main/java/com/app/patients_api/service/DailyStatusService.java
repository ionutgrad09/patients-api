package com.app.patients_api.service;

import com.app.patients_api.model.entities.DailyStatus;
import com.app.patients_api.repository.DailyStatusRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class DailyStatusService {

    private final DailyStatusRepository dailyStatusRepository;
    private final PatientService patientService;

    public DailyStatus getDailyStatus(final String patientId, final Long timestamp, final Long unitId) {

        patientService.getPatient(patientId, unitId);

        return dailyStatusRepository.findDailyStatus(patientId, timestamp).orElse(emptyDailyStatus(patientId, timestamp));
    }

    public DailyStatus getDailyStatus(final String patientId, final Long timestamp) {

        return dailyStatusRepository.findDailyStatus(patientId, timestamp).orElse(emptyDailyStatus(patientId, timestamp));
    }

    public DailyStatus updateDailyStatus(final DailyStatus dailyStatus, final Long unitId) {

        patientService.getPatient(dailyStatus.getPatientId(), unitId);

        return dailyStatusRepository.save(dailyStatus);
    }


    private DailyStatus emptyDailyStatus(final String patientId, final Long timestamp) {
        return DailyStatus.builder().patientId(patientId).timestamp(timestamp).build();
    }

}
