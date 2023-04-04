package com.jerodis.service;

import com.jerodis.domain.Voc;
import com.jerodis.dto.VocDto;
import com.jerodis.dto.VocResponse;
import com.jerodis.repository.VocRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class VocService {

    private final VocRepository vocRepository;

    @Transactional
    public void vocSave(VocDto vocDto) {
        Voc voc = Voc.builder()
                .party(vocDto.getParty())
                .content(vocDto.getContent())
                .build();

        vocRepository.save(voc);
    }

    public List<VocResponse> findAll() {
        return vocRepository.findAll();
    }
}
