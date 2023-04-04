package com.jerodis.service;

import com.jerodis.domain.Compensation;
import com.jerodis.domain.Penalty;
import com.jerodis.domain.Voc;
import com.jerodis.dto.*;
import com.jerodis.repository.CompensationRepository;
import com.jerodis.repository.VocRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CompensationService {

    private final CompensationRepository compensationRepository;
    private final VocRepository vocRepository;

    @Transactional
    public void compensationSave(CompensationForm compensationForm) {
        try {
            Compensation compensation = Compensation.builder()
                    .amount(compensationForm.getAmount())
                    .build();

            Voc voc = vocRepository.findOne(compensationForm.getVocNo())
                    .orElseThrow(() -> new NoSuchElementException("VOC 가 존재하지 않습니다."));
            compensation.setVoc(voc);

            compensationRepository.save(compensation);
        } catch (Exception exception) {
//            ReviewExceptionHandler.handleException(exception);
            throw new IllegalStateException("VOC 저장 오류");
        }
    }

    @Transactional(readOnly = true)
    public List<CompensationResponse> compensationFindAll() {
        List<CompensationDto> compensationList = compensationRepository.findAll();

        return compensationList.stream()
                .map(com -> new CompensationResponse(com.getAmount()))
                .collect(Collectors.toList());
    }

    @Transactional
    public void penaltySave(PenaltyForm penaltyForm) {
        try {
            Penalty penalty = Penalty.builder()
                    .penaltyYn("N")
                    .name(penaltyForm.getName())
                    .amount(penaltyForm.getAmount())
                    .build();

            Voc voc = vocRepository.findOne(penaltyForm.getVocNo())
                        .orElseThrow(() -> new NoSuchElementException("VOC 가 존재하지 않습니다."));
            penalty.setVoc(voc);

            compensationRepository.penaltySave(penalty);
        } catch (Exception exception) {
//            ReviewExceptionHandler.handleException(exception);
            throw new IllegalStateException("패널티 저장 오류");
        }
    }

    @Transactional
    public void penaltyUpdate(String vocNo) {
        try {
            Penalty findPenalty = compensationRepository.findOne(vocNo)
                                .orElseThrow(() -> new NoSuchElementException("패널티가 존재하지 않습니다."));

//            Penalty penalty = Penalty.builder()
//                    .penaltyYn("Y")
//                    .name(findPenalty.getName())
//                    .amount(findPenalty.getAmount())
//                    .build();

            compensationRepository.updatePenalty(vocNo);
        } catch (Exception exception) {
            throw new IllegalStateException("패널티 등록 여부 저장 오류");
        }
    }
}
