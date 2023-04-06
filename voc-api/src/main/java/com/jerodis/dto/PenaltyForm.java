package com.jerodis.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;

@Getter
@NoArgsConstructor
public class PenaltyForm {

    @JsonProperty("voc_no")
    private String vocNo;

    private String name;

    @Min(0)
    @JsonProperty("amount")
    private Long amount;

    @Builder
    public PenaltyForm(String vocNo, String name, Long amount) {
        this.vocNo = vocNo;
        this.name = name;
        this.amount = amount;
    }
}
