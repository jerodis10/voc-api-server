package com.jerodis.repository;

import com.jerodis.domain.Voc;
import com.jerodis.dto.VocDto;

import java.util.List;

public interface VocRepository {

    void save(Voc voc);

    List<VocDto> findAll();
}
