package com.jerodis.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum VocErrorCode implements ErrorCode{

    BAD_REQUEST(HttpStatus.BAD_REQUEST, "주로 API에 필요한 필수 파라미터와 관련하여 서버가 클라이언트 오류를 감지해 요청을 처리하지 못한 상태입니다."),
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "해당 리소스에 유효한 인증 자격 증명이 없어 요청에 실패한 상태입니다."),
    FORBIDDEN(HttpStatus.FORBIDDEN, "서버에 요청이 전달되었지만, 권한 때문에 거절된 상태입니다."),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "서버 에러를 총칭하는 에러 코드로, 요청을 처리하는 과정에서 서버가 예상하지 못한 상황에 놓인 상태입니다."),
    BAD_GATEWAY(HttpStatus.BAD_GATEWAY, "서로 다른 프로토콜을 연결해주는 게이트웨이가 잘못된 프로토콜을 연결하거나 연결된 프로토콜에 문제가 있어 통신이 제대로 되지 않은 상태입니다."),
    SERVICE_UNAVAILABLE(HttpStatus.SERVICE_UNAVAILABLE, "서버가 요청을 처리할 준비가 되지 않은 상태입니다.");

    private final HttpStatus httpStatus;
    private final String message;

}