package com.jerodis.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class VocForm {

    @NotNull
    private String party;

    @NotNull
    private String content;

}
