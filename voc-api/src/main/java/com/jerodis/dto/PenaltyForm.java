package com.jerodis.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class PenaltyForm {

    @NotNull
    @JsonProperty("p_voc_no")
    private String vocNo;

    @NotNull
    @JsonProperty("p_amount")
    private Long amount;

}
