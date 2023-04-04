package com.jerodis.service;

import com.jerodis.domain.Compensation;
import com.jerodis.dto.*;
import com.jerodis.repository.CompensationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CompensationService {

    private final CompensationRepository compensationRepository;

    @Transactional
    public void compensationSave(CompensationForm compensationForm) {
        Compensation compensation = Compensation.builder()
                .amount(compensationForm.getAmount())
                .build();

        compensationRepository.save(compensation);
    }

    @Transactional(readOnly = true)
    public List<CompensationResponse> compensationFindAll() {
        List<CompensationDto> compensationList = compensationRepository.findAll();

        return compensationList.stream()
                .map(com -> new CompensationResponse(com.getAmount()))
                .collect(Collectors.toList());
    }
}
