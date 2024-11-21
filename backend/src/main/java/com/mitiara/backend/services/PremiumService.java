package com.mitiara.backend.services;

import com.mitiara.backend.models.Premium;
import org.springframework.http.ResponseEntity;

public interface PremiumService {
    // create op
    ResponseEntity<Object> savePremium(Premium premium);

    // read op
    ResponseEntity<Object> fetchPremium(Integer id);

    // update ops
    ResponseEntity<Object> updateName(Integer id, String name);

    ResponseEntity<Object> updateDesc(Integer id, String desc);

    ResponseEntity<Object> updatePrice(Integer id, Integer price);

    //delete op
    ResponseEntity<Void> deletePremium(Integer id);

}
