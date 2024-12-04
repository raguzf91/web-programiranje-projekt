package com.woltovo.woltovo.ExceptionHandler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.woltovo.woltovo.exceptions.ExceptionOdgovor;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class GlobalniExceptionHandler {
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionOdgovor> handleException(Exception e) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, "application/json");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                             .body(
                                ExceptionOdgovor.builder()
                                                .greska(e.getMessage())
                                                .httpKod("500")
                                                .build()
                             );
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ExceptionOdgovor> handleIllegalArgumentException(IllegalArgumentException e) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, "application/json");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                             .body(
                                ExceptionOdgovor.builder()
                                                .greska(e.getMessage())
                                                .httpKod("400")
                                                .build()
                             );
    }


}
