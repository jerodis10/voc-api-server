package com.jerodis.exception;

public class VocException extends CommonException {

    public VocException(VocExceptionStatus vocExceptionStatus) {
        super(vocExceptionStatus.getMessage(), vocExceptionStatus.getStatusCode());
    }
}
