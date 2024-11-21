package com.mitiara.backend.dtos;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class BookingCreateDTO {

  private Integer receiptId;

  private Integer clientId;
  
  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
  private LocalDateTime initialTime;

  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
  private LocalDateTime endingTime;

  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
  private LocalDateTime createdAt;

}
