package com.mitiara.backend.controllers;

import com.mitiara.backend.dtos.AddressLinesDTO;
import com.mitiara.backend.models.Address;
import com.mitiara.backend.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/address")
public class AddressController {

    @Autowired
    private AddressService addressService;
    //create op
    @PostMapping("/")
    public ResponseEntity<Object> createAddress(@RequestBody Address address) { return addressService.createAddress(address); }
    //read op
    @GetMapping("/{id}")
    public ResponseEntity<Object> fetchAddress(@PathVariable Integer id) { return addressService.fetchAddress(id); }
    //update ops
    @PutMapping("/addressLines/{id}")
    public ResponseEntity<Object> updateLines(@PathVariable Integer id, @RequestBody AddressLinesDTO addressLines) {
        return addressService.updateLines(id, addressLines);}

    @PutMapping("/city/{id}")
    public ResponseEntity<Object> updateCity(@PathVariable Integer id, @RequestBody String city) {
        return addressService.updateCity(id, city);}

    @PutMapping("/state/{id}")
    public ResponseEntity<Object> updateState(@PathVariable Integer id, @RequestBody String state) {
        return addressService.updateState(id, state);}

    @PutMapping("/country/{id}")
    public ResponseEntity<Object> updateCountry(@PathVariable Integer id, @RequestBody String country) {
        return addressService.updateCountry(id, country);}

    @PutMapping("/postalCode/{id}")
    public ResponseEntity<Object> updatePostalCode(@PathVariable Integer id, @RequestBody String postalCode) {
        return addressService.updatePostalCode(id, postalCode);}

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable Integer id) { return addressService.deleteAddress(id);}

}
