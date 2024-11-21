package com.mitiara.backend.dtos;

import lombok.Data;

@Data
public class ServiceLimitsDTO {
    private int minBooking;
    private int maxBooking;
}
