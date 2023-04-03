package com.jerodis.controller;

import com.jerodis.dto.VocDto;
import com.jerodis.repository.VocRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class VocController {

    private final VocRepository vocRepository;

    @PostMapping("/voc")
    public void CreateVoc(
            @Validated @RequestBody VocDto vocDto
    ) {
        vocRepository.save(vocDto);
    }
}
