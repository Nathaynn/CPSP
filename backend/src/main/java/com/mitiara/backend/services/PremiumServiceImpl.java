package com.mitiara.backend.services;

import com.mitiara.backend.models.Premium;
import com.mitiara.backend.repositories.PremiumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PremiumServiceImpl implements PremiumService {

    @Autowired
    private PremiumRepository premiumRepository;

    //create op
    @Override
    public ResponseEntity<Object> savePremium(Premium premium) {
        try {
            premiumRepository.save(premium);
            return ResponseEntity.ok(premium);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: Unable to save Premium" + e.getMessage());
        }
    }

    //read op
    @Override
    public ResponseEntity<Object> fetchPremium(Integer id) {
        Optional<Premium> premium = premiumRepository.findById(id);
        if (premium.isPresent()) {
            return ResponseEntity.ok(premium.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //update ops
    @Override
    public ResponseEntity<Object> updateName(Integer id, String name) {
        Optional<Premium> premium = premiumRepository.findById(id);
        if (premium.isPresent()) {
            Premium saved = premium.get();
            saved.setName(name);
            try {
                premiumRepository.save(saved);
                return ResponseEntity.ok(saved);
            } catch (Exception e) {
                return ResponseEntity.badRequest().body("Error: Unable to save Premium" + e.getMessage());
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<Object> updateDesc(Integer id, String desc) {
        Optional<Premium> premium = premiumRepository.findById(id);
        if (premium.isPresent()) {
            Premium saved = premium.get();
            saved.setDescription(desc);
            try {
                premiumRepository.save(saved);
                return ResponseEntity.ok(saved);
            } catch (Exception e) {
                return ResponseEntity.badRequest().body("Error: Unable to save Premium" + e.getMessage());
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<Object> updatePrice(Integer id, Integer price) {
        Optional<Premium> premium = premiumRepository.findById(id);
        if (premium.isPresent()) {
            Premium saved = premium.get();
            saved.setPrice(price);
            try {
                premiumRepository.save(saved);
                return ResponseEntity.ok(saved);
            } catch (Exception e) {
                return ResponseEntity.badRequest().body("Error: Unable to save Premium" + e.getMessage());
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<Void> deletePremium(Integer id) {
        Optional<Premium> premium = premiumRepository.findById(id);
        if (premium.isPresent()) {
            premiumRepository.delete(premium.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
