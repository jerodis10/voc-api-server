package com.jerodis.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.jerodis.util.PartyType;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class VocForm {

    @NotNull
    @JsonProperty("voc_no")
    private String vocNo;

    @NotNull
    private PartyType party;

    @NotNull
    private String content;

}
