package com.jerodis.repository;

import com.jerodis.domain.Compensation;
import com.jerodis.domain.Penalty;
import com.jerodis.dto.CompensationDto;

import java.util.List;
import java.util.Optional;

public interface CompensationRepository {

    void save(Compensation compensation);

    List<CompensationDto> findAll();

    void penaltySave(Penalty penalty);

    Optional<Penalty> findOne(String vocNo);

    void updatePenalty(String vocNo);

}
