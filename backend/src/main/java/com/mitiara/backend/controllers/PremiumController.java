package com.mitiara.backend.controllers;

import com.mitiara.backend.models.Premium;
import com.mitiara.backend.services.PremiumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/premium")
public class PremiumController {

    @Autowired
    private PremiumService premiumService;

    //save op
    @PostMapping("/")
    public ResponseEntity<Object> savePremium(@RequestBody Premium premium) {
        return premiumService.savePremium(premium);
    }

    //create op
    @GetMapping("/{id}")
    public ResponseEntity<Object> fetchPremium(@PathVariable("id") Integer id) {
        return premiumService.fetchPremium(id);
    }

    //update ops
    @PutMapping("/name/{id}")
    public ResponseEntity<Object> updateName(@PathVariable("id") Integer id, @RequestBody String name) {
        return premiumService.updateName(id, name);
    }

    @PutMapping("/description/{id}")
    public ResponseEntity<Object> updateDesc(@PathVariable("id") Integer id, @RequestBody String description) {
        return premiumService.updateDesc(id, description);
    }

    @PutMapping("/price/{id}")
    public ResponseEntity<Object> updateDesc(@PathVariable("id") Integer id, @RequestBody Integer price) {
        return premiumService.updatePrice(id, price);
    }

    //delete op
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePremium(@PathVariable("id") Integer id) {
        return premiumService.deletePremium(id);
    }
}
