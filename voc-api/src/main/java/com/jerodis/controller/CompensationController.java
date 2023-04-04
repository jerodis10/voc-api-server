package com.jerodis.controller;

import com.jerodis.dto.CompensationForm;
import com.jerodis.dto.CompensationResponse;
import com.jerodis.dto.PenaltyForm;
import com.jerodis.service.CompensationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CompensationController {

    private final CompensationService compensationService;

    @PostMapping("/comp")
    public void CreateCompen(@RequestBody CompensationForm compensationForm) {
        compensationService.compensationSave(compensationForm);
    }

    @GetMapping("/comp")
    public List<CompensationResponse> FindVoc() {
        return compensationService.compensationFindAll();
    }

    @PostMapping("/pen")
    public void CreatePenalty(@RequestBody PenaltyForm penaltyForm) {
        compensationService.penaltySave(penaltyForm);
    }
}
