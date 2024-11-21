package com.mitiara.backend.services;

import com.mitiara.backend.models.Address;
import com.mitiara.backend.models.Vendor;
import org.springframework.http.ResponseEntity;

public interface VendorService {

    //save op
    ResponseEntity<Object> saveVendor(Vendor vendor);

    //read op
    ResponseEntity<Object> fetchVendor(Integer id);

    //update ops
    ResponseEntity<Object> updateDescription(Integer id, String description);

    ResponseEntity<Object> updateType(Integer id, String type);

    ResponseEntity<Object> updateAddress(Integer id, Address address);

    //delete op
    ResponseEntity<Void> deleteVendor(Integer id);

}
