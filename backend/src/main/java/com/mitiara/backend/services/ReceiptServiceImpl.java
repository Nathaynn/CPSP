package com.mitiara.backend.services;

import com.mitiara.backend.models.Receipt;
import com.mitiara.backend.repositories.ReceiptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReceiptServiceImpl implements ReceiptService{

    @Autowired
    private ReceiptRepository receiptRepository;

    //create operations
    @Override
    public ResponseEntity<Object> saveReceipt(Receipt receipt) {
        try{
            receiptRepository.save(receipt);
            return ResponseEntity.ok(receipt);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: Unable to save Receipt" + e.getMessage());
        }
    }

    //read operations
    @Override
    public ResponseEntity<Object> fetchReceipt(Integer id){
        Optional<Receipt> receipt = receiptRepository.findById(id);

        if (receipt.isPresent()){
            return ResponseEntity.ok(receipt.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //update operations
    @Override
    public ResponseEntity<Object> updateEventType(Integer id, String eventType){
        Optional<Receipt> receipt = receiptRepository.findById(id);

        if (receipt.isPresent()){
            Receipt saved = receipt.get();
            saved.setEventType(eventType);
            try{
                receiptRepository.save(saved);
                return ResponseEntity.ok(saved);
            } catch (Exception e) {
                return ResponseEntity.badRequest().body("Error: Unable to save Receipt" + e.getMessage());
            }
        } else{
            return ResponseEntity.notFound().build();
        }

    }

    @Override
    public ResponseEntity<Object> updateDescription(Integer id, String description){
        Optional<Receipt> receipt = receiptRepository.findById(id);

        if (receipt.isPresent()){
            Receipt saved = receipt.get();
            saved.setDescription(description);
            try{
                receiptRepository.save(saved);
                return ResponseEntity.ok(saved);
            } catch (Exception e) {
                return ResponseEntity.badRequest().body("Error: Unable to save Receipt" + e.getMessage());
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @Override
    public ResponseEntity<Object> updateTotalNumGuests(Integer id, Integer totalNumGuests){
        Optional<Receipt> receipt = receiptRepository.findById(id);

        if (receipt.isPresent()){
            Receipt saved = receipt.get();
            saved.setTotalNumGuests(totalNumGuests);
            try{
                receiptRepository.save(saved);
                return ResponseEntity.ok(saved);
            } catch (Exception e) {
                return ResponseEntity.badRequest().body("Error: Unable to save Receipt" + e.getMessage());
            }
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    //delete operations
    @Override
    public ResponseEntity<Void> deleteReceipt(Integer id) {
        Optional<Receipt> receipt = receiptRepository.findById(id);

        if (receipt.isPresent()){
            receiptRepository.delete(receipt.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}

