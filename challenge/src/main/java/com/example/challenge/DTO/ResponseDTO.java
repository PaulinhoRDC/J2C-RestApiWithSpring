package com.example.challenge.DTO;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class ResponseDTO {
    private String message;
    private Map<String, List<String>> errors;
    private String error;

    public ResponseDTO(String message){this.message = message;}
}
