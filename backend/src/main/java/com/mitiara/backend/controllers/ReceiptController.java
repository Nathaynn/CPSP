package com.mitiara.backend.controllers;

import com.mitiara.backend.models.Receipt;
import com.mitiara.backend.services.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/receipt")
public class ReceiptController {

    @Autowired
    public ReceiptService receiptService;

    //create operation
    @PostMapping("/")
    public ResponseEntity<Object> addReceipt (@RequestBody Receipt receipt) {
        return receiptService.saveReceipt(receipt);
    }

    //read operation
    @GetMapping("/{id}")
    public ResponseEntity<Object> fetchReceipt (@PathVariable("id") Integer id) {
        return receiptService.fetchReceipt(id);
    }

    //update operations
    @PutMapping("/eventType/{id}")
    public ResponseEntity<Object> updateEventType (@PathVariable("id") Integer id, @RequestBody String receipt) {
        return receiptService.updateEventType(id, receipt);
    }

    @PutMapping("/description/{id}")
    public ResponseEntity<Object> updateDescription (@PathVariable("id") Integer id, @RequestBody String receipt) {
        return receiptService.updateDescription(id, receipt);
    }

    @PutMapping("/totalNumGuests/{id}")
    public ResponseEntity<Object> updateTotalNumGuests(@PathVariable("id") Integer id, @RequestBody Integer receipt) {
        return receiptService.updateTotalNumGuests(id, receipt);
    }

    //delete operation
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReceipt (@PathVariable("id") Integer id) {
        return receiptService.deleteReceipt(id);
    }
}
