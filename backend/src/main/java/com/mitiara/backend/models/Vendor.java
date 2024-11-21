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
@Table(name = "Vendor")
public class Vendor {

    @Id
    @GeneratedValue
    private Integer id;

    @OneToOne
    @JoinColumn(
            name = "address_id"
    )
    private Address vAddress;

    @NotNull
    @ManyToOne
    @JoinColumn(
            name = "client_id",
            nullable = false
    )
    private Client vClient;

    @OneToMany(mappedBy = "serVendor")
    private List<Service> services;

    @OneToMany(mappedBy = "sVendor")
    private List<Schedule> schedule;

    @OneToOne(mappedBy = "vpVendor")
    private VendorPreferences vendorPreferences;

    @NotNull
    @Column(
        name = "vendor_name",
        nullable = false
    )
    private String vendorName;

    @NotNull
    @Column(
            name = "vendor_type",
            nullable = false
    )
    private String vendorType;

    @Column(
            name = "vendor_description",
            length = 500
    )
    private String vendorDescription;

}
