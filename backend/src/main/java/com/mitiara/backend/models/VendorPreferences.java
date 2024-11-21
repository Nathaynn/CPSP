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
@Table(
        name = "vendor_preferences"
)
public class VendorPreferences {

    @Id
    @GeneratedValue
    private Integer id;

    @OneToOne
    @NotNull
    @JoinColumn(
            name = "vendor_id",
            nullable = false,
            unique = true
    )

    private Vendor vpVendor;

    @NotNull
    @Column(
            name = "prep_days",
            nullable = false
    )
    private Integer prepDays;

    @NotNull
    @Column(
            name = "travel_distance",
            nullable = false
    )
    private Integer travelDistanceMiles;

    @NotNull
    @Column(
            name = "min_size",
            nullable = false
    )
    private Integer minSize;

    @NotNull
    @Column(
            name = "max_size",
            nullable = false
    )
    private Integer maxSize;

    @NotNull
    @Column(
            name = "last_minute",
            nullable = false
    )
    private Boolean lastMinute;
}
