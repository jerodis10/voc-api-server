package com.jerodis.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class VocResponse {

    private String party;

    private String content;

    private Long amount;

//    @Builder
//    public VocResponse(String party, String content) {
//        this.party = party;
//        this.content = content;
//    }

}
