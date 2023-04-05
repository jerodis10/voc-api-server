package com.jerodis.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jerodis.util.PartyType;
import lombok.Builder;
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

    @Builder
    public VocForm(String vocNo, PartyType party, String content) {
        this.vocNo = vocNo;
        this.party = party;
        this.content = content;
    }
}
