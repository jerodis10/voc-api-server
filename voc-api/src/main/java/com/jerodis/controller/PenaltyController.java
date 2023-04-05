package com.jerodis.controller;

import com.jerodis.dto.PenaltyForm;
import com.jerodis.service.CompensationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class PenaltyController {

    private final CompensationService compensationService;

    @PostMapping("/pen")
    public void CreatePenalty(@Valid @RequestBody PenaltyForm penaltyForm) {
        compensationService.penaltySave(penaltyForm);
    }

    @PatchMapping("/pen")
    public void updatePenaltyYn(@Valid @RequestBody PenaltyForm penaltyForm) {
        compensationService.penaltyUpdate(penaltyForm.getVocNo());
    }
}
