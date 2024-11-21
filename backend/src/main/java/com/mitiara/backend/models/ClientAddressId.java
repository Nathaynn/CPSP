package com.mitiara.backend.models;

import java.io.Serializable;

public class ClientAddressId implements Serializable {

    private Integer caClient;
    private Integer caAddress;

    public ClientAddressId(int caClient, int caAddress) {
        this.caClient = caClient;
        this.caAddress = caAddress;
    }
}
