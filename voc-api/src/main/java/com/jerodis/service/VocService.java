package com.jerodis.service;

import com.jerodis.domain.Voc;
import com.jerodis.dto.VocDto;
import com.jerodis.dto.VocForm;
import com.jerodis.dto.VocResponse;
import com.jerodis.exception.VocException;
import com.jerodis.exception.VocExceptionStatus;
import com.jerodis.repository.VocRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Slf4j
public class VocService {

    private final VocRepository vocRepository;

    private  final ApplicationEventPublisher eventPublisher;

    @Transactional
    public void vocSave(VocForm vocForm) {
        try {
            Voc voc = Voc.builder()
                    .vocNo(vocForm.getVocNo())
                    .party(vocForm.getParty())
                    .content(vocForm.getContent())
                    .build();

            vocRepository.findOne(vocForm.getVocNo())
                    .ifPresent(v -> { throw new VocException(VocExceptionStatus.DUPLICATION_VOC); });

            vocRepository.save(voc);

        } catch (VocException vocException) {
            log.error("[VOC 저장] VocException: {}", vocException.getMessage());
            throw vocException;
        } catch (Exception e) {
            log.error("[VOC 저장] Exception: {}", e.getMessage());
            throw new IllegalStateException("VOC 저장 에러", e);
        }
    }

    @Transactional(readOnly = true)
    public List<VocResponse> vocFindAll() {
        try {
            List<VocDto> vocList = vocRepository.findAll();

            return vocList.stream()
                    .map(voc -> new VocResponse(voc.getParty(), voc.getContent(), voc.getAmount(), voc.getName()))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            log.error("[VOC 조회] Exception: {}", e.getMessage());
            throw new IllegalStateException("VOC 조회 에러", e);
        }
    }

    @Transactional
    public void vocUpdate(VocForm vocForm) {
        try {
            vocRepository.findOne(vocForm.getVocNo())
                    .orElseThrow(() -> new VocException(VocExceptionStatus.NO_VOC));

            vocRepository.update(vocForm.getVocNo());
        } catch (VocException vocException) {
            log.error("[이의제기 저장] VocException: {}", vocException.getMessage());
            throw vocException;
        } catch (Exception e) {
            log.error("[이의제기 저장] Exception: {}", e.getMessage());
            throw new IllegalStateException("이의제기 저장 에러", e);
        }
    }
}
