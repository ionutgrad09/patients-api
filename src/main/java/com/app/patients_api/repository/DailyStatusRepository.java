package com.app.patients_api.repository;

import com.app.patients_api.model.entities.DailyStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DailyStatusRepository extends JpaRepository<DailyStatus, Long> {

    @Query("SELECT ds FROM DailyStatus ds WHERE ds.patientId = :patientId AND ds.timestamp = :timestamp")
    Optional<DailyStatus> findDailyStatus(String patientId, Long timestamp);


}
