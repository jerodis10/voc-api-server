package com.jerodis.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CompensationDto {

    private Long amount;


    @Builder
    public CompensationDto(Long amount) {
        this.amount = amount;
    }
}
