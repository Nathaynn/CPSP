package com.mitiara.backend.services;

import com.mitiara.backend.models.Price;
import org.springframework.http.ResponseEntity;

public interface PriceService {

    ResponseEntity<Object> savePrice(Price price);

    ResponseEntity<Object> fetchPrice(Integer id);

    ResponseEntity<Object> updateCost(Integer id, Integer cost);

    ResponseEntity<Object> updateType(Integer id, String type);

    ResponseEntity<Object> updateUnitName(Integer id, String unitName);

    ResponseEntity<Void> deletePrice(Integer id);
}
