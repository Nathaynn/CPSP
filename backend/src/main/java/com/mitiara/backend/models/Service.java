package com.mitiara.backend.models;

import java.time.LocalDateTime;
import java.util.List;

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
@Entity
@Table(name = "Service")
public class Service {

  @Id
  @GeneratedValue
  private Integer id;

  @NotNull
  @ManyToOne
  @JoinColumn(
          name = "vendor_id",
          nullable = false
  )
  private Vendor serVendor;

  @NotNull
  @OneToOne
  @JoinColumn(
          name = "price_id",
          nullable = false
  )
  private Price serPrice;

  @OneToMany(mappedBy = "pService")
  private List<Premium> premiums;

  @OneToMany(mappedBy = "rService")
  private List<Receipt> receipts;

  @OneToMany(mappedBy = "serviceRating")
  private List<Rating> ratings;

  @NotNull
  @Column(
          nullable = false,
          length = 400
  )
  private String description;

  @NotNull
  @Column(
          name = "min_booking",
          nullable = false
  )

  private Integer minBooking;

  @NotNull
  @Column(
          name = "max_booking",
          nullable = false
  )
  private Integer maxBooking;

  @NotNull
  @Column(
            updatable = false,
            nullable = false
  )
  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
  private LocalDateTime createdAt;


}