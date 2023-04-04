package com.jerodis.controller;

import com.jerodis.dto.PenaltyForm;
import com.jerodis.dto.VocForm;
import com.jerodis.dto.VocResponse;
import com.jerodis.service.CompensationService;
import com.jerodis.service.VocService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class VocController {

    private final VocService vocService;
    private final CompensationService compensationService;

    @PostMapping("/voc")
    public void CreateVoc(@RequestBody VocForm vocForm) {
        vocService.vocSave(vocForm);
    }

    @GetMapping("/voc")
    public List<VocResponse> FindVoc() {
        return vocService.vocFindAll();
    }

    @PatchMapping("/voc")
    public void UpdateVoc(@RequestBody VocForm vocForm) {
        vocService.vocUpdate(vocForm);
    }

}
