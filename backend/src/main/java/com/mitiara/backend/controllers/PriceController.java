package com.mitiara.backend.controllers;

import com.mitiara.backend.models.Price;
import com.mitiara.backend.services.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/price")
public class PriceController {

    @Autowired
    private PriceService priceService;

    // save operation
    @PostMapping("/")
    public ResponseEntity<Object> savePrice(@RequestBody Price price) {
        return priceService.savePrice(price);
    }

    // read operation
    @GetMapping("/{id}")
    public ResponseEntity<Object> fetchService(@PathVariable("id") Integer id) {
        return priceService.fetchPrice(id);
    }

    // update operations
    @PutMapping("/cost/{id}")
    public ResponseEntity<Object> updateCost(@PathVariable("id") Integer id, @RequestBody Integer cost) {
        return priceService.updateCost(id, cost);
    }

    @PutMapping("/type/{id}")
    public ResponseEntity<Object> updateType(@PathVariable("id") Integer id, @RequestBody String type) {
        return priceService.updateType(id, type);
    }

    @PutMapping("/unitname/{id}")
    public ResponseEntity<Object> updateUnitName(@PathVariable("id") Integer id, @RequestBody String unitName) {
        return priceService.updateUnitName(id, unitName);
    }

    // delete operation
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePrice(@PathVariable("id") Integer id) {
        return priceService.deletePrice(id);
    }
}
