package com.jerodis.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class PenaltyForm {

    @NotNull
    @JsonProperty("voc_no")
    private String vocNo;

    @NotNull
    private String name;

    @NotNull
    @Min(0)
    @JsonProperty("amount")
    private Long amount;

}
