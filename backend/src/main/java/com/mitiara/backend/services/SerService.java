package com.mitiara.backend.services;

import com.mitiara.backend.dtos.ServiceLimitsDTO;
import com.mitiara.backend.models.Service;
import org.springframework.http.ResponseEntity;

public interface SerService {

    ResponseEntity<Object> saveService(Service service);

    ResponseEntity<Object> fetchService(Integer id);

    ResponseEntity<Object> updateDescription(Integer id, String description);

    ResponseEntity<Object> updateBookingLimits(Integer id, ServiceLimitsDTO bookingLimits);

    ResponseEntity<Void> deleteService(Integer id);

}
