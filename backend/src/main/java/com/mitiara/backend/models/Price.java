package com.mitiara.backend.models;

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
@Table(name = "Price")
public class Price {

    @Id
    @GeneratedValue
    private Integer id;

    @OneToOne(
            mappedBy = "serPrice"
    )
    private Service service;

    @NotNull
    @Column(
            name = "price_num",
            nullable = false
    )
    private Integer priceCost;

    @NotNull
    @Column(
            name = "price_type",
            nullable = false
    )
    private String priceType;

    @Column(
            name = "unit_name"
    )
    private String unitName;

}