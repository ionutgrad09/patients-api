package com.app.patients_api.repository;

import com.app.patients_api.model.entities.Unit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UnitRepository extends JpaRepository<Unit, Long> {

    @Query("SELECT u FROM Unit u WHERE NOT u.deleted ORDER BY u.id")
    List<Unit> findAllNotDeleted();
}
