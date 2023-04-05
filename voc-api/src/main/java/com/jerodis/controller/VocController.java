package com.jerodis.controller;

import com.jerodis.dto.VocForm;
import com.jerodis.dto.VocResponse;
import com.jerodis.service.VocService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class VocController {

    private final VocService vocService;

    @GetMapping("/voc")
    public List<VocResponse> FindVoc() {
        return vocService.vocFindAll();
    }

    @PostMapping("/voc")
    public void CreateVoc(@Valid  @RequestBody VocForm vocForm) {
        vocService.vocSave(vocForm);
    }

    @PatchMapping("/voc")
    public void UpdateVoc(@Valid @RequestBody VocForm vocForm) {
        vocService.vocUpdate(vocForm);
    }

}
