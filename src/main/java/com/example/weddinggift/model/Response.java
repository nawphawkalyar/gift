package com.example.weddinggift.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
public class Response {

    private HttpStatus httpStatus;
    private String message;
}
