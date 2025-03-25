package com.multiverse.Snipper.exception;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
public class ErrorResponse {
  private LocalDateTime timestamp;
  private int status;
  private String message;
  private String details;
}
