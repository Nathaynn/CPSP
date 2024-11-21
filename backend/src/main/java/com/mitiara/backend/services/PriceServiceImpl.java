package com.mitiara.backend.services;

import com.mitiara.backend.models.Price;
import com.mitiara.backend.repositories.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PriceServiceImpl implements PriceService {

    @Autowired
    private PriceRepository priceRepository;

    // create operation
    @Override
    public ResponseEntity<Object> savePrice(Price price) {
        try {
            priceRepository.save(price);
            return ResponseEntity.ok(price);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: Unable to save Price. " + e.getMessage());
        }
    }

    // read operation
    @Override
    public ResponseEntity<Object> fetchPrice(Integer id) {
        Optional<Price> price = priceRepository.findById(id);
        if (price.isPresent()) {
            return ResponseEntity.ok(price.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // update operations
    @Override
    public ResponseEntity<Object> updateCost(Integer id, Integer cost) {
        Optional<Price> price = priceRepository.findById(id);
        if (price.isPresent()) {
            Price saved = price.get();
            saved.setPriceCost(cost);
            try {
                priceRepository.save(saved);
                return ResponseEntity.ok(saved);
            } catch (Exception e) {
                return ResponseEntity.badRequest().body("Error: Invalid Cost, unable to save Price. " + e.getMessage());
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<Object> updateType(Integer id, String type) {
        Optional<Price> price = priceRepository.findById(id);
        if (price.isPresent()) {
            Price saved = price.get();
            saved.setPriceType(type);
            try {
                priceRepository.save(saved);
                return ResponseEntity.ok(saved);
            } catch (Exception e) {
                return ResponseEntity.badRequest().body("Error: Invalid Type, unable to save Price. " + e.getMessage());
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<Object> updateUnitName(Integer id, String unitName) {
        Optional<Price> price = priceRepository.findById(id);
        if (price.isPresent()) {
            Price saved = price.get();
            saved.setPriceType(unitName);
            try {
                priceRepository.save(saved);
                return ResponseEntity.ok(saved);
            } catch (Exception e) {
                return ResponseEntity.badRequest().body("Error: Invalid Unit Name, unable to save Price. " + e.getMessage());
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // delete operation
    @Override
    public ResponseEntity<Void> deletePrice(Integer id) {
        Optional<Price> price = priceRepository.findById(id);
        if (price.isPresent()) {
            priceRepository.delete(price.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
