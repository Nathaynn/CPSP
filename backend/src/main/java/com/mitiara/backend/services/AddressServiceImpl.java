package com.mitiara.backend.services;

import com.mitiara.backend.dtos.AddressLinesDTO;
import com.mitiara.backend.models.Address;
import com.mitiara.backend.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    //create op
    @Override
    public ResponseEntity<Object> createAddress(Address address) {
        try{
            addressRepository.save(address);
            return ResponseEntity.ok(address);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: Unable to save Address. " + e.getMessage());
        }
    }
    //get op
    @Override
    public ResponseEntity<Object> fetchAddress(Integer id) {
        Optional<Address> address = addressRepository.findById(id);
        if (address.isPresent()) {
            return ResponseEntity.ok(address.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    // update ops
    @Override
    public ResponseEntity<Object> updateLines(Integer id, AddressLinesDTO addressLines) {
        Optional<Address> address = addressRepository.findById(id);
        if (address.isPresent()) {
            Address saved = address.get();
            saved.setAddressLine1(addressLines.getAddressLine1());
            saved.setAddressLine2(addressLines.getAddressLine2());
            try{
                addressRepository.save(saved);
                return ResponseEntity.ok(saved);
            } catch (Exception e) {
                return ResponseEntity.badRequest().body("Error: Unable to save Address. " + e.getMessage());
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @Override
    public ResponseEntity<Object> updateCity(Integer id, String city) {
        Optional<Address> address = addressRepository.findById(id);
        if (address.isPresent()) {
            Address saved = address.get();
            saved.setCity(city);
            try {
                addressRepository.save(saved);
                return ResponseEntity.ok(saved);
            } catch (Exception e) {
                return ResponseEntity.badRequest().body("Error: Unable to save Address. " + e.getMessage());
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @Override
    public ResponseEntity<Object> updateState(Integer id, String state) {
        Optional<Address> address = addressRepository.findById(id);
        if (address.isPresent()) {
            Address saved = address.get();
            saved.setState(state);
            try {
                addressRepository.save(saved);
                return ResponseEntity.ok(saved);
            } catch (Exception e) {
                return ResponseEntity.badRequest().body("Error: Unable to save Address. " + e.getMessage());
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<Object> updateCountry(Integer id, String country) {
        Optional<Address> address = addressRepository.findById(id);
        if (address.isPresent()) {
            Address saved = address.get();
            saved.setCountry(country);
            try {
                addressRepository.save(saved);
                return ResponseEntity.ok(saved);
            } catch (Exception e) {
                return ResponseEntity.badRequest().body("Error: Unable to save Address. " + e.getMessage());
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @Override
    public ResponseEntity<Object> updatePostalCode(Integer id, String postalCode) {
        Optional<Address> address = addressRepository.findById(id);
        if (address.isPresent()) {
            Address saved = address.get();
            saved.setPostalCode(postalCode);
            try {
                addressRepository.save(saved);
                return ResponseEntity.ok(saved);
            } catch (Exception e) {
                return ResponseEntity.badRequest().body("Error: Unable to save Address. " + e.getMessage());
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    //delete address op
    @Override
    public ResponseEntity<Void> deleteAddress(Integer id) {
        Optional<Address> address = addressRepository.findById(id);
        if (address.isPresent()) {
            addressRepository.delete(address.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
