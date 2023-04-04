package com.jerodis.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class VocDto {

    private String party;

    private String content;

    private Long amount;

//    @Builder
//    public VocDto(String party, String content) {
//        this.party = party;
//        this.content = content;
//    }
}
