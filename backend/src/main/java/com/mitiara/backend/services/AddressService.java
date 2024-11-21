package com.mitiara.backend.services;

import com.mitiara.backend.dtos.AddressLinesDTO;
import com.mitiara.backend.models.Address;
import org.springframework.http.ResponseEntity;

public interface AddressService {
    //create op
    ResponseEntity<Object> createAddress(Address address);
    //get address
    ResponseEntity<Object> fetchAddress(Integer id);

    //update ops
    ResponseEntity<Object> updateLines(Integer id, AddressLinesDTO addressLines);


    ResponseEntity<Object> updateCity(Integer id, String city);

    ResponseEntity<Object> updateState(Integer id, String state);

    ResponseEntity<Object> updateCountry(Integer id, String country);

    ResponseEntity<Object> updatePostalCode(Integer id, String postalCode);
    //delete-op
    ResponseEntity<Void> deleteAddress(Integer id);
}
