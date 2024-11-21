package com.mitiara.backend.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Premium")
public class Premium {

    @Id
    @GeneratedValue
    private Integer id;

    @NotNull
    @ManyToOne
    @JoinColumn(
            name = "service_id",
            nullable = false
    )
    private Service pService;

    @ManyToMany(mappedBy = "rPremium")
    private List<Receipt> receipts;

    @NotNull
    @Column(
            nullable = false
    )
    private String name;

    @Column(
            length = 250
    )
    private String description;

    @NotNull
    @Column(
            name = "price",
            nullable = false
    )
    private Integer price;
}
