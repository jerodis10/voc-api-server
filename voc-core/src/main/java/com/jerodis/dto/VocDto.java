package com.jerodis.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class VocDto {

    private String party;

    private String content;

    @Builder
    public VocDto(String party, String content) {
        this.party = party;
        this.content = content;
    }
}
