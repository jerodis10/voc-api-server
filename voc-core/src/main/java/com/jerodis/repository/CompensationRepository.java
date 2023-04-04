package com.jerodis.repository;

import com.jerodis.domain.Compensation;
import com.jerodis.domain.Penalty;
import com.jerodis.dto.CompensationDto;

import java.util.List;

public interface CompensationRepository {

    void save(Compensation compensation);

    List<CompensationDto> findAll();

    void penaltySave(Penalty penalty);

}
