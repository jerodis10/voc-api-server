package com.jerodis.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ExistType {
    YES("Y"),
    NO("N");

    private final String type;

}
