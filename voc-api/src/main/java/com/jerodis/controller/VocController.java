package com.jerodis.controller;

import com.jerodis.dto.VocDto;
import com.jerodis.dto.VocResponse;
import com.jerodis.service.VocService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class VocController {

    private final VocService vocService;

    @PostMapping("/voc")
    public void CreateVoc(@RequestBody VocDto vocDto) {
        vocService.vocSave(vocDto);
    }

    @GetMapping("/voc")
    public List<VocResponse> FindVoc() {
        return vocService.findAll();
    }
}
