package com.jerodis.exception;

import lombok.Getter;

@Getter
public enum VocExceptionStatus {
    DUPLICATION_VOC("VOC_1000", "이미 해당 VOC 가 존재합니다."),
    NO_VOC("VOC_2000", "등록된 VOC 가 없습니다.");

    private final String statusCode;
    private final String message;

    VocExceptionStatus(String statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }
}
