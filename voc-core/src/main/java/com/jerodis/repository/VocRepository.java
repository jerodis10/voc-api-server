package com.jerodis.repository;

import com.jerodis.domain.Voc;
import com.jerodis.dto.VocDto;

import java.util.List;
import java.util.Optional;

public interface VocRepository {

    void save(Voc voc);

    List<VocDto> findAll();

    Optional<Voc> findOne(String vocNo);
}
