package com.jerodis.controller;

import com.jerodis.dto.CompensationForm;
import com.jerodis.dto.CompensationResponse;
import com.jerodis.dto.PenaltyForm;
import com.jerodis.service.CompensationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class CompensationController {

    private final CompensationService compensationService;


    @GetMapping("/comp")
    public List<CompensationResponse> FindVoc() {
        return compensationService.compensationFindAll();
    }

    @PostMapping("/comp")
    public void CreateCompensation(@Valid  @RequestBody CompensationForm compensationForm) {
        compensationService.compensationSave(compensationForm);
    }

}
