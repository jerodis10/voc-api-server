package com.jerodis.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class CompensationForm {

    @NotNull
    @JsonProperty("c_voc_no")
    private String vocNo;

    @NotNull
    private Long amount;

}
