package com.jerodis.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CompensationResponse {

    private Long amount;

    @Builder
    public CompensationResponse(Long amount) {
        this.amount = amount;
    }
}
