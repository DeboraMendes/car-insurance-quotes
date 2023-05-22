package br.com.audsat.carinsurancequotes.exceptions;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class GlobalExceptionResponse {
    private final Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());
    private Integer status;
    private String error;
    private List<String> errors;
}
