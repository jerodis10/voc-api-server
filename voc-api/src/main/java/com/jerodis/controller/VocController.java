package com.jerodis.controller;

import com.jerodis.dto.PenaltyForm;
import com.jerodis.dto.VocForm;
import com.jerodis.dto.VocResponse;
import com.jerodis.service.VocService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class VocController {

    private final VocService vocService;

    @PostMapping("/voc")
    public void CreateVoc(@RequestBody VocForm vocForm) {
        vocService.vocSave(vocForm);
    }

    @GetMapping("/voc")
    public List<VocResponse> FindVoc() {
        return vocService.vocFindAll();
    }

}
