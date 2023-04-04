package com.jerodis.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class CompensationForm {

    @NotNull
    private Long amount;

}
