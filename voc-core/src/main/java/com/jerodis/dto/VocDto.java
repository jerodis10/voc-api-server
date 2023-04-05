package com.jerodis.dto;

import com.jerodis.util.PartyType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class VocDto {

    private PartyType party;

    private String content;

    private Long amount;

    private String name;

}
