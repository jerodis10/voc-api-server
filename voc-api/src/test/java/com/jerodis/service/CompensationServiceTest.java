package com.jerodis.service;

import com.jerodis.dto.CompensationForm;
import com.jerodis.dto.PenaltyForm;
import com.jerodis.repository.CompensationRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

@SpringBootTest
@Transactional
class CompensationServiceTest {

    @Autowired
    CompensationService compensationService;

    @Autowired
    CompensationRepository compensationRepository;


    @Test
    @DisplayName("등록되지 않은 voc 의 보상 저장시 예외 발생")
    void NoVocCompensationEx() {
        // given
        CompensationForm compensationForm = CompensationForm.builder()
                .vocNo("aa4")
                .amount(1L)
                .build();

        // when then
        Assertions.assertThatThrownBy(() -> compensationService.compensationSave(compensationForm))
                .isInstanceOf(IllegalStateException.class);

    }

    @Test
    @DisplayName("등록되지 않은 voc 의 패널티 저장시 예외 발생")
    void NoVocPenaltyEx() {
        // given
        PenaltyForm penaltyForm = PenaltyForm.builder()
                .vocNo("aa4")
                .build();

        // when then
        Assertions.assertThatThrownBy(() -> compensationService.penaltySave(penaltyForm))
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    @DisplayName("등록되지 않은 보상 의 패널티 저장시 예외 발생")
    void NoVocPenaltyUpdate() {
        // when then
        Assertions.assertThatThrownBy(() -> compensationService.penaltyUpdate("aa4"))
                .isInstanceOf(IllegalStateException.class);
    }

}