package com.mitiara.backend.controllers;

import com.mitiara.backend.dtos.ServiceLimitsDTO;
import com.mitiara.backend.services.SerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mitiara.backend.models.Service;

@RestController
@RequestMapping("api/service")
public class ServiceController {

    @Autowired
    private SerService serService;

    // save operation
    @PostMapping("/")
    public ResponseEntity<Object> saveServIce(@RequestBody Service service) {
        return serService.saveService(service);
    }

    // read operation
    @GetMapping("/{id}")
    public ResponseEntity<Object> fetchService(@PathVariable("id") Integer id) {
        return serService.fetchService(id);
    }

    // update operations
    @PutMapping("/description/{id}")
    public ResponseEntity<Object> updateDescription(@PathVariable("id") Integer id, @RequestBody String description) {
        return serService.updateDescription(id, description);
    }

    @PutMapping("/bookinglimit/{id}")
    public ResponseEntity<Object> updateDescription(@PathVariable("id") Integer id, @RequestBody ServiceLimitsDTO bookingLimits) {
        return serService.updateBookingLimits(id, bookingLimits);
    }

    // delete operations
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteService(@PathVariable("id") Integer id) {
        return serService.deleteService(id);
    }




}
