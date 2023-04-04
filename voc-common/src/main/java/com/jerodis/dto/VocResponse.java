package com.jerodis.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class VocResponse {

    private String party;

    private String content;

    @Builder
    public VocResponse(String party, String content) {
        this.party = party;
        this.content = content;
    }
}
