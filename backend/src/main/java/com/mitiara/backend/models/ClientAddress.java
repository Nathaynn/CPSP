package com.mitiara.backend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@IdClass(ClientAddressId.class)
@Entity
@Table(name = "Client_Address")
public class ClientAddress {

    @Id
    @OneToOne
    @JoinColumn(
            name = "address_id"
    )
    private Address caAddress;

    @Id
    @ManyToOne
    @JoinColumn(
            name = "client_id"
    )
    private Client caClient;

}
