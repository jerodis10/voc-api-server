package com.jerodis.exception;

import com.jerodis.response.CustomResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@RestControllerAdvice
public class ApiExceptionControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(VocException.class)
    public CustomResponse<Void> handleVocException(VocException e) {
        log.error("handleVocException : {}", e.getMessage());

        return CustomResponse.error(e.getErrorCode(), e.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public CustomResponse<Void> handleIllegalArgumentException(IllegalArgumentException e) {
        log.error("handleIllegalArgumentException : {}", e.getMessage());

        return CustomResponse.error(CommonExceptionStatus.WRONG_ARGUMENT.getCode(), CommonExceptionStatus.WRONG_ARGUMENT.getMessage());
    }

    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException e,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {
        log.warn("handleIllegalArgument", e);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(CustomResponse.error(CommonExceptionStatus.INTERNAL_SERVER_ERROR.getCode(), e.getMessage()));

//        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
//                .body(makeErrorResponse(HttpStatus.BAD_REQUEST, e.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public CustomResponse<Void> handleAllException(Exception e) {
        log.warn("handleAllException", e);

        return CustomResponse.error(CommonExceptionStatus.INTERNAL_SERVER_ERROR.getCode(), e.getMessage());
    }

//    private ErrorResponse makeErrorResponse(ErrorCode errorCode, String message) {
//        return ErrorResponse.builder()
//                .code(errorCode.name())
//                .message(message)
//                .build();
//    }


//    private ResponseEntity<ErrorResponse> handleExceptionInternal(ErrorCode errorCode) {
//        return ResponseEntity.status(errorCode.getHttpStatus())
//                .body(makeErrorResponse(errorCode));
//    }
//
//    private ErrorResponse makeErrorResponse(ErrorCode errorCode) {
//        return ErrorResponse.builder()
//                .code(errorCode.name())
//                .message(errorCode.getMessage())
//                .build();
//    }
//
//    private ResponseEntity<ErrorResponse> handleExceptionInternal(ErrorCode errorCode, String message) {
//        return ResponseEntity.status(errorCode.getHttpStatus())
//                .body(makeErrorResponse(errorCode, message));
//    }

//    private ResponseEntity<ErrorResponse> handleExceptionInternal(MethodArgumentNotValidException e, ErrorCode errorCode) {
//        return ResponseEntity.status(errorCode.getHttpStatus())
//                .body(makeErrorResponse(errorCode, e.getMessage()));
//    }

}
