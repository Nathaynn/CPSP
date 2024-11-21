package com.mitiara.backend.models;

import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Address")
public class Address {

    @Id
    @GeneratedValue
    private Integer id;

    @OneToOne(mappedBy = "vAddress")
    private Vendor vendor;

    @OneToOne(mappedBy = "caAddress")
    private ClientAddress aClientAddress;

    @NotNull
    @Column(
            nullable = false
    )
    private String addressLine1;


    private String addressLine2;

    @NotNull
    @Size(max = 30)
    @Column(
            nullable = false,
            length = 50
    )
    private String city;

    @NotNull
    @Size(max = 30)
    @Column(
            nullable = false,
            length = 30
    )
    private String state;

    @NotNull
    @Column(
            nullable = false
    )
    private String country;

    @NotNull
    @Size(min = 5, max = 9)
    @Column(
            nullable = false
    )
    private String postalCode;

}
