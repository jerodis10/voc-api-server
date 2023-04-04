package com.jerodis.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class VocException extends RuntimeException {

    private final ErrorCode errorCode;

}
