package com.mitiara.backend.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Schedule")

public class Schedule {

    @Id
    @GeneratedValue
    private Integer id;

    @NotNull
    @ManyToOne
    @JoinColumn(
            name = "vendor_id",
            nullable = false
    )
    private Vendor sVendor;

    @NotNull
    @Column(
            nullable = false
    )
    private String weekday;

    @NotNull
    @Column(
            nullable = false
    )
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime initTime;

    @NotNull
    @Column(
            nullable = false
    )
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endTime;

}
