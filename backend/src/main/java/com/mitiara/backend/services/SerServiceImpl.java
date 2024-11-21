package com.mitiara.backend.services;

import com.mitiara.backend.dtos.ServiceLimitsDTO;
import com.mitiara.backend.repositories.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SerServiceImpl implements SerService{

    @Autowired
    private ServiceRepository serviceRepository;

    // create operation
    @Override
    public ResponseEntity<Object> saveService(com.mitiara.backend.models.Service service) {
        try {
            com.mitiara.backend.models.Service saved = serviceRepository.save(service);
            return ResponseEntity.ok(saved);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: Unable to save Service. " + e.getMessage());
        }
    }

    // read operation
    @Override
    public ResponseEntity<Object> fetchService(Integer id) {
        Optional<com.mitiara.backend.models.Service> service = serviceRepository.findById((id));
        if (service.isPresent()) {
            return ResponseEntity.ok(service.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // update operations
    @Override
    public ResponseEntity<Object> updateDescription(Integer id, String description) {
        Optional<com.mitiara.backend.models.Service> service = serviceRepository.findById((id));
        if (service.isPresent()) {
            com.mitiara.backend.models.Service saved = service.get();
            saved.setDescription(description);
            try {
                serviceRepository.save(saved);
                return ResponseEntity.ok(saved);
            } catch (Exception e) {
                return ResponseEntity.badRequest().body("Error: Invalid Description, unable to save Service. " + e.getMessage());
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<Object> updateBookingLimits(Integer id, ServiceLimitsDTO bookingLimits) {
        Optional<com.mitiara.backend.models.Service> service = serviceRepository.findById(id);
        if (service.isPresent()) {
            com.mitiara.backend.models.Service saved = service.get();
            saved.setMinBooking(bookingLimits.getMinBooking());
            saved.setMaxBooking(bookingLimits.getMaxBooking());
            try {
                serviceRepository.save(saved);
                return ResponseEntity.ok(saved);
            } catch (Exception e) {
                return ResponseEntity.badRequest().body("Error: Invalid Description, unable to save Service. " + e.getMessage());
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<Void> deleteService(Integer id) {
        Optional<com.mitiara.backend.models.Service> service = serviceRepository.findById(id);
        if (service.isPresent()) {
            serviceRepository.delete(service.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
