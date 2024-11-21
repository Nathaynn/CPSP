package com.mitiara.backend.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Client")
public class Client {

    @Id
    @GeneratedValue
    private Integer id;

    @OneToMany(
            mappedBy = "caClient",
            cascade = CascadeType.ALL
    )
    private List<ClientAddress> addresses;

    @OneToMany(mappedBy = "vClient")
    private List<Vendor> vendors;

    @Column(
            name = "user_bio",
            length = 500
    )
    private String userBio;

    @OneToMany(mappedBy = "bClient")
    private List<Booking> bookings;

    @NotNull
    @Column(
            unique = true,
            nullable = false
    )
    private String email;

    @NotNull
    @Column(
            nullable = false
    )
    private String password;

    @NotNull
    @Column(
            unique = true,
            nullable = false
    )
    private String username;

    @NotNull
    @Column(
            unique = true,
            nullable = false
    )
    private String phone;

    @Column(
            length = 50
    )
    private String firstName;

    @Column(
            length = 50
    )
    private String lastName;

    @NotNull
    @Column(
            nullable = false
    )
    private String role;

    @NotNull
    @Column(
            updatable = false,
            nullable = false
    )
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;

}