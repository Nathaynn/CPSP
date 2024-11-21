package com.mitiara.backend.controllers;

import com.mitiara.backend.models.Address;
import com.mitiara.backend.models.Vendor;
import com.mitiara.backend.services.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vendor")
public class VendorController {

    @Autowired
    private VendorService vendorService;

    @PostMapping("/")
    public ResponseEntity<Object> saveVendor(@RequestBody Vendor vendor) {
        return vendorService.saveVendor(vendor);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> fetchVendor(@PathVariable("id") Integer id) {
        return vendorService.fetchVendor(id);
    }

    @PutMapping("/description/{id}")
    public ResponseEntity<Object> updateDescription(@PathVariable("id") Integer id, @RequestBody String description) {
        return vendorService.updateDescription(id, description);
    }

    @PutMapping("/type/{id}")
    public ResponseEntity<Object> updateType(@PathVariable("id") Integer id, @RequestBody String type) {
        return vendorService.updateType(id, type);
    }

    @PutMapping("/address/{id}")
    public ResponseEntity<Object> updateType(@PathVariable("id") Integer id, @RequestBody Address address) {
        return vendorService.updateAddress(id, address);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVendor(@PathVariable("id") Integer id) {
        return vendorService.deleteVendor(id);
    }
}
