package com.jerodis.service;

import com.jerodis.domain.Penalty;
import com.jerodis.domain.Voc;
import com.jerodis.dto.PenaltyForm;
import com.jerodis.dto.VocDto;
import com.jerodis.dto.VocForm;
import com.jerodis.dto.VocResponse;
import com.jerodis.repository.VocRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class VocService {

    private final VocRepository vocRepository;

    @Transactional
    public void vocSave(VocForm vocForm) {
        Voc voc = Voc.builder()
                .vocNo(vocForm.getVocNo())
                .party(vocForm.getParty())
                .content(vocForm.getContent())
                .build();

        vocRepository.save(voc);
    }

    @Transactional(readOnly = true)
    public List<VocResponse> vocFindAll() {
        List<VocDto> vocList = vocRepository.findAll();

        return vocList.stream()
                .map(voc -> new VocResponse(voc.getParty(), voc.getContent(), voc.getAmount(), voc.getName()))
                .collect(Collectors.toList());
    }

    @Transactional
    public void vocUpdate(VocForm vocForm) {
        vocRepository.update(vocForm.getVocNo());
    }
}
