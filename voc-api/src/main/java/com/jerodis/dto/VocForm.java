package com.jerodis.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jerodis.util.PartyType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class VocForm {

    @JsonProperty("voc_no")
    private String vocNo;

    private PartyType party;

    private String content;

    @Builder
    public VocForm(String vocNo, PartyType party, String content) {
        this.vocNo = vocNo;
        this.party = party;
        this.content = content;
    }
}
