package com.mitiara.backend.services;

import com.mitiara.backend.models.Address;
import com.mitiara.backend.models.Vendor;
import com.mitiara.backend.repositories.AddressRepository;
import com.mitiara.backend.repositories.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VendorServiceImpl implements VendorService {

    @Autowired
    private VendorRepository vendorRepository;

    @Autowired
    private AddressRepository addressRepository;


    @Override
    public ResponseEntity<Object> saveVendor(Vendor vendor) {
        try {
            vendorRepository.save(vendor);
            return ResponseEntity.ok(vendor);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: Unable to save Vendor" + e.getMessage());
        }
    }

    @Override
    public ResponseEntity<Object> fetchVendor(Integer id) {
        Optional<Vendor> vendor = vendorRepository.findById(id);
        if (vendor.isPresent()) {
            return ResponseEntity.ok(vendor.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<Object> updateDescription(Integer id, String description) {
        Optional<Vendor> vendor = vendorRepository.findById(id);
        if (vendor.isPresent()) {
            Vendor saved = vendor.get();
            saved.setVendorDescription(description);
            try {
                vendorRepository.save(saved);
                return ResponseEntity.ok(saved);
            } catch (Exception e) {
                return ResponseEntity.badRequest().body("Error: Unable to save Vendor" + e.getMessage());
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<Object> updateType(Integer id, String type) {
        Optional<Vendor> vendor = vendorRepository.findById(id);
        if (vendor.isPresent()) {
            Vendor saved = vendor.get();
            saved.setVendorType(type);
            try {
                vendorRepository.save(saved);
                return ResponseEntity.ok(saved);
            } catch (Exception e) {
                return ResponseEntity.badRequest().body("Error: Unable to save Vendor" + e.getMessage());
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<Object> updateAddress(Integer id, Address address) {
        Optional<Vendor> vendor = vendorRepository.findById(id);
        if (vendor.isPresent()) {
            Vendor saved = vendor.get();
            try {
                Address ad = addressRepository.save(address);
                addressRepository.delete(saved.getVAddress());
                saved.setVAddress(ad);
                vendorRepository.save(saved);
                return ResponseEntity.ok(saved);
            } catch (Exception e) {
                return ResponseEntity.badRequest().body("Error: Unable to save Vendor" + e.getMessage());
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<Void> deleteVendor(Integer id) {
        Optional<Vendor> vendor = vendorRepository.findById(id);
        if (vendor.isPresent()) {
            vendorRepository.delete(vendor.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
