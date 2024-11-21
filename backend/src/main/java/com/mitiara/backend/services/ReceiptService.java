package com.mitiara.backend.services;

import com.mitiara.backend.models.Receipt;
import org.springframework.http.ResponseEntity;

public interface ReceiptService {

    //create operation
    ResponseEntity<Object> saveReceipt(Receipt receipt);

    //read operation
    ResponseEntity<Object> fetchReceipt(Integer receipt);

    //update operations
    ResponseEntity<Object> updateEventType(Integer id, String eventType);

    ResponseEntity<Object> updateDescription(Integer id, String description);

    ResponseEntity<Object> updateTotalNumGuests(Integer id, Integer totalNumGuests);

    //delete operation
    ResponseEntity<Void> deleteReceipt(Integer id);

}
