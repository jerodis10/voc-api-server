package com.jerodis.service;

import com.jerodis.domain.Compensation;
import com.jerodis.domain.Penalty;
import com.jerodis.domain.Voc;
import com.jerodis.dto.*;
import com.jerodis.repository.CompensationRepository;
import com.jerodis.repository.VocRepository;
import com.jerodis.util.ExistType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Slf4j
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

            compensationRepository.findOne(compensationForm.getVocNo())
                    .ifPresent(v -> { throw new RuntimeException("해당 보상 정보가 이미 존재합니다."); });

            compensationRepository.save(compensation);
        } catch (Exception e) {
//            ExceptionHandler.handleException(exception);
            log.error("[보상 정보 저장] Exception: {}", e);
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    @Transactional(readOnly = true)
    public List<CompensationResponse> compensationFindAll() {
        try {
            List<CompensationDto> compensationList = compensationRepository.findAll();

            return compensationList.stream()
                    .map(com -> new CompensationResponse(com.getAmount()))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            log.error("[보상 정보 조회] Exception: {}", e);
            throw new RuntimeException("보상 정보 조회가 실패했습니다.", e);
        }
    }

    @Transactional
    public void penaltySave(PenaltyForm penaltyForm) {
        try {
            Penalty penalty = Penalty.builder()
                    .penaltyYn(ExistType.NO.getType())
                    .name(penaltyForm.getName())
                    .amount(penaltyForm.getAmount())
                    .build();

            Voc voc = vocRepository.findOne(penaltyForm.getVocNo())
                        .orElseThrow(() -> new NoSuchElementException("[패널티 저장 오류] VOC 가 존재하지 않습니다."));

            penalty.setVoc(voc);

            compensationRepository.penaltySave(penalty);
        } catch (Exception e) {
            log.error("[패널티 저장] Exception: {}", e);
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    @Transactional
    public void penaltyUpdate(String vocNo) {
        try {
            Penalty findPenalty = compensationRepository.findOne(vocNo)
                        .orElseThrow(() -> new NoSuchElementException("[패널티 등록 여부 저장 오류] 패널티가 존재하지 않습니다."));

            compensationRepository.updatePenalty(vocNo);
        } catch (Exception e) {
            log.error("[패널티 등록 여부 저장] Exception: {}", e);
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}
