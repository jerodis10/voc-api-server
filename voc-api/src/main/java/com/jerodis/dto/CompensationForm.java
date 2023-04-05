package com.jerodis.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class CompensationForm {

    @NotNull
    @JsonProperty("voc_no")
    private String vocNo;

    @NotNull
    @Min(0)
    private Long amount;

}
