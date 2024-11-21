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
@Table(name = "Receipt")
public class Receipt {

    @Id
    @GeneratedValue
    private Integer id;

    @ManyToMany
    @JoinTable(
            name = "receipt_premium",
            joinColumns = @JoinColumn(name = "receipt_id"),
            inverseJoinColumns = @JoinColumn(name = "premium_id")
    )
    private List<Premium> rPremium;

    @NotNull
    @ManyToOne
    @JoinColumn(
            name = "service_id",
            nullable = false
    )
    private Service rService;

    @OneToOne(mappedBy = "bReceipt")
    private Booking booking;

    @NotNull
    @Column(
            name = "event_type",
            nullable = false
    )
    private String eventType;

    @NotNull
    @Column(
            name = "number_guests",
            nullable = false
    )
    private Integer totalNumGuests;

    @Column(
            name = "receipt_description",
            length = 500
    )
    private String description;

}
