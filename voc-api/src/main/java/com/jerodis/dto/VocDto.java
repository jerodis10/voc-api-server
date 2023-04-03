package com.jerodis.dto;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class VocDto {

    @NotNull
    private String party;

    @NotNull
    private String content;

    @Builder
    public VocDto(String party, String content) {
        this.party = party;
        this.content = content;
    }
}
