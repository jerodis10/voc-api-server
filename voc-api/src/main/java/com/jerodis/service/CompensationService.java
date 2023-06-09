package com.jerodis.service;

import com.jerodis.domain.Compensation;
import com.jerodis.domain.Penalty;
import com.jerodis.domain.Voc;
import com.jerodis.dto.*;
import com.jerodis.exception.VocException;
import com.jerodis.exception.VocExceptionStatus;
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
                    .orElseThrow(() -> new VocException(VocExceptionStatus.NO_VOC));

            compensation.setVoc(voc);

            compensationRepository.findOne(compensationForm.getVocNo())
                    .ifPresent(v -> { throw new IllegalStateException("해당 보상 정보가 이미 존재합니다."); });

            compensationRepository.save(compensation);
        } catch (VocException vocException) {
            log.error("[보상 정보 저장] VocException: {}", vocException.getMessage());
            throw vocException;
        } catch (Exception e) {
            log.error("[보상 정보 저장] Exception: {}", e.getMessage());
            throw new IllegalStateException(e.getMessage(), e);
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
            log.error("[보상 정보 조회] Exception: {}", e.getMessage());
            throw new IllegalStateException("보상 정보 조회가 실패했습니다.", e);
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
                    .orElseThrow(() -> new VocException(VocExceptionStatus.NO_VOC));

            penalty.setVoc(voc);

            compensationRepository.penaltySave(penalty);
        } catch (VocException vocException) {
            log.error("[패널티 저장] VocException: {}", vocException.getMessage());
            throw vocException;
        } catch (Exception e) {
            log.error("[패널티 저장] Exception: {}", e.getMessage());
            throw new IllegalStateException(e.getMessage(), e);
        }
    }

    @Transactional
    public void penaltyUpdate(String vocNo) {
        try {
            compensationRepository.findOne(vocNo)
                        .orElseThrow(() -> new NoSuchElementException("[패널티 등록 여부 저장 오류] 보상이 존재하지 않습니다."));

            compensationRepository.updatePenalty(vocNo);
        } catch (Exception e) {
            log.error("[패널티 등록 여부 저장] Exception: {}", e.getMessage());
            throw new IllegalStateException(e.getMessage(), e);
        }
    }
}
