package com.app.patients_api.service;

import com.app.patients_api.model.entities.Unit;
import com.app.patients_api.repository.UnitRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class UnitService {

    private final UnitRepository unitRepository;

    public Unit getUnit(final Long id) {
        return unitRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Can't find unit with id " + id));
    }

    public List<Unit> getAllUnits() {
        return unitRepository.findAllNotDeleted();
    }

    @Transactional
    public Unit putUnit(final Unit unit) {
        return unitRepository.save(unit);
    }

    @Transactional
    public void deleteUnit(final Long id) {

        final var unit = getUnit(id);

        unit.setDeleted(true);

        unitRepository.save(unit);

    }

}
