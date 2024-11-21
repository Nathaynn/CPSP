package com.mitiara.backend.models;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@IdClass(BookingId.class)
@Entity
@Table(name = "Booking")
public class Booking {

  @Id
  @NotNull
  @ManyToOne
  @JoinColumn(
          name = "client_id",
          nullable = false
  )
  private Client bClient;

  @Id
  @NotNull
  @OneToOne
  @JoinColumn(
          name = "receipt_id",
          nullable = false
  )
  private Receipt bReceipt;

  @NotNull
  @Column(
    updatable = false,
    nullable = false
  )
  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
  private LocalDateTime initialTime;

  @NotNull
  @Column(
    updatable = false,
    nullable = false
  )
  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
  private LocalDateTime endingTime;

  @NotNull
  @Column(
    updatable = false,
    nullable = false
  )
  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
  private LocalDateTime createdAt;

}
