package com.mitiara.backend.models;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingId implements Serializable {

    private Integer bClient;
    private Integer bReceipt;

}

