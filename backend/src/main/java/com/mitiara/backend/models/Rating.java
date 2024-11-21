package com.mitiara.backend.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
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
@Table(name = "Rating")
public class Rating {

    @Id
    @GeneratedValue
    private Integer id;

    @Min(1)
    @Max(5)
    @NotNull
    @Column(
            nullable = false
    )
    private float ratingValue;

    @NotNull
    @Column(
            length = 150,
            nullable = false
    )
    private String header;


    @Column(
            length = 1000
    )
    private String comment;

    @NotNull
    @Column(
            updatable = false,
            nullable = false
    )
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "service_id")
    private Service serviceRating;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Client clientRating;
}
