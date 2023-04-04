package com.jerodis.repository;

import com.jerodis.domain.Voc;
import com.jerodis.dto.VocDto;
import com.jerodis.dto.VocResponse;

import java.util.List;

public interface VocRepository {

    void save(Voc voc);

    List<VocResponse> findAll();
}
